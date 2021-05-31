package com.shop.web;

import com.shop.models.binding.SneakerAddBindingModel;
import com.shop.models.service.SneakerAddServiceModel;
import com.shop.services.SneakerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/sneakers")
public class SneakerController {


    private final ModelMapper modelMapper;
    private final SneakerService sneakerService;

    public SneakerController(ModelMapper modelMapper, SneakerService sneakerService) {
        this.modelMapper = modelMapper;
        this.sneakerService = sneakerService;
    }

    @ModelAttribute("sneakerAddBindingModel")
    public SneakerAddBindingModel createBindingModel() {
        return new SneakerAddBindingModel();
    }

    @GetMapping("/add")
    public String addSneaker() {
        return "sneakers-add";
    }

    @PostMapping("/add")
    public String addSneakerPost(@Valid SneakerAddBindingModel sneakerAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("sneakerAddBindingModel", sneakerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.sneakerAddBindingModel", bindingResult);
            return "redirect:/sneakers/add";
        }

        if (sneakerService.sneakerExists(sneakerAddBindingModel.getSneakerImgUrl())) {
            redirectAttributes.addFlashAttribute("sneakerAddBindingModel", sneakerAddBindingModel);
            redirectAttributes.addFlashAttribute("sneakerExistsError", true);
            return "redirect:/sneakers/add";
        }

        SneakerAddServiceModel sneakerAddServiceModel = modelMapper.map(sneakerAddBindingModel, SneakerAddServiceModel.class);

        sneakerService.addSneaker(sneakerAddServiceModel);

        return "redirect:/home";
    }
}
