package com.hicap.springbatch;

import com.hicap.springbatch.model.RetailerDetails;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunScheduler {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public RunScheduler() {
    }

    public void run() {
        try {
            String Ret_data = new RetailerDetails().toString();
            JobParameters param = new JobParametersBuilder().addString("date", Ret_data).toJobParameters();
            System.out.println(Ret_data);
            JobExecution execution = jobLauncher.run(job, param);
            System.out.println("Exit Status : " + execution.getStatus());
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
