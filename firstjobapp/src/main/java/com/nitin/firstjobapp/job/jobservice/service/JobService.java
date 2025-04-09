package com.nitin.firstjobapp.job.jobservice.service;

import com.nitin.firstjobapp.job.jobentitiy.Job;

import java.util.List;


public interface JobService {

    Job getJobById(Long id);


    List<Job> findAll();
    void createJob(Job job);

    Job deleteJobBYId(Long id);

    Job updateJobBYId(Job job);
}
