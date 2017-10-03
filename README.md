![](https://jitpack.io/v/amitclickapps/notification-util.svg?style=flat-square)


### Notification
```
       NotificationUtil.with(this)
                               .button(android.R.drawable.sym_action_call, "Call", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
                               .button(android.R.drawable.sym_action_chat, "Chat", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
                               .button(android.R.drawable.sym_action_email, "Email", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
                               .autoCancel(true)
                               .identifier(10)
                               .smallIcon(android.R.drawable.sym_action_email)
                               .title("title")
                               .bigTextStyle("message message  message message message message message message message ", "title")
                               .message("title")
                               .largeIcon(android.R.drawable.sym_action_chat)
                               .click(MainActivity.class)
                               .color(android.R.color.holo_green_dark)
                               .flags(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                               .priority(NotificationCompat.PRIORITY_HIGH)
                               .simple()
                               .build();
```

```
        NotificationUtil.with(this)
                                .title("title").message("message").ticker("ticker")
                                .smallIcon(android.R.drawable.sym_action_email)
                                .largeIcon(R.drawable.a1)
                                .bigPictureStyle("title title", "message message")
                                .color(android.R.color.holo_green_dark)
                                .flags(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                                .priority(NotificationCompat.PRIORITY_HIGH)
                                .simple()
                                .build();
```
```
    Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.a1);
                NotificationUtil.with(this)
                        .autoCancel(true)
                        .identifier(11)
                        .smallIcon(R.mipmap.ic_launcher)
                        .title("title title")
                        .largeIcon(R.drawable.a1)
                        .message("messagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessage")
                        .bigPictureStyle("title title", "message message", bitmap)
                        .color(android.R.color.holo_red_dark)
                        .flags(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                        .priority(NotificationCompat.PRIORITY_HIGH)
                        .simple()
                        .build();
```
```
NotificationUtil.with(this)
                        .title("title").message("message").ticker("ticker")
                        .smallIcon(android.R.drawable.sym_action_email)
                        .largeIcon(R.drawable.a1)
                        .bigPictureStyle("title title", "message message")
                        .color(android.R.color.holo_green_dark)
                        .flags(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                        .priority(NotificationCompat.PRIORITY_HIGH)
                        .custom()
                        .build();
```
#### Add Custom layout
```
NotificationUtil.with(this)
                        .title("title").message("message").ticker("ticker")
                        .smallIcon(android.R.drawable.sym_action_email)
                        .largeIcon(R.drawable.a1)
                        .bigPictureStyle("title title", "message message")
                        .color(android.R.color.holo_green_dark)
                        .flags(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                        .priority(NotificationCompat.PRIORITY_HIGH)
                        .custom().addRemoteView(remoteViews)
                        .build();
```
Download
--------
Add the JitPack repository to your root build.gradle:

![](https://jitpack.io/v/amitclickapps/notification-util.svg?style=flat-square)


```groovy
	allprojects {
		repositories {
			maven { url "https://jitpack.io" }
		}
	}
```
Add the Gradle dependency:
```groovy
	dependencies {
		compile 'com.github.amitclickapps:notification-util:latest'
	}
```
