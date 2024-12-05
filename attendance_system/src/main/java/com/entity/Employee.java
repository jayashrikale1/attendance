package com.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Employee Details
    private String email;
    private String username;
    private String password;
    private String name;
    private String empId;  // This will be generated programmatically
    private String designation;
    private String location;

    // Bank Information
    private String payMode;
    private String bankName;
    private String bankAccountNumber;
    private String ifscCode;
    private double grossSalary;

    // Constructor with parameters
    public Employee(Long id, String email, String username, String password, String name, String empId,
                    String designation, String location, String payMode, String bankName, 
                    String bankAccountNumber, String ifscCode ,double grossSalary ) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.empId = empId;
        this.designation = designation;
        this.location = location;
        this.payMode = payMode;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.ifscCode = ifscCode;
        this.grossSalary = grossSalary;

    }
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public double getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", name=" + name + ", empId=" + empId + ", designation=" + designation + ", location=" + location
				+ ", payMode=" + payMode + ", bankName=" + bankName + ", bankAccountNumber=" + bankAccountNumber
				+ ", ifscCode=" + ifscCode + ", grossSalary=" + grossSalary + "]";
	}
	
    
}
