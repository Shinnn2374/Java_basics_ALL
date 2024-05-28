import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int car = 1;
        int conteiners = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество ящиков");
        int objects = scanner.nextInt();
        int numbersConteiners = objects / 27 + car;
        int nubmersCar = numbersConteiners / 12 + conteiners;
        System.out.println("Грузовик: " + nubmersCar +"\n" +
                "\t" + "Контейнер: " + numbersConteiners + "\n");
        for (int i = 1 ; i <=objects ; i++){
            System.out.println("\t" + "Ящик: " + i);
        }
        System.out.println("Необходимо: " + "\n" +
                "\t" + "Грузовиков - " + nubmersCar + "\n" +
                "\t" + "Контейнеров - " + numbersConteiners);
    }
}