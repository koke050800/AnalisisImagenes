/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import espacial.Traslacion;
import java.awt.Image;

/**
 *
 * @author KOKE
 */
public class JInternalFrameTraslacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameTraslacion
     */
    private JInternalFrameImagen internal;
    
    private JFramePrincipal framePrincipal;

    public JInternalFrameTraslacion(JInternalFrameImagen internal, JFramePrincipal framePrincipal) {

        this.internal = internal;
        this.framePrincipal = framePrincipal;

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

        jTextFieldDesplazaX = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDesplazaY = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNxN = new javax.swing.JTextField();
        jButtonTraslada = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Desplazamiento en X ");

        jLabel2.setText("Desplazamiento en Y ");

        jLabel3.setText("N x N del lienzo");

        jButtonTraslada.setText("Traslada");
        jButtonTraslada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrasladaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDesplazaX)
                            .addComponent(jTextFieldDesplazaY))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonTraslada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldNxN, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDesplazaX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNxN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDesplazaY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTraslada))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTrasladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTrasladaActionPerformed

        Image imagenOriginal = Traslacion.aplicarLienzoAoriginal(internal.getImagenOriginal(), Integer.parseInt(jTextFieldNxN.getText()));
        internal.setTitle("Imagen Original con Lienzo");
        internal.setImagen(imagenOriginal);
        internal.setSize(imagenOriginal.getWidth(null), imagenOriginal.getHeight(null));
        

        Image imagenTrasladada = Traslacion.aplicarTraslacion(Integer.parseInt(jTextFieldDesplazaX.getText()), Integer.parseInt(jTextFieldDesplazaY.getText()), imagenOriginal, Integer.parseInt(jTextFieldNxN.getText()));
        JInternalFrameImagen internalLienzo = new JInternalFrameImagen(imagenTrasladada);
        internalLienzo.setVisible(true);
        internalLienzo.setTitle("Imagen Trasladada con Lienzo");
        framePrincipal.getjDesktopPanePrincipal().add(internalLienzo);


    }//GEN-LAST:event_jButtonTrasladaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonTraslada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldDesplazaX;
    private javax.swing.JTextField jTextFieldDesplazaY;
    private javax.swing.JTextField jTextFieldNxN;
    // End of variables declaration//GEN-END:variables
}
