package com.notificationutil;

import android.support.v4.app.NotificationCompat;

/**
 * Created by clickapps on 28/9/17.
 */

public class Progress extends NotifyBuilder {

    public Progress(NotificationModel builder, int identifier, String tag) {
        super(builder, identifier, tag);
    }

    @Override
    public void build() {
        super.build();
        super.notificationNotify();
    }

    public Progress update(int identifier, int progress, int max, boolean indeterminate) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(model.context);
        builder.setProgress(max, progress, indeterminate);

        notification = builder.build();
        notificationNotify(identifier);
        return this;
    }

    public Progress value(int progress, int max, boolean indeterminate) {
        model.builder.setProgress(max, progress, indeterminate);
        return this;
    }
}
