package com.Railway.Railway.Controller;

import com.Railway.Railway.Models.Passenger;
import com.Railway.Railway.Models.Train;
import com.Railway.Railway.Service.PassengerService;
import com.Railway.Railway.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("train")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @Autowired
    private PassengerService passengerService;



//   http://localhost:8080/train/add-train
    @PostMapping("/add-train")
    public Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }


//    http://localhost:8080/train/add-passenger/6
    @PostMapping("/add-passenger/{trainId}")
    public Passenger addPassenger(@PathVariable Long trainId, @RequestBody Passenger passenger) {
        return passengerService.addPassenger(trainId, passenger);
    }




}
