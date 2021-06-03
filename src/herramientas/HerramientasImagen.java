/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import fft.GestorGrises;
import gui.JFramePrincipal;
import gui.JInternalFrameFiltrado;
import gui.JInternalFrameImagen;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author working
 */
public class HerramientasImagen {
    
    public static Image abrirImagen (){
    
          try {
            // definir los filtros para lectura
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Imagenes","jpg","jpeg","png","bmp","CR2");
            // crear un selector de archivos
            JFileChooser selector = new JFileChooser();
            // agregar el filtro al selector
            selector.addChoosableFileFilter(filtro);
            // especificar que solo se puedan abrir archivos
            selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            //ejecutar el selector de imagenes
            
            int res = selector.showOpenDialog(null);
            
            if (res == 1 ){
                
                return null;
                
            }
            
            File archivo = selector.getSelectedFile();
            
            BufferedImage bi = ImageIO.read(archivo);
            
            return toImage(bi);
        } catch (IOException ex) {
            Logger.getLogger(HerramientasImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }  
    
    public static Image toImage (BufferedImage bi){
        return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
    
    public static BufferedImage toBufferedImage (Image imagen){
         // imagen es un objeto de tipo BufferedImage
        if (imagen instanceof BufferedImage){
          return (BufferedImage)imagen;
        }
        BufferedImage bi = 
                new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
        
        Graphics2D nueva = bi.createGraphics();
        nueva.drawImage(imagen, 0, 0,null);
        nueva.dispose();
        
        return bi;
    }

    public static Image copiarImagen(Image i) {
        BufferedImage bi = toBufferedImage(i);
        return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    public static int verificarNivelRGB(int valor) {
        if (valor > 255) {
            return 255;
        }
        if (valor < 0) {
            return 0;
        }
        return valor;
    }
    
    public static Image FrecuenciasGrises(Image io, JFramePrincipal j) {
        BufferedImage bi = HerramientasImagen.toBufferedImage(io);
        BufferedImage bnuevo = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        // recorres el buffer

        GestorGrises g = new GestorGrises(bi);

        bnuevo = g.obtenerImagenFrecuencias(true);
        JInternalFrameImagen internalNuevo2 = new JInternalFrameImagen(bnuevo);
        internalNuevo2.setVisible(true);
        j.getjDesktopPanePrincipal().add(internalNuevo2);

        JInternalFrameFiltrado Filtro = new JInternalFrameFiltrado(j, io, bi.getHeight(), g);
        Filtro.setVisible(true);
        j.getjDesktopPanePrincipal().add(Filtro);

        //esto es la inversa no importa ahorita 
//            bnuevo = g.obtenerImagenEspacial();
//            JInternalFrameImagen internalNuevo23 = new JInternalFrameImagen(bnuevo);
//            internalNuevo23.setVisible(true);
//            j.getjDesktopPanePrincipal().add(internalNuevo23);
        return HerramientasImagen.toBufferedImage(bnuevo);
    }
}
