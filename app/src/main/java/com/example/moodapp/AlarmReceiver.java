package com.example.moodapp;


    import android.app.NotificationManager;
    import android.app.PendingIntent;
    import android.app.TaskStackBuilder;
    import android.content.BroadcastReceiver;
    import android.content.Context;
    import android.content.Intent;
    import android.graphics.BitmapFactory;

    import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver{

    private static final String CHANNEL_ID = "com.singhajit.notificationDemo.channelId";

    //    called when class gets triggered
    @Override
    public void onReceive(Context context, Intent intent) {


        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // destination after the notification clicked (felling tracker )
        Intent notificationIntent = new Intent(context, signup.class);

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(Setting.class);//Parent Activity
        stackBuilder.addNextIntent(notificationIntent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT );

        // notification build and style
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setContentIntent(pendingIntent)
                .setContentTitle("Mood")
                .setContentText("How are you feeling today?")
                .setSmallIcon(R.drawable.ic_star)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_app_png))
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        if (intent.getAction().equals("MY_NOTIFICATION_MESSAGE")) {
            notificationManager.notify(100,builder.build());
        }

    }

}