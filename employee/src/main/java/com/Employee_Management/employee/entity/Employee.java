package com.Employee_Management.employee.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.mapping.Value;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is Required")
    @Size(min = 2, max = 50, message = "name must be 2 or 50 characters")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "Email is invalid")
    @Column(unique = true)
    private String email;


    @NotBlank(message = "phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be exactly 10 digits")
    private String contact;

    @NotBlank(message = "Department is required")
    private String department;

    @Min(value = 10000, message ="Salary must be at least 10000" )
    @Max(value = 100000, message = "salary should not more than 100000")
    private double salary;

    @NotNull(message = "date of joining required")
    @PastOrPresent(message = "Date of joining cannot be the future date ")
    private LocalDate doj;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }
}
