package com.notificationutil;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.widget.RemoteViews;


/**
 * Created by clickapps on 20/9/17.
 */

public class Builder {
    private NotificationModel model;

    public Builder(@NonNull Context context) {
        model = new NotificationModel();
        model.builder = new NotificationCompat.Builder(context);
        model.context = context;
        model.pendingIntent = PendingIntent.getBroadcast(context, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);
        model.builder.setContentIntent(model.pendingIntent);
    }

    public Builder identifier(int identifier) {
        if (identifier <= 0) {
            throw new IllegalStateException("Identifier Should Not Be Less Than Or Equal To Zero!");
        }
        model.notificationId = identifier;
        return this;
    }

    public Builder tag(@NonNull String tag) {
        model.tag = tag;
        return this;
    }

    public Builder title(String title) {
        if (title == null) {
            throw new IllegalStateException("Title Must Not Be Null!");
        }

        if (title.trim().length() == 0) {
            throw new IllegalArgumentException("Title Must Not Be Empty!");
        }
        model.title = title;
        model.builder.setContentTitle(title);
        return this;
    }

    public Builder message(@NonNull String message) {
        if (message.trim().length() == 0) {
            throw new IllegalArgumentException("Message Must Not Be Empty!");
        }
        model.message = message;
        model.builder.setContentText(message);
        return this;
    }

