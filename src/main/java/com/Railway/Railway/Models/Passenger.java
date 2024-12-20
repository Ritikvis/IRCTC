package com.Railway.Railway.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private String date;
    private String age;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "train_no")
    private Train train;
    @OneToMany(mappedBy = "passenger",cascade = CascadeType.ALL)
    private List<FoodOrder> foodOrders = new ArrayList<>();
}
