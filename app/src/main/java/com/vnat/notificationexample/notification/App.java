package com.vnat.notificationexample.notification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.vnat.notificationexample.MainActivity;

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

//public class NotificationReceiver extends BroadcastReceiver {
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        String message = intent.getStringExtra("toastMessage");
//        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
//    }
//}

//    String title = mBinding.edtTitle.getText().toString();
//    String message = mBinding.edtMessage.getText().toString();
//
//    Intent intent = new Intent(this, MainActivity.class);
//    PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
//
//    Intent boardcastIntent = new Intent(this, NotificationReceiver.class);
//            boardcastIntent.putExtra("toastMessage", message);
//                    PendingIntent actionIntent = PendingIntent.getBroadcast(this, 0, boardcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//                    Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.captain_america);
//
//                    Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
//                    .setSmallIcon(R.drawable.ic_one)
//                    .setLargeIcon(largeIcon)
//                    .setSubText("Sub Text")
//
//                    .setContentTitle(title)
//                    .setContentText(message)
////                    .setStyle(new NotificationCompat.InboxStyle()
////                            .addLine("This is line 1")
////                            .addLine("This is line 2")
////                            .addLine("This is line 3")
////                            .addLine("This is line 4")
////                            .addLine("This is line 5")
////                    )
//
//                    .setPriority(NotificationCompat.PRIORITY_HIGH)
//                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                    .setContentIntent(contentIntent)
//                    .setVibrate(new long[]{1000, 1000})
//                    .setSound(Settings.System.DEFAULT_ALARM_ALERT_URI)
//                    .setColor(Color.BLUE)
//                    .setAutoCancel(true)
//                    .setOnlyAlertOnce(true)
//
//                    .addAction(R.drawable.ic_favorite, "Toast", actionIntent)
//                    .build();
//
//                    mNotificationManager.notify(1, notification);