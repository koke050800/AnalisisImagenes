/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author koke
 */
public class Expansion {

    public static Image Expande(Image imagen, int r1, int r2) {
        Image nueva = null;
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        Color color;
        Color aux;
        //  System.out.println(jSlider1.getValue());
        for (int j = 0; j < bi.getWidth(); j++) {
            for (int m = 0; m < bi.getHeight(); m++) {
                color = new Color(bi.getRGB(j, m));

                int r = verificar((color.getRed() - r1) * (255 / r2 - r1)); // (0-255)
                int g = verificar((color.getGreen() - r1) * (255 / r2 - r1)); // (0-255)
                int b = verificar((color.getBlue() - r1) * (255 / r2 - r1)); // (0-255)
                //int med = (r + g + b) / 3
                aux = new Color(r, g, b);
                bi.setRGB(j, m, aux.getRGB());

            }
        }
        nueva = herramientas.HerramientasImagen.toImage(bi);
        return nueva;
    }
    
    public static Image ExpandeLog(Image imagen, int alpha) {
        Image nueva = null;
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        Color color;
        Color aux;
        //  System.out.println(jSlider1.getValue());
        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
                // obtener el color
                Color pixel = new Color(bi.getRGB(x, y));
                int r = (int) ((alpha * Math.log(1 + pixel.getRed())) / (Math.log(1 + alpha)));
                int g = (int) ((alpha * Math.log(1 + pixel.getGreen())) / (Math.log(1 + alpha)));
                int b = (int) ((alpha * Math.log(1 + pixel.getBlue())) / (Math.log(1 + alpha)));

                // validamos 
                pixel = new Color(verificar(r), verificar(g), verificar(b));
                bi.setRGB(x, y, pixel.getRGB());
            }
        }
        nueva = herramientas.HerramientasImagen.toImage(bi);
        return nueva;
    }

    public static Image ExpandeExp(Image imagen, double z) {
        Image nueva = null;
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        Color color;
        Color aux;
        //  System.out.println(jSlider1.getValue());
        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
                // obtener el color
                Color pixel = new Color(bi.getRGB(x, y));
                int r = verificar((int) (Math.pow(1 + z, pixel.getRed()) / z));
                int g = verificar((int) (Math.pow(1 + z, pixel.getGreen()) / z));
                int b = verificar((int) (Math.pow(1 + z, pixel.getBlue()) / z));

                // validamos 
                pixel = new Color(r, g, b);
                bi.setRGB(x, y, pixel.getRGB());
            }
        }
        nueva = herramientas.HerramientasImagen.toImage(bi);
        return nueva;
    }

    public static Image ecualizacion(double[] histograma, Image imagenOriginal, int z) {
        // calculamos nxm
        int nxm = imagenOriginal.getHeight(null) * imagenOriginal.getWidth(null);
        // declaramos el nuevo histograma
        int[] ecualizacion = new int[256];
        for (int g = 0; g < z + 1; g++) {
            double tmp = 0;
            for (int i = 0; i <= g; i++) {
                tmp += histograma[i];
            }
            tmp /= nxm;
            ecualizacion[g] = (int) Math.round(tmp * z);
        }
        // modificamos la imagen 
        BufferedImage bio = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        BufferedImage nueva = new BufferedImage(imagenOriginal.getWidth(null),
                 imagenOriginal.getHeight(null), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < imagenOriginal.getHeight(null); y++) {
            for (int x = 0; x < imagenOriginal.getWidth(null); x++) {
                // modificar el tono de la imagen en base al nuevo 
                // histograma
                Color color = new Color(bio.getRGB(x, y));
                int v = ecualizacion[color.getRed()];
                color = new Color(v, v, v);
                nueva.setRGB(x, y, color.getRGB());
            }
        }

        return herramientas.HerramientasImagen.toImage(nueva);
    }

    public static int verificar(int valor) {
        if (valor > 255) {
            return 255;
        }
        if (valor < 0) {
            return 0;
        }
        return valor;
    }
}
