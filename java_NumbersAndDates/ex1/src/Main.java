import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        int day = 03;
        int month = 07;
        int year = 2004;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        LocalDate birthDay = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE");
        int a = 0;

        while (birthDay.isBefore(today)) {
            System.out.println(a + " - " + formatter.format(birthDay));
            a += 1;
            birthDay = birthDay.plusYears(1);
            if (birthDay.isAfter(today)) {
                break;
            }
        }
        return "";
    }
}