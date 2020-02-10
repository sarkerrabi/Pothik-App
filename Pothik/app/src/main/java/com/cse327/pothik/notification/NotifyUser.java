package com.cse327.pothik.notification;


import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import com.cse327.pothik.R;

/**
 * Created by Sarker Rabi on 14-12-17.
 */

public class NotifyUser  {
    private Context context;
    private Class aClass;
    private boolean isNotify;


//    NotificationCompat.Builder notification;
    private static final int uniqueID = 5536;
    public NotifyUser(Context context,Class aClass){
        this.aClass = aClass;
        this.context = context;
        this.isNotify = true;

    }

    public void sendNotification(){
        if (isNotify){
            NotificationManager notManager = (NotificationManager)this.context.getSystemService(this.context.NOTIFICATION_SERVICE);
            Intent intent = new Intent(this.context.getApplicationContext(), this.aClass);
            PendingIntent pendingIntent = PendingIntent.getActivity(this.context.getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder notification = new NotificationCompat.Builder(this.context.getApplicationContext());

            notification.setSmallIcon(R.drawable.pathik_logo);


            notification.setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.drawable.pathik_logo));
            notification.setTicker("Oh hooo its pathik");
            notification.setContentTitle("here is the tittle");
            notification.setContentText("I am the text for your notification");

            Notification notifi1 = notification.build();
            notManager.notify(uniqueID,notifi1);
        }


    }
    public void setNotifyOFF(){
        this.isNotify= false;
    }
    public void setNotifyON(){
        this.isNotify=true;
    }

}
