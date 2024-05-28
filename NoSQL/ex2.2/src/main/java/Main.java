import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class Main {
    private static final int DELETE_SECONDS_AGO = 2;


    private static final int RPS = 500;
    private static final int USERS = 1000;
    private static final int SLEEP = 100;

    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");

    private static void log(int UsersOnline) {
        String log = String.format("[%s] Пользователей онлайн: %d", DF.format(new Date()), UsersOnline);
        out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();
        for (int i = 1; i <= 20; i++) {
            redis.initUsers(i);

        }

        int i = 0;
        int random = new Random().nextInt(9) + 1;

        for (;;) {
            // показ пользователей
            redis.printFirstUser();
            if (i == 10){
                i = 0;
                random = new Random().nextInt(9) + 1;
            }
            i++;
            Thread.sleep(SLEEP);

            if (i == random){
                redis.logPageVisit(new Random().nextInt(10));
            }
        }
    }
}