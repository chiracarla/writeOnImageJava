import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * main function reads user input and executes changes
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path of .jpg photo to edit: ");
        String imageFile = scanner.nextLine();
        BufferedImage img = ImageIO.read(new File(imageFile));

        Graphics2D g = img.createGraphics();
        g.setColor(Color.BLACK);
        System.out.println("Enter text to write: ");
        String m = scanner.nextLine(); //text to write
        int start = 0;
        if(m.length() * 41 > img.getWidth()) {
            System.out.println("The text is too long and won't fit entirely.");
        }
        else{
            start = img.getWidth()/2 - m.length() / 2 * 41; //calculating point to start the text so that it's in the middle

        }
        char[] chars = new char[m.length()]; //text in array of chars
        m.getChars(0, m.length() , chars, 0);

        g.setFont(new Font("Times New Roman", Font.PLAIN, 100));
        g.drawChars(chars, 0, chars.length, start, img.getHeight()/2 );

        g.dispose();

        System.out.println("Enter path to edited .jpg photo: ");
        String outputFile = scanner.nextLine();
        try {
            ImageIO.write(img, "jpg", new File(outputFile));
            System.out.println("Editing complete.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}