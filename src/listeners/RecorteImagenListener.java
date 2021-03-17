/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameImagen;
import gui.JInternalFrameImagenRecorte;
import gui.JInternalFrameModificar;
import gui.JInternalFrameRecorte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author working
 */
public class RecorteImagenListener implements ActionListener{
    
     
    private  JFramePrincipal framePrincipal;

    public RecorteImagenListener(JFramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        if (item.getText().equals("Recorte")) {
            
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
    
            JInternalFrameRecorte internalNuevo = new JInternalFrameRecorte(internal, this.framePrincipal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            
        }

        if (item.getText().equals("Pegar en otra imagen")) {

            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            JInternalFrameRecorte internalNuevo = new JInternalFrameRecorte(internal, this.framePrincipal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);

        }
    }

}
