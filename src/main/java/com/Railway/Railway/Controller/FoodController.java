package com.Railway.Railway.Controller;

import com.Railway.Railway.Models.FoodOrder;
import com.Railway.Railway.Models.Passenger;
import com.Railway.Railway.Models.Train;
import com.Railway.Railway.Repository.PassengerRepository;
import com.Railway.Railway.Repository.TrainRepository;
import com.Railway.Railway.Service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Food")
public class FoodController {
    @Autowired
    private FoodOrderService foodOrderService;
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private PassengerRepository passengerRepository;



//    http://localhost:8080/Food/add?ticketId=3&trainNo=4
    @PostMapping("/add")
    public ResponseEntity<String> addFoodOrder(@RequestBody FoodOrder foodOrder,
                                               @RequestParam Long ticketId,
                                               @RequestParam Long trainNo) {
        Train train = trainRepository.findById(trainNo).
                orElseThrow(()-> new RuntimeException("Id not found"));
        Passenger passenger = passengerRepository.findById(ticketId).
                orElseThrow(()-> new RuntimeException("Id not found"));


        foodOrder.setPassenger(passenger);
        foodOrder.setTrain(train);

        String response = foodOrderService.addFoodOrder(foodOrder);
        return ResponseEntity.ok(response);
    }


// http://localhost:8080/Food/train/max-orders?date=2024-11-21
    @GetMapping("/train/max-orders")
    public Long getTrainWithMaxOrders(
            @RequestParam("date") String date) {
        return foodOrderService.getTrainWithMaxOrdersOnDate(date);
    }
}
