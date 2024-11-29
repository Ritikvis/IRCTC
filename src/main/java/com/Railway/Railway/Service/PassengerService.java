package com.Railway.Railway.Service;

import com.Railway.Railway.Models.Passenger;
import com.Railway.Railway.Models.Train;
import com.Railway.Railway.Repository.PassengerRepository;
import com.Railway.Railway.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private PassengerRepository passengerRepository;


    public Long countPassengersFromSourceToDestinationOnDate(String source, String destination, String date) {
        long count = 0;

        // Fetch all passengers
        List<Passenger> allPassengers = passengerRepository.findAll();

        for (Passenger passenger : allPassengers) {
            if (passenger.getTrain().getSource().equalsIgnoreCase(source)
                    && passenger.getTrain().getDestination().equalsIgnoreCase(destination)
                    && passenger.getDate().equals(date)) {
                count++;
            }
        }

        return count;
    }



    public Long countFemalePassengersByAgeAndDestination(int ageX, int ageY, String destination) {

        long count = 0;


        List<Passenger> allPassengers = passengerRepository.findAll();


        for (Passenger passenger : allPassengers) {
            int age = Integer.parseInt(passenger.getAge()); // Convert age to integer
            if (passenger.getGender().equalsIgnoreCase("female")
                    && age >= ageX && age <= ageY
                    && passenger.getTrain().getDestination().equalsIgnoreCase(destination)) {
                count++;
            }
        }

        return count;
    }


    public Passenger addPassenger(Long trainId, Passenger passenger) {
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new RuntimeException("Train not found with ID: " + trainId));
        passenger.setTrain(train);
        return passengerRepository.save(passenger);
    }
}
