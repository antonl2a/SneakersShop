package com.shop.aop;

import com.shop.models.binding.OrderBindingModel;
import com.shop.models.entities.SneakerEntity;
import com.shop.models.service.SneakerViewModel;
import com.shop.repositories.SneakerRepository;
import com.shop.services.LogService;
import com.shop.services.SneakerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private final LogService logService;
    private final SneakerService sneakerService;
    private final ModelMapper modelMapper;

    public LogAspect(LogService logService, SneakerService sneakerService, ModelMapper modelMapper) {
        this.logService = logService;
        this.sneakerService = sneakerService;
        this.modelMapper = modelMapper;
    }


    @Pointcut("execution(* com.shop.web.SneakerController.orderSneaker(..))")
    public void track() {
    }

    @After("track()")
    public void afterAdvice(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        OrderBindingModel o = (OrderBindingModel) args[0];
        Long sneakerId = o.getSneakerId();
        SneakerViewModel sneakerViewModel = sneakerService.getSneakerById(sneakerId);
        int orderCount = o.getQuantity();

        logService.createLog(sneakerId, orderCount);
    }
}
