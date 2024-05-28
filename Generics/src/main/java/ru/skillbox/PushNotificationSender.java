package ru.skillbox;

import ru.skillbox.notification.Notification;
import ru.skillbox.notification_sender.NotificationSender;

import java.util.List;

public class PushNotificationSender implements NotificationSender {
    @Override
    public void send(Notification notification) {
        System.out.println(notification.formattedMessage());
    }

    @Override
    public void send(List notifications) {
        for(int i = 0; i <= notifications.size() -1; i++ ){
            System.out.println(notifications.get(i).toString());
        }
    }
}
