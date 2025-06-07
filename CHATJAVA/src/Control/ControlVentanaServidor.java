/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Vista.VistaServidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hailen
 */
public class ControlVentanaServidor implements ActionListener {

    private ControlPrincipalServidor cPrinc;

    private VistaServidor vServidor;

    public ControlVentanaServidor(ControlPrincipalServidor cPrinc) {
        this.cPrinc = cPrinc;
        vServidor = new VistaServidor(this);
        
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {

            
        }
    }

    public VistaServidor getvServidor() {
        return vServidor;
    }

    public void setvServidor(VistaServidor vServidor) {
        this.vServidor = vServidor;
    }

}
