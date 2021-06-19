package com.shop.services.impl;

import com.shop.models.entities.LogEntity;
import com.shop.models.entities.SneakerEntity;
import com.shop.models.entities.UserEntity;
import com.shop.models.service.LogServiceModel;
import com.shop.repositories.LogRepository;
import com.shop.services.LogService;
import com.shop.services.SneakerService;
import com.shop.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final SneakerService sneakerService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public LogServiceImpl(LogRepository logRepository, SneakerService sneakerService, UserService userService, ModelMapper modelMapper) {
        this.logRepository = logRepository;
        this.sneakerService = sneakerService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createLog(Long sneakerId, int orderCount) {

        SneakerEntity sneakerEntity = sneakerService.
                findEntityById(sneakerId);

        Authentication authentication = SecurityContextHolder.
                getContext().getAuthentication();

        String username = authentication.getName();
        UserEntity userEntity = userService.findByName(username);

        LogEntity logEntity = new LogEntity();
        logEntity.setUserEntity(userEntity);
        logEntity.setSneakerEntity(sneakerEntity);
        logEntity.setDateTime(LocalDateTime.now());
        logEntity.setOrderCount(orderCount);

        logRepository.save(logEntity);
    }

    @Override
    public List<LogServiceModel> findAllLogs() {
        return logRepository.
                findAll().
                stream().
                map(le -> {
                    LogServiceModel logServiceModel = modelMapper.map(le, LogServiceModel.class);
                    logServiceModel.setSneakerEntity(le.getSneakerEntity().getSneakerBrand().toString());
                    logServiceModel.setUserEntity(le.getUserEntity().getUsername());
                    return logServiceModel;
                }).
                collect(Collectors.toList());
    }
}
