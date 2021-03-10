package com.vnat.notificationexample;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

public class App extends Application {
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificatonChannels();
    }

    private void createNotificatonChannels() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is chanel 1");

            NotificationChannel channel2 = new NotificationChannel(CHANNEL_2_ID, "Channel 2", NotificationManager.IMPORTANCE_LOW);
            channel1.setDescription("This is chanel 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}

//    String title = mBinding.edtTitle.getText().toString();
//    String message = mBinding.edtMessage.getText().toString();
//
//    Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
//            .setSmallIcon(R.drawable.ic_one)
//            .setContentTitle(title)
//            .setContentText(message)
//            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//            .setVibrate(new long[]{1000,1000})
//            .setSound(Settings.System.DEFAULT_ALARM_ALERT_URI)
//            .build();
//
//            mNotificationManager.notify(1, notification);