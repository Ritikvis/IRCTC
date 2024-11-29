package com.Railway.Railway.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Passenger passenger;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "train_no")
    private Train train;

}
