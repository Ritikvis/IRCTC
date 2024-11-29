package com.Railway.Railway.Service;

import com.Railway.Railway.Models.FoodOrder;
import com.Railway.Railway.Repository.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodOrderService {
    @Autowired
    private FoodOrderRepository foodOrderRepository;

    public Long getTrainWithMaxOrdersOnDate(String date) {
        // Fetch all food orders
        List<FoodOrder> allOrders = foodOrderRepository.findAll();

        // Map to store trainId and its respective order count
        Map<Long, Integer> trainOrderCount = new HashMap<>();

        // Count orders for each train on the given date
        for (FoodOrder order : allOrders) {
            if (order.getPassenger().getDate().equals(date)) {
                Long trainId = order.getTrain().getTrainNo();
                trainOrderCount.put(trainId, trainOrderCount.getOrDefault(trainId, 0) + 1);
            }
        }

        // Find the trainId with the maximum number of orders
        Long maxTrainId = null;
        int maxOrders = 0;
        for (Map.Entry<Long, Integer> entry : trainOrderCount.entrySet()) {
            if (entry.getValue() > maxOrders) {
                maxTrainId = entry.getKey();
                maxOrders = entry.getValue();
            }
        }

        return maxTrainId;
    }
}
