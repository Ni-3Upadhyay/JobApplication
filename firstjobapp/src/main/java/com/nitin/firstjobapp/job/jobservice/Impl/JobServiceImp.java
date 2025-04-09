package com.nitin.firstjobapp.job.jobservice.Impl;

import com.nitin.firstjobapp.job.Repository.JobRepository;
import com.nitin.firstjobapp.job.jobentitiy.Job;
import com.nitin.firstjobapp.job.jobservice.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobServiceImp implements JobService {

//    private List<Job> jobs = new ArrayList<>();
    private JobRepository jobRepository;

    public JobServiceImp(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id){

        return jobRepository.findById(id).orElse(null);
    }


    @Override
    public void createJob(Job job) {

        jobRepository.save(job);
    }

    public Job deleteJobBYId(Long id) {
        Job deletedJob = jobRepository.findById(id).orElse(null);
        jobRepository.deleteById(id);

        return deletedJob;
    }

    @Override
    public Job updateJobBYId(Job job) {

        Optional<Job> findJob = jobRepository.findById(job.getId());

            if(findJob.isPresent()){
                Job updatedJob = findJob.get();
                updatedJob.setDescription(job.getDescription());
                updatedJob.setTitle(job.getTitle());
                updatedJob.setMaxSalary(job.getMaxSalary());
                updatedJob.setMinSalary(job.getMinSalary());
                updatedJob.setLocation(job.getLocation());
                updatedJob.setCompany(job.getCompany());
                jobRepository.save(updatedJob);
                return updatedJob;
            }

        return null;
    }
}
