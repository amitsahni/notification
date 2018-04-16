package test.notificationsample;

import android.app.Notification;
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
                NotificationUtil.with(this, R.mipmap.ic_launcher)
//                        .button(android.R.drawable.sym_action_call, "Call", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
//                        .button(android.R.drawable.sym_action_chat, "Chat", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
//                        .button(android.R.drawable.sym_action_email, "Email", PendingIntent.getBroadcast(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT))
                        .autoCancel(true)
                        .identifier(10)
                        //.title("title")
                        .bigTextStyle("message message  message message message message message message message ", "title title title title")
                        .message("message")
                        .largeIcon(R.mipmap.ic_launcher)
                        .click(MainActivity.class)
                        .color(android.R.color.holo_green_dark)
                        .flags(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                        .priority(NotificationCompat.PRIORITY_HIGH)
                        .simple()
                        .build();
                break;
            case R.id.button2:
                NotificationUtil.with(this)
                        .title("title").message("message").ticker("ticker")
                        .smallIcon(android.R.drawable.sym_action_email)
                        .largeIcon(R.drawable.a1)
                        .bigPictureStyle("title title", "message message", R.drawable.a1)
                        .color(android.R.color.holo_green_dark)
                        .flags(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                        .priority(NotificationCompat.PRIORITY_HIGH)
                        .simple()
                        .build();
                break;
            case R.id.button3:
                Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.a1);
                NotificationUtil.with(this, R.mipmap.ic_launcher)
                        .autoCancel(true)
                        .identifier(11)
                        //.smallIcon(R.mipmap.ic_launcher)
                        .title("title")
                        .largeIcon(R.mipmap.ic_launcher)
                        .message("message")
                        //.bigPictureStyle("title title", "message message", R.drawable.a1)
                        .color(android.R.color.holo_red_dark)
                        .flags(Notification.DEFAULT_ALL)
                        .priority(NotificationCompat.PRIORITY_HIGH)
                        .simple()
                        .build();
                break;
        }
    }
}
