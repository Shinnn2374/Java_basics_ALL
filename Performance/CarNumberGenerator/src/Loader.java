import java.io.FileOutputStream;
import java.io.IOException;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        FileOutputStream writer = new FileOutputStream("res/numbers.txt");

        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        StringBuilder builder = new StringBuilder();
        new Thread(() ->{ for(int regionCode = 1; regionCode < 200; regionCode ++){
            for(int number = 1; number < 1000; number++){
                for (char firstLetter : letters){
                    for (char secondLetter : letters){
                        for (char thridLetter : letters){
                            builder.append(firstLetter);
                            builder.append(padNumber(number,3));
                            builder.append(secondLetter);
                            builder.append(thridLetter);
                            builder.append(padNumber(regionCode,2));
                            builder.append("\n");
                        }
                    }
                }
            }
            try {
                writer.write(builder.toString().getBytes());
                writer.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        }});

        writer.close();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        StringBuffer buffer = new StringBuffer(Integer.toString(number));
        int padSize = numberLength - buffer.length();
        for (int i = 0 ; i < padSize; i++){
            buffer.insert(0, "0");
        }
        return String.valueOf(buffer);
    }
}
