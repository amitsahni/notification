package com.notificationutil;

import android.widget.RemoteViews;

/**
 * Created by clickapps on 29/9/17.
 */

public class Custom extends NotifyBuilder {
    public Custom(NotificationModel model, int identifier, String tag) {
        super(model, identifier, tag);
        createRemoteViews();
    }

    @Override
    public void build() {
        super.build();
        super.notificationNotify();
    }


    private RemoteViews createRemoteViews() {
        RemoteViews remoteViews = new RemoteViews(model.context.getPackageName(), R.layout.notification_custom_content);
        remoteViews.setImageViewResource(R.id.image_icon, model.smallIcon);
        remoteViews.setTextViewText(R.id.text_title, model.title);
        remoteViews.setTextViewText(R.id.text_message, model.message);
        remoteViews.setImageViewResource(R.id.image_end, model.largeIcon);
//        model.builder.setCustomHeadsUpContentView(remoteViews);
        model.builder.setCustomBigContentView(remoteViews);
        return remoteViews;
    }
}
