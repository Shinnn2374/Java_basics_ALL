package ru.skillbox;
import lombok.Getter;
import lombok.Setter;
import ru.skillbox.notification.Notification;
@Getter
public class EmailNotification implements Notification {
    @Setter
    String message;

    public EmailNotification(String message) {
        this.message = message;
    }

    @Override
    public String formattedMessage() {
        return "EMAIL" + "\n" +
        "subject: "+ message + "\n" +
                "receivers: oleg@java.skillbox.ru, masha@java.skillbox.ru, yan@java.skillbox.ru" + "\n" +
        "message: <p>" + message + "</p>";
    }
}
