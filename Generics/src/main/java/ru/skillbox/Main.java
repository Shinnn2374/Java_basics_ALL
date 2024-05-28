package ru.skillbox;

import org.checkerframework.checker.units.qual.A;
import ru.skillbox.notification.Notification;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Проверка методов вывода списка сообщений


//        ArrayList<Notification> list = new ArrayList<>();
//       for (int i = 1; i <=5 ; i++){
//           EmailNotificationSender emailNotificationSender = new EmailNotificationSender();
//           EmailNotification emailNotification = new EmailNotification("Успешная регистрация");
//           emailNotificationSender.send(emailNotification);
//           list.add(emailNotification);
//       }
//       EmailNotificationSender emailNotificationSender = new EmailNotificationSender();
//       emailNotificationSender.send(list);

//        ArrayList<Notification> list = new ArrayList<>();
//        for(int i = 1 ; i <=5 ; i++){
//            SmsNotificationSender smsNotificationSender = new SmsNotificationSender();
//            SmsNotification smsNotification = new SmsNotification("89388678847","Привет как дела?");
//            smsNotificationSender.send(smsNotification);
//            list.add(smsNotification);
//        }
//        SmsNotificationSender smsNotificationSender = new SmsNotificationSender();
//        smsNotificationSender.send(list);
//        ArrayList<Notification> list = new ArrayList<>();
//        for(int i =1 ; i <= 5 ; i++){
//            PushNotificationSender pushNotificationSender = new PushNotificationSender();
//            PushNotification pushNotification = new PushNotification("Привет, как ты?");
//            pushNotificationSender.send(pushNotification);
//            list.add(pushNotification);
//        }
//        PushNotificationSender pushNotificationSender = new PushNotificationSender();
//        pushNotificationSender.send(list);


        EmailNotificationSender emailNotificationSender = new EmailNotificationSender();
        EmailNotification emailNotification = new EmailNotification("Успешная регистрация");
        emailNotificationSender.send(emailNotification);
        System.out.println("\n");
        SmsNotificationSender smsNotificationSender = new SmsNotificationSender();
        SmsNotification smsNotification = new SmsNotification("89388678847","Привет, как ты?");
        smsNotificationSender.send(smsNotification);
        System.out.println("\n");
        PushNotificationSender pushNotificationSender = new PushNotificationSender();
        PushNotification pushNotification = new PushNotification("Приветик :)");
        pushNotificationSender.send(pushNotification);
    }
}
