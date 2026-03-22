import java.awt.image.BufferedImage;

public class ImageResizer {

    // Metoda resize primește o imagine și dimensiunile dorite și returnează o imagine redimensionată
    public static BufferedImage resize(BufferedImage image, int newWidth, int newHeight) {

        // Obținem dimensiunile imaginii originale
        int width = image.getWidth();
        int height = image.getHeight();

        // Cream o imagine nouă cu dimensiunile dorite
        BufferedImage resized = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

        // Parcurgem fiecare pixel din imaginea de ieșire
        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {

                // Calculăm poziția corespunzătoare în imaginea originală (nearest neighbor)
                int srcX = x * width / newWidth;   // coordonata X în imaginea originală
                int srcY = y * height / newHeight; // coordonata Y în imaginea originală

                // Preluăm valoarea RGB de la pixelul corespunzător din imaginea originală
                int rgb = image.getRGB(srcX, srcY);

                // Setăm valoarea RGB în pixelul corespunzător din imaginea redimensionată
                resized.setRGB(x, y, rgb);
            }
        }

        // Returnăm imaginea redimensionată
        return resized;
    }
}