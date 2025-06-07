/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

/**
 *
 * @author hailen
 */
public class ControlPrincipalCliente {

    private ControlVentanaCliente cVentana;
    private ControlCliente cCliente;

    public ControlPrincipalCliente() throws IOException {

        cVentana = new ControlVentanaCliente(this);
        cCliente = new ControlCliente(this);
        cVentana.getvCliente().ponerActivos(cCliente.pedirUsuarios());
        System.out.println(cCliente.pedirUsuarios());
        cVentana.getvCliente().setVisible(true);
        System.out.println("MUESTRA");
    }

    public ControlVentanaCliente getcVentana() {
        return cVentana;
    }

    public void setcVentana(ControlVentanaCliente cVentana) {
        this.cVentana = cVentana;
    }

    public ControlCliente getcCliente() {
        return cCliente;
    }

    public void setcCliente(ControlCliente cCliente) {
        this.cCliente = cCliente;
    }

    public void enviarMensajePrivado(String amigo, String contenido) {
        try {
            cCliente.enviarMensajePrivado(amigo, contenido);
        } catch (IOException ex) {
            System.getLogger(ControlPrincipalCliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void enviarMensajePublico(String contenido) {
        try {
            cCliente.enviarMensajePublico(contenido);
        } catch (IOException ex) {
            System.getLogger(ControlPrincipalCliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public Vector<String> pedirUsuarios() {
        try {
            return cCliente.pedirUsuarios();
        } catch (IOException ex) {
            System.getLogger(ControlPrincipalCliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }



}
