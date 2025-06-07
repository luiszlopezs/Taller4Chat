/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Cliente;
import Vista.VistaAyuda;
import Vista.VistaCliente;
import Vista.VistaPrivada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hailen
 */
public class ControlVentanaCliente implements ActionListener {

    private ControlPrincipalCliente cPrinc;
    private VistaAyuda vAyuda;
    private VistaCliente vCliente;
    private VistaPrivada vPrivada;
    private String nombre;
    private String ip;

    public ControlVentanaCliente(ControlPrincipalCliente cPrinc) {
        this.cPrinc = cPrinc;
        cargarVistaCliente();
        cargarVistaPrivada();
//        cPrinc.getcCliente().getCliente().setNombre(vCliente.nombreCliente());
//        Cliente.setIPserver(vCliente.numeroIP());
        nombre = vCliente.nombreCliente();
        ip = vCliente.numeroIP();
        
        System.out.println(ip);
        System.out.println(nombre);
        
        
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        String destinatario = "";
        switch (comando) {
            case "CLIENTE_ENVIAR":
                String mensaje = vCliente.getMensaje();
                cPrinc.enviarMensajePublico(mensaje);
                vCliente.getTxtMensage().setText("");
                System.out.println(mensaje);
                break;
            case "CLIENTE_PRIVADO":
                
                int pos = vCliente.getUsuarioSeleccionado();
                if (pos >= 0) {
                    //destinatario = vPrivada.setDestinatario(nomUsers.get(pos));
                    vPrivada.setAmigo(vCliente.getNomUsers().get(pos));  
                    vPrivada.setVisible(true);
                }
                break;
            case "PRIVADO_ENVIAR":
                String mensaje2 = vPrivada.getMensaje();
                destinatario = vPrivada.getAmigo();
                vPrivada.mostrarMsg(cPrinc.getcCliente().getCliente().getNombre() + ">" + mensaje2);
                cPrinc.enviarMensajePrivado(destinatario, mensaje2);
                vPrivada.getTxtMensage().setText("");
                break;
        }
    }

    public void cargarVistaCliente() {
        vCliente = new VistaCliente(this);

        vCliente.getBtnEnviar().setActionCommand("CLIENTE_ENVIAR");
        vCliente.getBtnEnviar().addActionListener(this);

        vCliente.getBtnPrivado().setActionCommand("CLIENTE_PRIVADO");
        vCliente.getBtnPrivado().addActionListener(this);


    }

    public void cargarVistaPrivada() {
        vPrivada = new VistaPrivada(this);

        vPrivada.getBtnEnviar().setActionCommand("PRIVADO_ENVIAR");
        vPrivada.getBtnEnviar().addActionListener(this);

        //vPrivada.setVisible(true);
    }

    public VistaAyuda getvAyuda() {
        return vAyuda;
    }

    public void setvAyuda(VistaAyuda vAyuda) {
        this.vAyuda = vAyuda;
    }

    public VistaCliente getvCliente() {
        return vCliente;
    }

    public void setvCliente(VistaCliente vCliente) {
        this.vCliente = vCliente;
    }

    public VistaPrivada getvPrivada() {
        return vPrivada;
    }

    public void setvPrivada(VistaPrivada vPrivada) {
        this.vPrivada = vPrivada;
    }

     public void mensageAmigo(String amigo,String msg)
     {
        vPrivada.setAmigo(amigo);           
        vPrivada.mostrarMsg(msg);        
        vPrivada.setVisible(true);
     }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    

    
}