    public Builder color(@ColorRes int color) {
        if (color <= 0) {
            throw new IllegalArgumentException("Resource ID Should Not Be Less Than Or Equal To Zero!");
        }
        int notificationColor = -1;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            notificationColor = color;
        } else {
//            notificationColor = ContextCompat.getColor(model.context, color);
        }
        model.builder.setColor(ContextCompat.getColor(model.context, color));
        return this;
    }

    public Builder ticker(@NonNull String ticker) {
        if (ticker == null) {
            throw new IllegalStateException("Ticker Must Not Be Null!");
        }

        if (ticker.trim().length() == 0) {
            throw new IllegalArgumentException("Ticker Must Not Be Empty!");
        }

        model.builder.setTicker(ticker);
        return this;
    }

    public Builder when(long when) {
        if (when <= 0) {
            throw new IllegalArgumentException("Resource ID Should Not Be Less Than Or Equal To Zero!");
        }
        model.builder.setWhen(when);
        return this;
    }

    public Builder style(@NonNull NotificationCompat.Style style) {
        model.builder.setStyle(style);
        return this;
    }

    public Builder bigTextStyle(@NonNull String bigTextStyle) {
        if (bigTextStyle.trim().length() == 0) {
            throw new IllegalArgumentException("Big Text Style Must Not Be Empty!");
        }
        return bigTextStyle(bigTextStyle, null);
    }

    public Builder bigTextStyle(@NonNull String bigTextStyle, String summaryText) {
        if (bigTextStyle.trim().length() == 0) {
            throw new IllegalArgumentException("Big Text Style Must Not Be Empty!");
        }
        NotificationCompat.BigTextStyle bigStyle = new NotificationCompat.BigTextStyle();
        bigStyle.bigText(bigTextStyle);
        if (summaryText != null) {
            bigStyle.setSummaryText(summaryText);
        }
        model.builder.setStyle(bigStyle);
        return this;
    }

    public Builder inboxStyle(@NonNull String[] inboxLines, @NonNull String title, String summary) {
        if (inboxLines.length <= 0) {
            throw new IllegalArgumentException("Inbox Lines Must Have At Least One Text!");
        }

        if (title.trim().length() == 0) {
            throw new IllegalArgumentException("Title Must Not Be Empty!");
        }
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        for (String inboxLine : inboxLines) {
            inboxStyle.addLine(inboxLine);
        }
        inboxStyle.setBigContentTitle(title);
        if (summary != null) {
            inboxStyle.setSummaryText(summary);
        }
        model.builder.setStyle(inboxStyle);
        return this;
    }

    public Builder autoCancel(boolean autoCancel) {
        model.builder.setAutoCancel(autoCancel);
        return this;
    }

    public Builder ongoing(boolean ongoing) {
        model.builder.setOngoing(ongoing);
        return this;
    }

    public Builder smallIcon(@DrawableRes int smallIcon) {
        model.smallIcon = smallIcon;
        model.builder.setSmallIcon(smallIcon);
        return this;
    }

    public Builder largeIcon(@NonNull Bitmap bitmap) {
        model.builder.setLargeIcon(bitmap);
        return this;
    }

    public Builder largeIcon(@DrawableRes int largeIcon) {
        if (largeIcon <= 0) {
            throw new IllegalArgumentException("Resource ID Should Not Be Less Than Or Equal To Zero!");
        }
        model.largeIcon = largeIcon;
        Bitmap bitmap = BitmapFactory.decodeResource(model.context.getResources(), largeIcon);
        model.builder.setLargeIcon(bitmap);
        return this;
    }

    public Builder group(@NonNull String groupKey) {
        if (groupKey == null) {
            throw new IllegalStateException("Ticker Must Not Be Null!");
        }
        if (groupKey.trim().length() == 0) {
            throw new IllegalArgumentException("Group Key Must Not Be Empty!");
        }
        model.builder.setGroup(groupKey);
        return this;
    }

    public Builder groupSummary(boolean groupSummary) {
        model.builder.setGroupSummary(groupSummary);
        return this;
    }

    public Builder number(int number) {
        model.builder.setNumber(number);
        return this;
    }

    public Builder vibrate(@NonNull long[] vibrate) {
        for (long aVibrate : vibrate) {
            if (aVibrate <= 0) {
                throw new IllegalArgumentException("Vibrate Time " + aVibrate + " Invalid!");
            }
        }
        model.builder.setVibrate(vibrate);
        return this;
    }

    public Builder lights(int color, int ledOnMs, int ledOfMs) {
        if (ledOnMs < 0) {
            throw new IllegalStateException("Led On Milliseconds Invalid!");
        }

        if (ledOfMs < 0) {
            throw new IllegalStateException("Led Off Milliseconds Invalid!");
        }

        model.builder.setLights(color, ledOnMs, ledOfMs);
        return this;
    }

    public Builder sound(@NonNull Uri sound) {
        model.builder.setSound(sound);
        return this;
    }

    public Builder onlyAlertOnce(boolean onlyAlertOnce) {
        model.builder.setOnlyAlertOnce(onlyAlertOnce);
        return this;
    }

    public Builder addPerson(@NonNull String uri) {
        if (uri.length() == 0) {
            throw new IllegalArgumentException("URI Must Not Be Empty!");
        }
        model.builder.addPerson(uri);
        return this;
    }

    public Builder button(@DrawableRes int icon, @NonNull String title, @NonNull PendingIntent pendingIntent) {
        model.builder.addAction(icon, title, pendingIntent);
        return this;
    }

    public Builder click(@NonNull Class<?> activity, @Nullable Bundle bundle) {
        Intent clickIntentBroadcast = new Intent(model.context, activity);
        clickIntentBroadcast.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        clickIntentBroadcast.setPackage(model.context.getPackageName());
        if (bundle != null) {
            clickIntentBroadcast.putExtras(bundle);
        }
        PendingIntent pendingIntent = PendingIntent.getActivity(model.context, model.notificationId, clickIntentBroadcast,
                PendingIntent.FLAG_UPDATE_CURRENT);
        model.builder.setContentIntent(pendingIntent);
        return this;
    }

    public Builder click(@NonNull Class<?> activity) {
        click(activity, null);
        return this;
    }

    public Builder click(@Nullable Bundle bundle) {
        Intent clickIntentBroadcast = new Intent();
        clickIntentBroadcast.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        clickIntentBroadcast.setPackage(model.context.getPackageName());
        if (bundle != null) {
            clickIntentBroadcast.putExtras(bundle);
        }
        PendingIntent pendingIntent = PendingIntent.getActivity(model.context, model.notificationId, clickIntentBroadcast,
                PendingIntent.FLAG_UPDATE_CURRENT);
        model.builder.setContentIntent(pendingIntent);
        return this;
    }

    public Builder click(@NonNull PendingIntent pendingIntent) {
        model.builder.setContentIntent(pendingIntent);
        return this;
    }

    public Builder click(@NonNull PendingIntentNotification pendingIntentNotification) {
        model.builder.setContentIntent(pendingIntentNotification.onSettingPendingIntent());
        return this;
    }

    public Builder priority(int priority) {
        if (priority <= 0) {
            throw new IllegalArgumentException("Priority Should Not Be Less Than Or Equal To Zero!");
        }
        model.builder.setPriority(priority);
        return this;
    }

    public Builder flags(int defaults) {
        model.builder.setDefaults(defaults);
        return this;
    }


    public Builder dismiss(@NonNull Class<?> activity, Bundle bundle) {
        Intent dismissIntent = new Intent(model.context, activity);
        dismissIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        dismissIntent.setPackage(model.context.getPackageName());
        if (bundle != null) {
            dismissIntent.putExtras(bundle);
        }
        PendingIntent pendingIntent = PendingIntent.getActivity(model.context, model.notificationId, dismissIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        model.builder.setDeleteIntent(pendingIntent);
        return this;
    }

    public Builder dismiss(@NonNull Class<?> activity) {
        dismiss(activity, null);
        return this;
    }

    public Builder dismiss(@Nullable Bundle bundle) {
        Intent dismissIntent = new Intent();
        dismissIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        dismissIntent.setPackage(model.context.getPackageName());
        if (bundle != null) {
            dismissIntent.putExtras(bundle);
        }
        PendingIntent pendingIntent = PendingIntent.getActivity(model.context, model.notificationId, dismissIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        model.builder.setDeleteIntent(pendingIntent);
        return this;
    }

    public Builder dismiss(@NonNull PendingIntentNotification pendingIntentNotification) {
        model.builder.setDeleteIntent(pendingIntentNotification.onSettingPendingIntent());
        return this;
    }

    public Builder dismiss(@NonNull PendingIntent pendingIntent) {
        model.builder.setDeleteIntent(pendingIntent);
        return this;
    }

    public Custom custom() {
        notificationShallContainAtLeastThoseSmallIconValid();
        return new Custom(model, model.notificationId, model.tag);
    }

    public Simple simple() {
        notificationShallContainAtLeastThoseSmallIconValid();
        return new Simple(model, model.notificationId, model.tag);
    }

//    public Wear wear() {
//        notificationShallContainAtLeastThoseSmallIconValid();
//        return new Wear(builder, notificationId, tag);
//    }

    public Progress progress() {
        notificationShallContainAtLeastThoseSmallIconValid();
        return new Progress(model, model.notificationId, model.tag);
    }

    private void notificationShallContainAtLeastThoseSmallIconValid() {
        if (model.smallIcon <= 0) {
            throw new IllegalArgumentException("This is required. Notifications with an invalid icon resource will not be shown.");
        }
    }

    private RemoteViews createRemoteViews(int icon) {
        RemoteViews remoteViews = new RemoteViews(model.context.getPackageName(), R.layout.notification_custom_content);
        remoteViews.setImageViewResource(R.id.image_icon, model.smallIcon);
        remoteViews.setTextViewText(R.id.text_title, "Title");
        remoteViews.setTextViewText(R.id.text_message, "message");
        remoteViews.setImageViewResource(R.id.image_end, model.smallIcon);
        return remoteViews;
    }
}
