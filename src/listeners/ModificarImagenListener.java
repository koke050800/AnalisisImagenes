/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameBinario;
import gui.JInternalFrameImagen;
import gui.JInternalFrameModificar;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JMenuItem;

/**
 *
 * @author working
 */
public class ModificarImagenListener implements ActionListener{
    
     
    private  JFramePrincipal framePrincipal;

    public ModificarImagenListener(JFramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        if (item.getText().equals("Modificar Pixeles")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameModificar internalNuevo = new JInternalFrameModificar(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }

        if (item.getText().equals("Filtro Negativo")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(internal.getImagenOriginal());
            for (int x = 0; x < bi.getWidth(); x++) {
                for (int y = 0; y < bi.getHeight(); y++) {
                    //Obtiene el color
                    Color c1 = new Color(bi.getRGB(x, y));
                    int r = c1.getRed();
                    int g = c1.getGreen();
                    int b = c1.getBlue();

                    //Almacena el color en la imagen destino
                    bi.setRGB(x, y, new Color(255 - r, 255 - g, 255 - b).getRGB());
                }
            }
            Image nueva2 = herramientas.HerramientasImagen.toImage(bi);
            //internal.setImagen(nueva2);

            /* crear el nuevo*/
            JInternalFrameImagen nuevo = new JInternalFrameImagen(nueva2);
            nuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(nuevo);

        }

        if (item.getText().equals("Escala de Grises")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(internal.getImagenOriginal());
            for (int x = 0; x < bi.getWidth(); x++) {
                for (int y = 0; y < bi.getHeight(); y++) {
                    //Obtiene el color
                    Color c1 = new Color(bi.getRGB(x, y));
                    //Calcula la media de tonalidades
                    int med = (c1.getRed() + c1.getGreen() + c1.getBlue()) / 3;
                    //Almacena el color en la imagen destino
                    bi.setRGB(x, y, new Color(med, med, med).getRGB());
                }
            }

            Image nueva = herramientas.HerramientasImagen.toImage(bi);
            //internal.setImagen(nueva2);

            /* crear el nuevo*/
            JInternalFrameImagen nuevo = new JInternalFrameImagen(nueva);
            nuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(nuevo);

        }

       /* if (item.getText().equals("Blanco y Negro")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(internal.getImagenOriginal());
            for (int x = 0; x < bi.getWidth(); x++) {
                for (int y = 0; y < bi.getHeight(); y++) {
                    //Obtiene el color
                    Color c1 = new Color(bi.getRGB(x, y));
                    //Calcula la media de tonalidades
                    int med = (c1.getRed() + c1.getGreen() + c1.getBlue());
                    if (med >= 382) {
                        //Almacena el color en la imagen destino
                        bi.setRGB(x, y, Color.WHITE.getRGB());
                    } else {
                        bi.setRGB(x, y, 0);
                    }

                }
            }
            Image nueva = herramientas.HerramientasImagen.toImage(bi);
            //crear el nuevo
            JInternalFrameImagen nuevo = new JInternalFrameImagen(nueva);
            nuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(nuevo);

        }*/
        
        
        if (item.getText().equals("Imagen Binaria")) {        
            
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
    
            JInternalFrameBinario internalNuevo = new JInternalFrameBinario(internal, this.framePrincipal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo); 
        }
        

    }

}
