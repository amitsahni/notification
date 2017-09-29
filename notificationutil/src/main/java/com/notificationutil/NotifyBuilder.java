package com.notificationutil;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;


/**
 * Created by clickapps on 28/9/17.
 */

public abstract class NotifyBuilder {
    private static final String TAG = NotifyBuilder.class.getSimpleName();
    protected String tag;
    protected Notification notification;
    protected NotificationModel model;
    protected int notificationId;

    public NotifyBuilder(NotificationModel model, int identifier, String tag) {
        this.model = model;
        this.notificationId = identifier;
        this.tag = tag;
    }

    public void build() {
        notification = model.builder.build();
    }

    public void setBigContentView(RemoteViews views) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            notification.bigContentView = views;
            return;
        }
        Log.w(TAG, "Version does not support big content view");
    }

    protected Notification notificationNotify() {
        if (tag != null) {
            return notificationNotify(tag, notificationId);
        }
        return notificationNotify(notificationId);
    }

    protected Notification notificationNotify(int identifier) {
        NotificationManager notificationManager =
                (NotificationManager) model.context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(identifier, notification);
        return notification;
    }

    protected Notification notificationNotify(String tag, int identifier) {
        NotificationManager notificationManager =
                (NotificationManager) model.context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(tag, identifier, notification);
        return notification;
    }

}
