package com.Railway.Railway.Service;

import com.Railway.Railway.Models.Train;
import com.Railway.Railway.Repository.PassengerRepository;
import com.Railway.Railway.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private PassengerRepository passengerRepository;


    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }
}
