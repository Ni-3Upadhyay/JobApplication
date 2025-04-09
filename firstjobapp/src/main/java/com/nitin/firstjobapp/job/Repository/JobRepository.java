package com.nitin.firstjobapp.job.Repository;

import com.nitin.firstjobapp.job.jobentitiy.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {


}
