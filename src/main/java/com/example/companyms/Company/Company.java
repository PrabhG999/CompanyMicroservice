package com.example.companyms.Company;

import com.example.jobapplication.Job.Job;
import com.example.jobapplication.Review.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Company")
public class Company {
    //map every company to list of jobs
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("company")
    private List<Job> jobs;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("company")
    private List<Review> reviews;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    public Company() { //constructor for JPA
    }

    public Company(int id, String name, String description, List<Job> jobs, List<Review> reviews) { //constructor for CompanyIMPL
        this.id = id;
        this.name = name;
        this.description = description;
        this.jobs = jobs != null ? jobs : new ArrayList<>();
        this.reviews =reviews != null ? reviews : new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
