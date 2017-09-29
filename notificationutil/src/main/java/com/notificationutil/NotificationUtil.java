package com.notificationutil;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by clickapps on 20/9/17.
 */

public class NotificationUtil {
    private volatile Context context;
    private static volatile NotificationUtil sNotificationUtil;

    private NotificationUtil() {

    }

    private NotificationUtil(@NonNull Context context) {
        this.context = context;
    }

    /**
     * Get web connect.
     *
     * @return the web connect
     */
    public static NotificationUtil get(@NonNull Context context) {
        if (sNotificationUtil == null) {
            synchronized (NotificationUtil.class) {
                if (sNotificationUtil == null) {
                    sNotificationUtil = new NotificationUtil(context);
                }
            }
        }
        return sNotificationUtil;
    }

    public void cancel(int identifier) {
        android.app.NotificationManager notifyManager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notifyManager.cancel(identifier);
    }

    public void cancel(String tag, int identifier) {
        android.app.NotificationManager notifyManager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notifyManager.cancel(tag, identifier);
    }

    /**
     * With builder.
     *
     * @param context the context
     * @return the builder
     */
    public static Builder with(@NonNull Context context) {
        return new Builder(context);
    }

}
