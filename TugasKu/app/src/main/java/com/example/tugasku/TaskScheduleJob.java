package com.example.tugasku;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

public class TaskScheduleJob {
    static void scheduleJob(Context context) {

        ComponentName serviceComponent = new ComponentName(context, TaskJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent)
                .setRequiresCharging(false)
                .setRequiresDeviceIdle(false)
                .setPeriodic(15*60*1000);

        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(builder.build());
    }
}
