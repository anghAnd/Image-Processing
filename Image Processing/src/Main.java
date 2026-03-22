import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedImage input = ImageIO.read(new File("1.jpg"));

        // Imagine doar cu blur
        BufferedImage Blur = ImageFilter.blur(input);
        ImageIO.write(Blur, "jpg", new File("Blur.jpg"));

        // Imagine doar cu resize
        BufferedImage Resize = ImageResizer.resize(input, 800, 600);
        ImageIO.write(Resize, "jpg", new File("Resize.jpg"));

        // Imagine doar cu alb-negru
        BufferedImage Gray = ImageTransformer.toGrayScale(input);
        ImageIO.write(Gray, "jpg", new File("Gray.jpg"));

        // Imagine cu toate operațiile: blur -> resize -> grayscale
        BufferedImage allOperations = ImageFilter.blur(input);
        allOperations = ImageResizer.resize(allOperations, 800, 600);
        allOperations = ImageTransformer.toGrayScale(allOperations);
        ImageIO.write(allOperations, "jpg", new File("allOperations.jpg"));

        System.out.println("Procesare completă! Vezi imaginile generate: Blur.jpg, Resize.jpg, Gray.jpg, allOperations.jpg");
    }
}