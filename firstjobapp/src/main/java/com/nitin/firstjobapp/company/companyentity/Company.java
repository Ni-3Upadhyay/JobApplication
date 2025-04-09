package com.nitin.firstjobapp.company.companyentity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nitin.firstjobapp.job.jobentitiy.Job;
import com.nitin.firstjobapp.reviews.ReviewEntity.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;


    @OneToMany(mappedBy = "company")
    private List<Review> reviews;



    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public Company(){}

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
