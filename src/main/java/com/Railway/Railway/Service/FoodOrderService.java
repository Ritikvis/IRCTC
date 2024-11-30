package com.Railway.Railway.Service;

import com.Railway.Railway.Models.FoodOrder;
import com.Railway.Railway.Models.Passenger;
import com.Railway.Railway.Models.Train;
import com.Railway.Railway.Repository.FoodOrderRepository;
import com.Railway.Railway.Repository.PassengerRepository;
import com.Railway.Railway.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FoodOrderService {
    @Autowired
    private FoodOrderRepository foodOrderRepository;



    public String addFoodOrder(FoodOrder foodOrder) {
        // Save the FoodOrder entity to the database
        foodOrderRepository.save(foodOrder);
        return "Food order added successfully!";
    }

    public Long getTrainWithMaxOrdersOnDate(String date) {


        List<FoodOrder> allOrders = foodOrderRepository.findAll();

        Map<Long, Integer> trainOrderCount = new HashMap<>();

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
