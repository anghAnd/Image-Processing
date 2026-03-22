import java.awt.image.BufferedImage;

public class ImageFilter {

    // Metoda blur primește o imagine și returnează o imagine nouă, cu efect de blur
    public static BufferedImage blur(BufferedImage image) {

        // Obținem dimensiunile imaginii
        int width = image.getWidth();
        int height = image.getHeight();

        // Cream o imagine nouă în care vom scrie rezultatul
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Kernel 3x3 pentru blur (toate valorile egale)
        // Fiecare pixel din vecinătate contribuie la media finală
        int[][] kernel = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int kernelSum = 9; // Suma elementelor kernel-ului, pentru a face media

        // Parcurgem imaginea pixel cu pixel, evitând marginile (1 pixel de margine)
        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {

                // Variabile pentru a acumula valorile R, G, B
                int r = 0, g = 0, b = 0;

                // Parcurgem vecinii pixelului curent conform kernel-ului 3x3
                for (int ky = -1; ky <= 1; ky++) {
                    for (int kx = -1; kx <= 1; kx++) {

                        // Luăm valoarea RGB a pixelului vecin
                        int rgb = image.getRGB(x + kx, y + ky);

                        // Extragem componentele R, G, B
                        r += ((rgb >> 16) & 0xFF) * kernel[ky + 1][kx + 1]; // roșu
                        g += ((rgb >> 8) & 0xFF) * kernel[ky + 1][kx + 1];  // verde
                        b += (rgb & 0xFF) * kernel[ky + 1][kx + 1];         // albastru
                    }
                }

                // Calculăm valoarea medie și reconstruim pixelul
                int newPixel = ((r / kernelSum) << 16)   // mutăm R în primii 8 biți
                        | ((g / kernelSum) << 8)    // mutăm G în următorii 8 biți
                        | (b / kernelSum);          // B rămâne în ultimii 8 biți

                // Setăm pixelul calculat în imaginea de ieșire
                output.setRGB(x, y, newPixel);
            }
        }

        // Returnăm imaginea procesată
        return output;
    }
}