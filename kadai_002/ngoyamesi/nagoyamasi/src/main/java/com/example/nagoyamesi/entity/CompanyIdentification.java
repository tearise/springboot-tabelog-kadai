package com.example.nagoyamesi.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "company_identification")
public class CompanyIdentification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_name", length = 200, nullable = false)
    private String companyName;

    @Column(name = "representative_director", length = 100, nullable = false)
    private String representativeDirector;

    @Column(name = "date_establishment", nullable = false)
    private Integer dateEstablishment;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "telephone_number", nullable = false)
    private Integer telephoneNumber;

    @Column(name = "business_content", length = 255, nullable = false)
    private String businessContent;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

    

}
