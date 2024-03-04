package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Fine {
    @Id
    @Column(nullable = false)
    private  int fine_id ;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "Customer_id")
    private CustomerDetails customer;

    @Column(nullable=false)
    private int amount;
}
