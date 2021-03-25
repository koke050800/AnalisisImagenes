/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartColor;

/**
 *
 * @author working
 */
public class JInternalFrameIluminacion extends javax.swing.JInternalFrame {

    private JInternalFrameImagen internal;
    private JFramePrincipal framePrincipal;
    private Image imagenRecortada;
    int valorSlider = 128;
    
    
    private Image imagenOriginal;

    /**
     * Creates new form JInternalFrameBinario
     */
    public JInternalFrameIluminacion(JInternalFrameImagen internal, JFramePrincipal framePrincipal) {

        this.internal = internal;
        this.framePrincipal = framePrincipal;
        

        initComponents();
        
       this.imagenOriginal = herramientas.HerramientasImagen.copiarImagen(internal.getImagenOriginal());
        this.jButtonIluminacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int valor = jSliderIluminacion.getValue();
                BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
                Color color;
                int i, j, aux;
                for (j = 0; j < bi.getHeight(); j++) {
                    for (i = 0; i < bi.getWidth(); i++) {
                        color = new Color(bi.getRGB(i, j));
                        int r = color.getRed() + valor;
                        int g = color.getGreen() + valor;
                        int b = color.getBlue() + valor;

                        color = new Color(herramientas.HerramientasImagen.verificarNivelRGB(r), herramientas.HerramientasImagen.verificarNivelRGB(g), herramientas.HerramientasImagen.verificarNivelRGB(b));
                        bi.setRGB(i, j, color.getRGB());
                    }
                }
                Image nueva = herramientas.HerramientasImagen.toImage(bi);
                internal.setImagen(nueva);
                System.out.println(valor);
            }
        });
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonIluminacion = new javax.swing.JButton();
        jSliderIluminacion = new javax.swing.JSlider();

        setClosable(true);
        setTitle("Cambiar iluminación");

        jButtonIluminacion.setText("Cambiar iluminacion");
        jButtonIluminacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIluminacionActionPerformed(evt);
            }
        });

        jSliderIluminacion.setMajorTickSpacing(51);
        jSliderIluminacion.setMaximum(255);
        jSliderIluminacion.setMinimum(-255);
        jSliderIluminacion.setPaintLabels(true);
        jSliderIluminacion.setPaintTicks(true);
        jSliderIluminacion.setToolTipText("");
        jSliderIluminacion.setValue(0);
        jSliderIluminacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSliderIluminacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderIluminacionStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonIluminacion, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(jSliderIluminacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jSliderIluminacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonIluminacion)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIluminacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIluminacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonIluminacionActionPerformed

    private void jSliderIluminacionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderIluminacionStateChanged
        valorSlider = this.jSliderIluminacion.getValue();        
    }//GEN-LAST:event_jSliderIluminacionStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIluminacion;
    private javax.swing.JSlider jSliderIluminacion;
    // End of variables declaration//GEN-END:variables
}