package com.vnat.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;

import com.vnat.notificationexample.databinding.ActivityMainBinding;
import com.vnat.notificationexample.notification.App;
import com.vnat.notificationexample.notification.NotificationReceiver;

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

            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);

            Intent boardcastIntent = new Intent(this, NotificationReceiver.class);
            boardcastIntent.putExtra("toastMessage", message);
            PendingIntent actionIntent = PendingIntent.getBroadcast(this, 0, boardcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.captain_america);

            Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                    .setSmallIcon(R.drawable.ic_one)
                    .setLargeIcon(largeIcon)
                    .setSubText("Sub Text")

                    .setContentTitle(title)
                    .setContentText(message)
//                    .setStyle(new NotificationCompat.InboxStyle()
//                            .addLine("This is line 1")
//                            .addLine("This is line 2")
//                            .addLine("This is line 3")
//                            .addLine("This is line 4")
//                            .addLine("This is line 5")
//                    )

                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setContentIntent(contentIntent)
                    .setVibrate(new long[]{1000, 1000})
                    .setSound(Settings.System.DEFAULT_ALARM_ALERT_URI)
                    .setColor(Color.BLUE)
                    .setAutoCancel(true)
                    .setOnlyAlertOnce(true)

                    .addAction(R.drawable.ic_favorite, "Toast", actionIntent)
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
                    .setStyle(new NotificationCompat.InboxStyle()
                            .addLine("This is line 1")
                            .addLine("This is line 2")
                            .addLine("This is line 3")
                            .addLine("This is line 4")
                            .addLine("This is line 5")
                            .setBigContentTitle("Big Content Title")
                            .setSummaryText("Summary Text")
                    )

                    .setPriority(NotificationCompat.PRIORITY_LOW)
//                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setVibrate(new long[]{1000, 1000})
                    .setSound(Settings.System.DEFAULT_ALARM_ALERT_URI)
                    .build();

            mNotificationManager.notify(2, notification);
        });
    }

}