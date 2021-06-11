package com.shop.web;

import com.shop.models.binding.SneakerQuestionBindingModel;
import com.shop.models.service.SneakerQuestionServiceModel;
import com.shop.services.SneakerQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/sneakers")
public class SneakerQuestionController {

    private final SneakerQuestionService sneakerQuestionService;
    private final ModelMapper modelMapper;

    public SneakerQuestionController(SneakerQuestionService sneakerQuestionService, ModelMapper modelMapper) {
        this.sneakerQuestionService = sneakerQuestionService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("sneakerQuestionBindingModel")
    public SneakerQuestionBindingModel createBindingModel()
    {
        return new SneakerQuestionBindingModel();
    }

    @GetMapping("/ask")
    public String sneakerQuestion() {

        return "sneaker-question";
    }

    @PostMapping("/ask")
    public String sneakerQuestionPost(@Valid SneakerQuestionBindingModel sneakerQuestionBindingModel,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes,
                                      @RequestParam("issueImg") MultipartFile img) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("sneakerQuestionBindingModel", sneakerQuestionBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.sneakerQuestionBindingModel", bindingResult);
            return "redirect:/sneakers/ask";
        }

        SneakerQuestionServiceModel sneakerQuestionServiceModel = new SneakerQuestionServiceModel();
        sneakerQuestionServiceModel.setIssueImg(img);
        sneakerQuestionServiceModel.setQuestion(sneakerQuestionBindingModel.getQuestion());
        sneakerQuestionServiceModel.setRecommendations(sneakerQuestionBindingModel.getRecommendations());
        sneakerQuestionService.addQuestion(sneakerQuestionServiceModel);


        return "redirect:/home";
    }
}
