package com.notificationutil;

import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * Created by clickapps on 20/9/17.
 */

public class NotificationModel {

    Context context;
    PendingIntent pendingIntent;
    int notificationId;
    String tag;
    String title;
    String message;
    int smallIcon;
    int largeIcon;
    NotificationCompat.Builder builder;
}
