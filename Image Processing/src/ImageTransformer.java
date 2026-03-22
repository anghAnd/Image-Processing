import java.awt.image.BufferedImage;

public class ImageTransformer {

    // Metoda toGrayScale primește o imagine color și returnează o imagine alb-negru
    public static BufferedImage toGrayScale(BufferedImage image) {

        // Obținem dimensiunile imaginii originale
        int width = image.getWidth();
        int height = image.getHeight();

        // Cream o imagine nouă unde vom scrie versiunea alb-negru
        BufferedImage gray = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Parcurgem fiecare pixel din imagine
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // Luăm valoarea RGB a pixelului curent
                int rgb = image.getRGB(x, y);

                // Extragem componentele R, G și B
                int r = (rgb >> 16) & 0xFF;  // roșu
                int g = (rgb >> 8) & 0xFF;   // verde
                int b = rgb & 0xFF;          // albastru

                // Calculăm valoarea medie pentru a obține nuanța de gri
                int grayValue = (r + g + b) / 3;

                // Reconstruim pixelul alb-negru din valoarea medie
                int newPixel = (grayValue << 16) | (grayValue << 8) | grayValue;

                // Setăm pixelul în imaginea de ieșire
                gray.setRGB(x, y, newPixel);
            }
        }

        // Returnăm imaginea alb-negru
        return gray;
    }
}