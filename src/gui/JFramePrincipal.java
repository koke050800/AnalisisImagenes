/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import listeners.InternalFrameListener;
import listeners.ModificarImagenListener;
import listeners.RecorteImagenListener;

/**
 *
 * @author working
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipa
     */
    public JFramePrincipal() {
        initComponents();
        this.jMenuItem1.addActionListener(new InternalFrameListener(this));
        this.jMenuItem2.addActionListener(new ModificarImagenListener(this));
        this.jMenuItem3.addActionListener(new RecorteImagenListener(this));
        
        //para los filtros
        this.jMenuItem6.addActionListener(new ModificarImagenListener(this));
        this.jMenuItem9.addActionListener(new ModificarImagenListener(this));
        this.jMenuItem10.addActionListener(new ModificarImagenListener(this));
        
        //histograma
        this.jMenuItem4.addActionListener(new ModificarImagenListener(this));
        
        //iluminacion 
        this.jMenuItem5.addActionListener(new ModificarImagenListener(this));
        this.jMenuItemEXPlineal.addActionListener(new ModificarImagenListener(this));
        this.jMenuItemEXPlogaritmica.addActionListener(new ModificarImagenListener(this));
        this.jMenuItemEXPexponencial.addActionListener(new ModificarImagenListener(this));
        
        //Binario con 2 silider
        this.jMenuItemUmbral2Sliders.addActionListener(new ModificarImagenListener(this));
        
        //binarioAuto
        this.jMenuItemUmbralAuto.addActionListener(new ModificarImagenListener(this));
        this.jMenuItemUmbralAutoOtsu.addActionListener(new ModificarImagenListener(this));
        
        //ecualizar
        this.jMenuItemEQ.addActionListener(new ModificarImagenListener(this));
        
        //convolucion
        this.jMenuItemConvolucion.addActionListener(new ModificarImagenListener(this));
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem7 = new javax.swing.JMenuItem();
        jDesktopPanePrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItemUmbral2Sliders = new javax.swing.JMenuItem();
        jMenuItemUmbralAuto = new javax.swing.JMenuItem();
        jMenuItemUmbralAutoOtsu = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuExpansion = new javax.swing.JMenu();
        jMenuItemEXPlineal = new javax.swing.JMenuItem();
        jMenuItemEXPlogaritmica = new javax.swing.JMenuItem();
        jMenuItemEXPexponencial = new javax.swing.JMenuItem();
        jMenuItemEQ = new javax.swing.JMenuItem();
        jMenuItemConvolucion = new javax.swing.JMenuItem();

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPanePrincipalLayout = new javax.swing.GroupLayout(jDesktopPanePrincipal);
        jDesktopPanePrincipal.setLayout(jDesktopPanePrincipalLayout);
        jDesktopPanePrincipalLayout.setHorizontalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1268, Short.MAX_VALUE)
        );
        jDesktopPanePrincipalLayout.setVerticalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        jMenu1.setText("Imagen");

        jMenuItem1.setText("AbrirImagen");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Espacial");

        jMenuItem2.setText("Modificar Pixeles");
        jMenu2.add(jMenuItem2);

        jMenuItem4.setText("Histograma");
        jMenu2.add(jMenuItem4);

        jMenuItem3.setText("Recorte");
        jMenu2.add(jMenuItem3);

        jMenuItem9.setText("Filtro Negativo");
        jMenu2.add(jMenuItem9);

        jMenuItem6.setText("Escala de Grises");
        jMenu2.add(jMenuItem6);

        jMenuItem10.setText("Imagen Binaria");
        jMenu2.add(jMenuItem10);

        jMenuItemUmbral2Sliders.setText("ImagenBinaria 2 Sliders");
        jMenu2.add(jMenuItemUmbral2Sliders);

        jMenuItemUmbralAuto.setText("Umbralizacion Automatica");
        jMenu2.add(jMenuItemUmbralAuto);

        jMenuItemUmbralAutoOtsu.setText("Umbralizacion Automatica Otsu");
        jMenu2.add(jMenuItemUmbralAutoOtsu);

        jMenuItem5.setText("Modificar Iluminación");
        jMenu2.add(jMenuItem5);

        jMenuExpansion.setText("Expansión");

        jMenuItemEXPlineal.setText("Lineal");
        jMenuExpansion.add(jMenuItemEXPlineal);

        jMenuItemEXPlogaritmica.setText("Logarítmica");
        jMenuItemEXPlogaritmica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEXPlogaritmicaActionPerformed(evt);
            }
        });
        jMenuExpansion.add(jMenuItemEXPlogaritmica);

        jMenuItemEXPexponencial.setText("Exponencial");
        jMenuExpansion.add(jMenuItemEXPexponencial);

        jMenu2.add(jMenuExpansion);

        jMenuItemEQ.setText("Ecualizar");
        jMenu2.add(jMenuItemEQ);

        jMenuItemConvolucion.setText("Convolución");
        jMenu2.add(jMenuItemConvolucion);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemEXPlogaritmicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEXPlogaritmicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemEXPlogaritmicaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanePrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuExpansion;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemConvolucion;
    private javax.swing.JMenuItem jMenuItemEQ;
    private javax.swing.JMenuItem jMenuItemEXPexponencial;
    private javax.swing.JMenuItem jMenuItemEXPlineal;
    private javax.swing.JMenuItem jMenuItemEXPlogaritmica;
    private javax.swing.JMenuItem jMenuItemUmbral2Sliders;
    private javax.swing.JMenuItem jMenuItemUmbralAuto;
    private javax.swing.JMenuItem jMenuItemUmbralAutoOtsu;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jDesktopPanePrincipal
     */
    public javax.swing.JDesktopPane getjDesktopPanePrincipal() {
        return jDesktopPanePrincipal;
    }

    /**
     * @param jDesktopPanePrincipal the jDesktopPanePrincipal to set
     */
    public void setjDesktopPanePrincipal(javax.swing.JDesktopPane jDesktopPanePrincipal) {
        this.jDesktopPanePrincipal = jDesktopPanePrincipal;
    }
}
