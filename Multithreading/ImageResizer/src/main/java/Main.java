import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws  InterruptedException, IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        System.out.println("Введите папку с изображением: ");
        String srcFolder = reader.readLine();
        System.out.println("Введите папку для сохранения: ");
        String dstFolder = reader.readLine();

        File srdDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srdDir.listFiles();
        int step = Objects.requireNonNull(files).length / Runtime.getRuntime().availableProcessors();
        int var = 0;
        File[] temp = new File[step];

        for (File file : files){
            temp[var++] = file;
            if (var == step){
                new ImageResize(temp,dstFolder,start).start();
                temp = new File[step];
                var = 0;
            }
        }
    }
}
