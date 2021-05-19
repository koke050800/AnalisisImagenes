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
 * @author KOKE
 */
public class SalPimienta {

    public static Image aplicarSalPimienta(int porcentaje, boolean pimienta, boolean sal, Image imagenOriginal) {

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color;
        int modpix = bi.getWidth() * bi.getHeight() * porcentaje / 100;
        int aux = 0;

        if (pimienta == true && sal == false) {
            while (aux <= modpix) {
                color = new Color(0, 0, 0);
                bi.setRGB((int) (Math.random() * bi.getWidth()) + 0, (int) (Math.random() * bi.getHeight()) + 0, color.getRGB());
                aux++;
            }
        } else if (pimienta == false && sal == true) {
            while (aux <= modpix) {
                color = new Color(255, 255, 255);
                bi.setRGB((int) (Math.random() * bi.getWidth()) + 0, (int) (Math.random() * bi.getHeight()) + 0, color.getRGB());
                aux++;
            }
        } else if (pimienta == true && sal == true) {
            while (aux <= modpix / 2) {
                color = new Color(255, 255, 255);
                bi.setRGB((int) (Math.random() * bi.getWidth()) + 0, (int) (Math.random() * bi.getHeight()) + 0, color.getRGB());
                aux++;
            }
            aux = 0;
            while (aux <= modpix / 2) {
                color = new Color(0, 0, 0);
                bi.setRGB((int) (Math.random() * bi.getWidth()) + 0, (int) (Math.random() * bi.getHeight()) + 0, color.getRGB());
                aux++;
            }
        }

        return herramientas.HerramientasImagen.toImage(bi);
    }

}
