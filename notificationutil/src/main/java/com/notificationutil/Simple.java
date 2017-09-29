package com.notificationutil;

/**
 * Created by clickapps on 28/9/17.
 */

public class Simple extends NotifyBuilder {

    public Simple(NotificationModel builder, int identifier, String tag) {
        super(builder, identifier, tag);
    }

    @Override
    public void build() {
        super.build();
        super.notificationNotify();
    }
}
