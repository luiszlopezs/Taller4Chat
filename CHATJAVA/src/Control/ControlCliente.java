/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Cliente;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author hailen
 */
public class ControlCliente {

    private ControlPrincipalCliente cPrinc;
    private Cliente cliente;
    private ClienteThread clienteThread;

    public ControlCliente(ControlPrincipalCliente cPrinc) throws IOException {
        this.cPrinc = cPrinc;
        cliente = new Cliente();
        System.out.println(cPrinc.getcVentana().getIp());
        System.out.println(cPrinc.getcVentana().getNombre());
        Cliente.setIPserver(cPrinc.getcVentana().getIp());
        cliente.setNombre(cPrinc.getcVentana().getNombre());

        cliente.conexion();
        
        System.out.println("Antes de crear ClienteThread");
        clienteThread = new ClienteThread(cliente.getEntrada2(), this);
        System.out.println("Después de crear ClienteThread");
        clienteThread.start();
        System.out.println("Después de start()");
        System.out.println("Conexion terminada");

        System.out.println("muestra ventana");
    }

    public void enviarMensajePublico(String mensaje) throws IOException {
        //getear el texto de la vista a este metodo
        cliente.enviarMensajePublico(mensaje);

    }

    public void enviarMensajePrivado(String amigo, String mensaje) throws IOException {
        //getear el texto de la vista a este metodo
        cliente.enviarMensajePrivado(amigo, mensaje);

    }

    public Vector<String> pedirUsuarios() throws IOException {
        return cliente.pedirUsuarios();

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteThread getClienteThread() {
        return clienteThread;
    }

    public void setClienteThread(ClienteThread clienteThread) {
        this.clienteThread = clienteThread;
    }

    public void conexionCliente() throws IOException {
        cliente.conexion();
    }

    public ControlPrincipalCliente getcPrinc() {
        return cPrinc;
    }
    
    
    
    

}
