package com.vnat.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.provider.Settings;

import com.vnat.notificationexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private NotificationManagerCompat mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        //mBinding.setHandler(this);
        setContentView(mBinding.getRoot());

        initControls();
        initListeners();
    }

    private void initControls() {
        mNotificationManager = NotificationManagerCompat.from(this);

    }

    private void initListeners() {
        mBinding.btnChannel1.setOnClickListener(v -> {
            String title = mBinding.edtTitle.getText().toString();
            String message = mBinding.edtMessage.getText().toString();

            Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setVibrate(new long[]{1000,1000})
                    .setSound(Settings.System.DEFAULT_ALARM_ALERT_URI)
                    .build();

            mNotificationManager.notify(1, notification);
        });

        mBinding.btnChannel2.setOnClickListener(v -> {
            String title = mBinding.edtTitle.getText().toString();
            String message = mBinding.edtMessage.getText().toString();

            Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_2_ID)
                    .setSmallIcon(R.drawable.ic_two)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_LOW)
//                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setVibrate(new long[]{1000,1000})
                    .setSound(Settings.System.DEFAULT_ALARM_ALERT_URI)
                    .build();

            mNotificationManager.notify(2, notification);
        });
    }

}