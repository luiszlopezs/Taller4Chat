/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author hailen
 */
public class ControlPrincipalServidor {
    
    private ControlServidor cServidor;
    private ControlVentanaServidor cVentana;

    public ControlPrincipalServidor() {
       
       cVentana = new ControlVentanaServidor(this);
       cServidor = new ControlServidor(this);
       
        
    }

    public ControlServidor getcServidor() {
        return cServidor;
    }

    public ControlVentanaServidor getcVentana() {
        return cVentana;
    }
    
    
    
    
}
