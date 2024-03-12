package com.telusko.controller;

import com.telusko.model.JobPost;
import com.telusko.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {


    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    //controller method for getting all jobs
//	@CrossOrigin
    @GetMapping("/Jobs")
    public List<JobPost> getAllJobPosts() {
        return jobService.getAllJobs();

    }


    //************************************************************


    //controller method to get a Job  By Id
//	@CrossOrigin
    @GetMapping("/Job/{id}")
    public JobPost getJobPostById(@PathVariable int id) {
        return jobService.getJob(id);
    }


    //************************************************************


    //controller method to add a job
    //@CrossOrigin
    @PostMapping("/Job")
    public JobPost addJobPost(@RequestBody JobPost jobPost) {
        return jobService.addJob(jobPost);
    }


    //************************************************************


    //controller method to delete a job
    @DeleteMapping("/Job/{id}")
    //@CrossOrigin
    public String deleteJobPostById(@PathVariable int id) {
        return jobService.deleteJob(id);

    }

    //controller method to update a job
    @PutMapping("/Job/{id}")
    public JobPost updateJobPost(@PathVariable int id, @RequestBody JobPost jobPost) {
        return jobService.updateJob(id, jobPost);
    }

}