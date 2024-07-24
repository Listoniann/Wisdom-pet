package com.listonian.wisdompet.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "SERVICES")
@Data
@ToString
public class ServiceEntity {
    @Id
    @Column(name = "SERVICE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Double price;
}
