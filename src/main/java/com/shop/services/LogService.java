package com.shop.services;

import com.shop.models.service.LogServiceModel;

import java.util.List;

public interface LogService {
    void createLog(Long sneakerId, int orderCount);

    List<LogServiceModel> findAllLogs();
}
