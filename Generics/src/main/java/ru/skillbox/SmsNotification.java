package ru.skillbox;

import lombok.Getter;
import lombok.Setter;
import ru.skillbox.notification.Notification;
@Getter
@Setter
public class SmsNotification implements Notification {
    String number;
    String message;

    public SmsNotification(String number, String message) {
        this.number = number;
        this.message = message;
    }


    @Override
    public String formattedMessage() {
        return "SMS" + "\n" +
        "receivers: " + "+" + number + "\n" +
        "message: " + message;
    }
}
