package com.example.nagoyamesi.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "image_name", length = 200)
    private String imageName;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "opening_hours", nullable = false)
    private String openingHours;

    @Column(name = "telephone_number", nullable = false)
    private String telephoneNumber;
    
    //@OneToMany
    @JoinColumn(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "regular_closing", nullable = false)
    private String regularClosing;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

    

}
