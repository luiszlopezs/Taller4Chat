/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cliente {

    private String nombre;
    private String mensajeRecibido;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private DataInputStream entrada2;
    private static String IPserver;

    Socket comunication = null;//para la comunicacion
    Socket comunication2 = null;//para recibir msg

    public Cliente() {
    }

    public void conexion() throws IOException {
        System.out.println("Entrando a conexion()");

        comunication = new Socket(Cliente.IPserver, 8081);
        System.out.println("Socket 1 creado");

        comunication2 = new Socket(Cliente.IPserver, 8082);
        System.out.println("Socket 2 creado");

        // Primero salida, luego entrada
        salida = new DataOutputStream(comunication.getOutputStream());
        System.out.println("Salida creada: " + salida);

        entrada = new DataInputStream(comunication.getInputStream());
        System.out.println("Entrada 1 creada");

        // Segundo socket (igual)
        // Si vas a usar otro flujo en comunication2, igual hazlo bien ordenado.
        entrada2 = new DataInputStream(comunication2.getInputStream());
        System.out.println("Entrada 2 creada");

        salida.writeUTF(nombre);

    }

    public Vector<String> pedirUsuarios() throws IOException {
        Vector<String> users = new Vector();

        salida.writeInt(2);
        int numUsers = entrada.readInt();
        for (int i = 0; i < numUsers; i++) {
            users.add(entrada.readUTF());
        }

        return users;
    }

    public void enviarMensajePublico(String mensaje) throws IOException {

        System.out.println("el mensaje enviado desde el cliente es :"
                + mensaje);
        salida.writeInt(1);
        salida.writeUTF(mensaje);

    }

    public void enviarMensajePrivado(String amigo, String mensaje) throws IOException {

        System.out.println("el mensaje enviado desde el cliente es :"
                + mensaje);
        salida.writeInt(3);//opcion de mensage a amigo
        salida.writeUTF(amigo);
        salida.writeUTF(mensaje);

    }

    public String getNombre() {
        return nombre;
    }

    public static String getIPserver() {
        return IPserver;
    }

    public static void setIPserver(String IPserver) {
        Cliente.IPserver = IPserver;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DataInputStream getEntrada2() {
        return entrada2;
    }

    public void setEntrada2(DataInputStream entrada2) {
        this.entrada2 = entrada2;
    }

}
