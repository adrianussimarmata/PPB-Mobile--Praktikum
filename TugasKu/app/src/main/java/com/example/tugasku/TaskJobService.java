package com.example.tugasku;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TaskJobService extends JobService {

    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private static final String NOTIFICATION_TITLE = "Sudah cek tugas hari ini ?";
    private static final String NOTIFICATION_MESSAGE = "Yuk cek tugas kamu hari ini.";
    private static final String SHOW_TIME = "10:00:00";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        doBackground();
        TaskScheduleJob.scheduleJob(getApplicationContext());
        return false;
    }

    private void doBackground() {
        Calendar calendar2 = Calendar.getInstance();
        SimpleDateFormat formatter2 = new SimpleDateFormat("h:mm:ss");
        String currentTime = formatter2.format(calendar2.getTime());

        if (currentTime.equals(SHOW_TIME)) {
            createNotificationChannel();
            makeNotification(NOTIFICATION_TITLE, NOTIFICATION_MESSAGE, getApplicationContext());
        }
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Notification description");
            channel.enableVibration(true);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    static void makeNotification(String title, String message, Context context) {
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, LihatActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL_ID)
                .setContentIntent(pendingIntent)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(1, builder.build());
    }
}
