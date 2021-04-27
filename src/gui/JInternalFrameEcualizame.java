/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import espacial.UmbralAuto;
import espacial.Expansion;
import java.awt.Image;

/**
 *
 * @author KOKE
 */
public class JInternalFrameEcualizame extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameEcualizame
     */
    private JInternalFrameImagen internal;
    private Image imagenOriginal;
    public JInternalFrameEcualizame(JInternalFrameImagen internal,Image imagenOriginal) {
        this.internal = internal;
        this.imagenOriginal = imagenOriginal;
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();

        setClosable(true);
        setIconifiable(true);

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(255);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        Image i = Expansion.ecualizacion(UmbralAuto.devolverHistograma(imagenOriginal), imagenOriginal, this.jSlider1.getValue());
        this.internal.setImagen(i);
    }//GEN-LAST:event_jSlider1StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
