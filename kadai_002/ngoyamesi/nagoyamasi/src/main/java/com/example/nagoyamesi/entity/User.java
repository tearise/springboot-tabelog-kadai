package com.example.nagoyamesi.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "users")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "furigana")
	private String furigana;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "post_code")
	private String postCode;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "telephone_number")
	private String telephoneNumber;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "enabled")
    private Boolean enabled;
    
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    
    @Column(name = "update_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
}
