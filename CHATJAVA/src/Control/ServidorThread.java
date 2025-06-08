/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author hailen
 */
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Administrador
 */
public class ServidorThread extends Thread {

    Socket scli = null;
    Socket scli2 = null;
    DataInputStream entrada = null;
    DataOutputStream salida = null;
    DataOutputStream salida2 = null;
    public static Vector<ServidorThread> clientesActivos = new Vector();
    String nameUser;
    private ControlServidor cServidor;

    public ServidorThread(Socket scliente, Socket scliente2, ControlServidor cServidor) {
        scli = scliente;
        scli2 = scliente2;
        this.cServidor = cServidor;
        nameUser = "";
        clientesActivos.add(this);
        cServidor.getcPrinc().getcVentana().getvServidor().mostrar("cliente agregado: " + this);
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String name) {
        nameUser = name;
    }

    public void run() {
        cServidor.getcPrinc().getcVentana().getvServidor().mostrar(".::Esperando Mensajes :");

        try {
            entrada = new DataInputStream(scli.getInputStream());
            salida = new DataOutputStream(scli.getOutputStream());
            salida2 = new DataOutputStream(scli2.getOutputStream());
            this.setNameUser(entrada.readUTF());
            enviarListaUsuariosConectados(); //Se envía la lista actualizada a cada cliente
        } catch (IOException e) {
            e.printStackTrace();
        }

        int opcion = 0, numUsers = 0;
        String amigo = "", mencli = "";
        
        while (true) {
            try {
                opcion = entrada.readInt();
                switch (opcion) {
                    case 1://envio de mensaje a todos
                        mencli = entrada.readUTF();
                        cServidor.getcPrinc().getcVentana().getvServidor().mostrar("mensaje recibido " + mencli);
                        enviaMsg(cServidor.banearPalabras(mencli));
                        break;
                    case 2://envio de lista de activos
                        numUsers = clientesActivos.size();
                        salida.writeInt(numUsers);
                        for (int i = 0; i < numUsers; i++) {
                            salida.writeUTF(clientesActivos.get(i).nameUser);
                        }
                        break;
                    case 3: // envia mensage a uno solo
                        amigo = entrada.readUTF();//captura nombre de amigo
                        mencli = entrada.readUTF();//mensage enviado
                        enviaMsg(amigo, cServidor.banearPalabras(mencli));
                        break;
                }
            } catch (IOException e) {
                System.out.println("El cliente termino la conexion");
                break;
            }
        }
        cServidor.getcPrinc().getcVentana().getvServidor().mostrar("Se removio un usuario");
        clientesActivos.removeElement(this);
        enviarListaUsuariosConectados(); // después de remover un cliente, se vuelve a enviar la lista de usuarios actualizada
        
        try {
            cServidor.getcPrinc().getcVentana().getvServidor().mostrar("Se desconecto un usuario");
            scli.close();
        } catch (Exception et) {
            cServidor.getcPrinc().getcVentana().getvServidor().mostrar("no se puede cerrar el socket");
        }
    }

    public void enviaMsg(String mencli2) {
        ServidorThread user = null;
        for (int i = 0; i < clientesActivos.size(); i++) {
            cServidor.getcPrinc().getcVentana().getvServidor().mostrar("MENSAJE DEVUELTO:" + mencli2);
            try {
                user = clientesActivos.get(i);
                user.salida2.writeInt(1);//opcion de mensage 
                user.salida2.writeUTF("" + this.getNameUser() + " >" + mencli2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void enviarListaUsuariosConectados() {
    try {
        Vector<String> nombres = new Vector<>();
        for (ServidorThread cli : clientesActivos) {
            nombres.add(cli.getNameUser());
        }

        for (ServidorThread cli : clientesActivos) {
            cli.salida2.writeInt(4); // nuevo código para actualizar lista de usuarios
            cli.salida2.writeInt(nombres.size());
            for (String nombre : nombres) {
                cli.salida2.writeUTF(nombre);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    private void enviaMsg(String amigo, String mencli) {
        ServidorThread user = null;
        for (int i = 0; i < clientesActivos.size(); i++) {
            try {
                user = clientesActivos.get(i);
                if (user.nameUser.equals(amigo)) {
                    user.salida2.writeInt(3);//opcion de mensaje amigo   
                    user.salida2.writeUTF(this.getNameUser());
                    user.salida2.writeUTF("" + this.getNameUser() + ">" + mencli);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Vector<ServidorThread> getClientesActivos() {
        return clientesActivos;
    }
    
}
