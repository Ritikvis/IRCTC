package com.Railway.Railway.Controller;


import com.Railway.Railway.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("Passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;


    // GET API to find the number of passengers traveling between two cities on a specific date
    @GetMapping("/passengers/count")
    public Long countPassengers(
            @RequestParam("source") String source,
            @RequestParam("destination") String destination,
            @RequestParam("date") String date) {
        System.out.println(source);
        System.out.println(destination);
        System.out.println(date);

        // Call the service method to get the count of passengers
        return passengerService.countPassengersFromSourceToDestinationOnDate(source, destination, date);
    }

//http://localhost:8080/passengers/count?source=delhi&destination=Jaipur&date=2024-11-21

    // GET API to find female passengers by age range and destination
    @GetMapping("/passengers/female/count")
    public Long countFemalePassengers(
            @RequestParam int ageX,
            @RequestParam int ageY,
            @RequestParam String destination) {
        return passengerService.countFemalePassengersByAgeAndDestination(ageX, ageY, destination);
    }

}
