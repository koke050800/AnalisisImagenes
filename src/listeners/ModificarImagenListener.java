/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import espacial.Convolucion;
import espacial.Histograma;
import espacial.UmbralAuto;
import gui.JFramePrincipal;
import gui.JInternalFrameBinario;
import gui.JInternalFrameBinario2Slider;
import gui.JInternalFrameConvolucion;
import gui.JInternalFrameEcualizame;
import gui.JInternalFrameExponencial;
import gui.JInternalFrameFrecuenciasFTT;
import gui.JInternalFrameIluminacion;
import gui.JInternalFrameImagen;
import gui.JInternalFrameLineal;
import gui.JInternalFrameLn;
import gui.JInternalFrameModificar;
import gui.JInternalFrameSalPimienta;
import gui.JInternalFrameTraslacion;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author working
 */
public class ModificarImagenListener implements ActionListener {

    private JFramePrincipal framePrincipal;

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

        if (item.getText().equals("Imagen Binaria")) {

            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            JInternalFrameBinario internalNuevo = new JInternalFrameBinario(internal, this.framePrincipal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }

        if (item.getText().equals("ImagenBinaria 2 Sliders")) {

            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            JInternalFrameBinario2Slider internalNuevo = new JInternalFrameBinario2Slider(internal, this.framePrincipal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }

        if (item.getText().equals("Histograma")) {

            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Histograma h1 = new Histograma(internal.getImagenOriginal());
            h1.calcularHistogramas();
            h1.graficar();

        }

        if (item.getText().equals("Modificar Iluminaci??n")) {

            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            JInternalFrameIluminacion internalNuevo = new JInternalFrameIluminacion(internal, this.framePrincipal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }

        if (item.getText().equals("Umbralizacion Automatica")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal         
            Image imagen = internal.getImagenOriginal();
            double[] umbral = UmbralAuto.devolverHistograma(imagen);
            JOptionPane.showMessageDialog(this.framePrincipal.getjDesktopPanePrincipal(), "El umbral es: " + UmbralAuto.calculaUmbral(umbral));
            Image nueva = UmbralAuto.BinarizarImagen(imagen, UmbralAuto.calculaUmbral(umbral));

            JInternalFrameImagen i = new JInternalFrameImagen(nueva);
            i.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(i);
        }

        if (item.getText().equals("Umbralizacion Automatica Otsu")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal         
            Image imagen = internal.getImagenOriginal();
            double[] umbral = UmbralAuto.devolverHistograma(imagen);
            JOptionPane.showMessageDialog(this.framePrincipal.getjDesktopPanePrincipal(), "El umbral es: " + UmbralAuto.calculaUmbral(umbral));
            Image nueva = UmbralAuto.BinarizarImagen(imagen, UmbralAuto.otsu(umbral));

            JInternalFrameImagen i = new JInternalFrameImagen(nueva);
            i.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(i);
        }

        if (item.getText().equals("Lineal")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            // se puede extraer la imagen orginal         
            Image imagen = internal.getImagenOriginal();
            JInternalFrameLineal li = new JInternalFrameLineal(internal, imagen);

            li.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(li);
        }

        if (item.getText().equals("Logar??tmica")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image imagen = internal.getImagenOriginal();
            //Image nueva = espacial.Expansion.ExpandeLog(imagen);
            //JInternalFrameImagen i = new JInternalFrameImagen(nueva);
            JInternalFrameLn i = new JInternalFrameLn(internal, imagen);
            i.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(i);
        }
        if (item.getText().equals("Exponencial")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image imagen = internal.getImagenOriginal();
            JInternalFrameExponencial li = new JInternalFrameExponencial(internal, imagen);
            //JInternalFrameLineal li = new JInternalFrameLineal(internal,imagen);
            li.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(li);
        }
        if (item.getText().equals("Ecualizar")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image imagen = internal.getImagenOriginal();
            JInternalFrameEcualizame li = new JInternalFrameEcualizame(internal, imagen);
            //JInternalFrameLineal li = new JInternalFrameLineal(internal,imagen);
            li.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(li);
        }
        if (item.getText().equals("Mascara")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image imagen = internal.getImagenOriginal();
            JInternalFrameConvolucion li = new JInternalFrameConvolucion(internal, imagen);

            li.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(li);
        }
        if (item.getText().equals("KIRCH")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image imagen = internal.getImagenOriginal();
            Image nueva = Convolucion.aplicarConvolucionKIRCH(imagen);


            /* crear el nuevo*/
            JInternalFrameImagen nuevo = new JInternalFrameImagen(nueva);
            nuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(nuevo);
        }
        if (item.getText().equals("Agregar SalPimienta")) {

            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            JInternalFrameSalPimienta internalNuevo = new JInternalFrameSalPimienta(internal, this.framePrincipal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        if (item.getText().equals("FTT (Frecuencias)")) {

            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image imagen = internal.getImagenOriginal();

            JInternalFrameFrecuenciasFTT frameFrecuenciasFTT = new JInternalFrameFrecuenciasFTT(imagen, internal, this.framePrincipal);
            frameFrecuenciasFTT.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(frameFrecuenciasFTT);

        }
        if (item.getText().equals("FTT (Filtrado)")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            Image imagen;
            BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(internal.getImagenOriginal());

            for (int x = 0; x < bi.getWidth(); x++) {
                for (int y = 0; y < bi.getHeight(); y++) {
                    Color c1 = new Color(bi.getRGB(x, y));
                    int med = (c1.getRed() + c1.getGreen() + c1.getBlue()) / 3;
                    bi.setRGB(x, y, new Color(med, med, med).getRGB());
                }
            }
            imagen = herramientas.HerramientasImagen.toImage(bi);
            internal.setImagen(imagen);
            herramientas.HerramientasImagen.FrecuenciasGrises(imagen, this.framePrincipal);

        }

        if (item.getText().equals("Traslaci??n")) {

            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            JInternalFrameTraslacion internalNuevo = new JInternalFrameTraslacion(internal, this.framePrincipal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);

        }

    }
}
