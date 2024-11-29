package com.Railway.Railway.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TrainNo;
    private String Source;
    private String Destination;
    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    private List<Passenger> passengers = new ArrayList<>();
    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    private List<FoodOrder> foodOrders = new ArrayList<>();

}
