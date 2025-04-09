package com.nitin.firstjobapp.job.jobcontroller;

import com.nitin.firstjobapp.job.jobentitiy.Job;
import com.nitin.firstjobapp.job.jobservice.Impl.JobServiceImp;
import com.nitin.firstjobapp.job.jobservice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class JobController {


    private JobServiceImp jobService;

    public JobController(JobServiceImp jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());

    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){

        Job job = jobService.getJobById(id);
        if(job != null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/jobs")
    public ResponseEntity<String> createJobs(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("job added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<Job> deleteJobById(@PathVariable Long id){
        Job job = jobService.deleteJobBYId(id);
       if(job != null){
        return new ResponseEntity<>(job,HttpStatus.OK);}
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs")
    public ResponseEntity<String> updateJobById(@RequestBody Job job){
        Job updated_job = jobService.updateJobBYId(job);
        if(updated_job == null){
            return new ResponseEntity<>("Did not found a job by id : " + job.getId(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("update job with id : " + job.getId(), HttpStatus.OK);
    }


    

}
