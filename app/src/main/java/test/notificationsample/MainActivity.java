package test.notificationsample;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.notificationutil.NotificationUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                NotificationUtil.with(this)
                        .button(android.R.drawable.sym_action_call, "Call", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
                        .button(android.R.drawable.sym_action_chat, "Chat", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
                        .button(android.R.drawable.sym_action_email, "Email", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
                        .autoCancel(true)
                        .identifier(10)
                        .smallIcon(android.R.drawable.sym_action_email)
                        .title("title")
                        .bigTextStyle("message message  message message message message message message message ", "title")
                        .message("message")
                        .largeIcon(android.R.drawable.sym_action_chat)
                        .click(MainActivity.class)
                        .color(android.R.color.holo_green_dark)
                        .flags(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                        .priority(Notification.PRIORITY_HIGH)
                        .simple()
                        .build();
                break;
            case R.id.button2:
                NotificationUtil.with(this)
                        .button(android.R.drawable.sym_action_call, "Call", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
                        .button(android.R.drawable.sym_action_chat, "Chat", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
                        .button(android.R.drawable.sym_action_email, "Email", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
                        .autoCancel(true)
                        .identifier(11)
                        .smallIcon(android.R.drawable.sym_action_email)
                        .title("title title")
                        .bigTextStyle("message message  message message message message message message message ", "title")
                        .message("message")
                        .largeIcon(android.R.drawable.sym_action_chat)
                        .click(MainActivity.class)
                        .color(android.R.color.holo_green_dark)
                        .flags(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                        .priority(Notification.PRIORITY_HIGH)
                        .simple()
                        .build();
                break;
            case R.id.button3:
                Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
                NotificationUtil.with(this)
                        .autoCancel(true)
                        .identifier(11)
                        .smallIcon(R.mipmap.ic_launcher)
                        .title("title title")
                        .message("messagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessage")
//                        .inboxStyle(new String[] {"adfafafsdasdf"},"title title", "message message")
                        .style(new NotificationCompat.BigPictureStyle().setBigContentTitle("title title")
                                .setSummaryText("messagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessage")
                                .bigLargeIcon(bitmap))
                        .largeIcon(R.mipmap.ic_launcher_round)
                        .color(android.R.color.holo_red_dark)
                        .flags(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                        .priority(Notification.PRIORITY_HIGH)
                        .custom()
                        .build();
                break;
        }
    }
}
