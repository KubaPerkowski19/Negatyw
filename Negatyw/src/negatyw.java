import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class negatyw extends Thread{
    BufferedImage img;
    int w,h;
    File input;
    String file_path;
    // konstruktor z ścioeżkją do pliku
    public negatyw(String file_path) {
        try {
            this.file_path = file_path;
            this.input = new File(file_path);
            img = ImageIO.read(input);
        } catch (Exception e) {
        }
    }
    public void run() {
        //wymiary zdjęć
        w = img.getWidth();
        h = img.getHeight();
        //pętla po wymiarach zdjęć
        for(int i=1; i<h-1; i++){
            for(int j=1; j<w-1; j++){
                //pobieranie rgb pixeli
                Color c = new Color(img.getRGB(j, i));
                //zmienne tymczasowe z pojedyńczymi wartościami rgb
                int red = (int)(c.getRed());
                int green = (int)(c.getGreen());
                int blue = (int)(c.getBlue());
                //zmienne końcowe kture posłużą do nadpisania tamtych , utworzenia obrazu wynikowego
                int final_red, final_green, final_blue;
                // wynegowanie pixeli i przypisanie do zmiennych
                final_red = 255-red;
                final_green = 255-green;
                final_blue = 255-blue;
                //nowa zmienna color z nowymi wartościami rgb
                Color newColor = new Color(final_red, final_green, final_blue);
                //podmiana wartości rgb
                img.setRGB(j,i,newColor.getRGB());
            }
        }
        //wypisanie nowego wynegowanego zdjęcia jako wynik
        File ouptut = new File("negatyw"+ file_path);
        try {
            ImageIO.write(img, "jpg", ouptut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


