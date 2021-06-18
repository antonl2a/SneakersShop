package com.shop.web;

import com.shop.models.service.SneakerViewModel;
import com.shop.repositories.SneakerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sneakers")
public class SneakersRestController {
    private final SneakerRepository sneakerRepository;
    private final ModelMapper modelMapper;

    public SneakersRestController(SneakerRepository sneakerRepository, ModelMapper modelMapper) {
        this.sneakerRepository = sneakerRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api")
    public ResponseEntity<List<SneakerViewModel>> findAll() {
        List<SneakerViewModel> sneakers = sneakerRepository.
                findAll().
                stream().
                map(se -> {
                    SneakerViewModel sneakerViewModel = modelMapper.map(se, SneakerViewModel.class);
                    return sneakerViewModel;
                }).collect(Collectors.toList());

        return ResponseEntity.ok().body(sneakers);
    }
}
