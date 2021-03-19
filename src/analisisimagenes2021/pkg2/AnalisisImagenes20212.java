/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagenes2021.pkg2;

import espacial.Histograma;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author working
 */
public class AnalisisImagenes20212 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      /* // visualización de la imagen dentro de la GUI
        Image imagen = herramientas.HerramientasImagen.abrirImagen();
        // para cuantización de la imagen vamos a un ocupar BufferedImage
        BufferedImage bImagen = herramientas.HerramientasImagen.toBufferedImage(imagen);
        
        Color color = new Color(bImagen.getRGB(200,240));
        int r = color.getRed();
        int g =color.getGreen();
        int b = color.getBlue();
        System.out.println("Color "+r+","+g+","+b);*/

        Image imagen = herramientas.HerramientasImagen.abrirImagen();
        Histograma h1 = new Histograma(imagen);
        h1.calcularHistogramas();
        h1.graficar();

        /*Image imagen2 = herramientas.HerramientasImagen.abrirImagen();
        Histograma h2 = new Histograma(imagen2);
        h2.calcularHistogramas();
        h2.graficar();

        Image imagen3 = herramientas.HerramientasImagen.abrirImagen();
        Histograma h3 = new Histograma(imagen3);
        h3.calcularHistogramas();
        h3.graficar();*/

    }

}
