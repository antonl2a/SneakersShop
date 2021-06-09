package com.shop.web;

import com.shop.models.binding.OrderBindingModel;
import com.shop.models.binding.SneakerAddBindingModel;
import com.shop.models.service.SneakerAddServiceModel;
import com.shop.models.service.SneakerViewModel;
import com.shop.services.SneakerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/sneakers")
public class SneakerController
{

    private final ModelMapper modelMapper;
    private final SneakerService sneakerService;

    public SneakerController(ModelMapper modelMapper, SneakerService sneakerService)
    {
        this.modelMapper = modelMapper;
        this.sneakerService = sneakerService;
    }

    @ModelAttribute("sneakerAddBindingModel")
    public SneakerAddBindingModel createBindingModel()
    {
        return new SneakerAddBindingModel();
    }

    @GetMapping("/add")
    public ModelAndView addSneaker()
    {
        ModelAndView modelAndView = new ModelAndView("sneakers-add");
        modelAndView.addObject("allBrands", sneakerService.getAllBrands());
        modelAndView.addObject("allConditions", sneakerService.getAllConditions());

        return modelAndView;
    }

    @PostMapping("/add")
    public String addSneakerPost(@Valid SneakerAddBindingModel sneakerAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes)
    {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("sneakerAddBindingModel", sneakerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.sneakerAddBindingModel", bindingResult);
            return "redirect:/sneakers/add";
        }

        SneakerAddServiceModel sneakerAddServiceModel = modelMapper.map(sneakerAddBindingModel, SneakerAddServiceModel.class);

        sneakerService.addSneaker(sneakerAddServiceModel);

        return "redirect:/home";
    }

    @GetMapping("/all")
    public ModelAndView getAllSneakers()
    {
        ModelAndView mav = new ModelAndView("sneakers-list");
        mav.addObject("sneakers", sneakerService.getSneakers());

        return mav;
    }

    @PostMapping("/order")
    @ResponseBody
    public ResponseEntity<String> orderSneaker(@RequestBody OrderBindingModel orderBindingModel)
    {
        SneakerViewModel sneaker = sneakerService.getSneakerById(orderBindingModel.getSneakerId());
        if (orderBindingModel.getQuantity() < 0 || orderBindingModel.getQuantity() > sneaker.getQuantity()) {
            return ResponseEntity.badRequest().body("Input quantity exceeds existing quantity");
        }

        sneakerService.orderSneaker(orderBindingModel.getSneakerId(), orderBindingModel.getQuantity());

        return ResponseEntity.ok("Successfully ordered sneaker");
    }
}
