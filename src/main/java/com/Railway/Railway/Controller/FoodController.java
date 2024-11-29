package com.Railway.Railway.Controller;

import com.Railway.Railway.Service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Food")
public class FoodController {
    @Autowired
    private FoodOrderService foodOrderService;

    // GET API to find the TrainId with maximum orders on a specific date
    @GetMapping("/train/max-orders")
    public Long getTrainWithMaxOrders(
            @RequestParam("date") String date) {
        return foodOrderService.getTrainWithMaxOrdersOnDate(date);
    }
}
