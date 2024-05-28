package ru.skillbox;

import lombok.Getter;
import lombok.Setter;
import ru.skillbox.notification.Notification;

@Getter
public class PushNotification implements Notification {
    @Setter
    String message;

    public PushNotification(String message) {
        this.message = message;
    }


    @Override
    public String formattedMessage() {
        return "PUSH" + "\n" +
        "title: " + message + "\n" +
                "receiver: o.yanovich" + "\n" +
        "message: 👋" + message;
    }
}
