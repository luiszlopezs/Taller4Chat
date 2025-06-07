/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

/**
 *
 * @author hailen
 */
public class ClienteThread extends Thread {

    DataInputStream entrada;
    private ControlCliente cCliente;
//    public static Vector<ClienteThread> clientesActivos = new Vector(); //c

    public ClienteThread(DataInputStream entrada, ControlCliente cCliente) throws IOException {
        this.entrada = entrada;
        this.cCliente = cCliente;
    }

    public void run() {
        String menser = "", amigo = "";
        int opcion = 0;
        while (true) {
            try {
                opcion = entrada.readInt();
                switch (opcion) {
                    case 1://mensage enviado
                        menser = entrada.readUTF();
                        System.out.println("ECO del servidor:" + menser);
                        cCliente.getcPrinc().getcVentana().getvCliente().mostrarMsg(menser);
                        break;
                    case 2://se agrega
                        menser = entrada.readUTF();
                        cCliente.getcPrinc().getcVentana().getvCliente().agregarUser(menser);
                        break;
                    case 3://mensage de amigo
                        amigo = entrada.readUTF();
                        menser = entrada.readUTF();
                        cCliente.getcPrinc().getcVentana().mensageAmigo(amigo, menser);
                        System.out.println("ECO del servidor:" + menser);
                        break;
                    case 4: // actualización de usuarios conectados
                        int cantidad = entrada.readInt();
                        String[] usuarios = new String[cantidad];
                        for (int i = 0; i < cantidad; i++) {
                            usuarios[i] = entrada.readUTF();
                        }
                        cCliente.actualizarListaUsuarios(usuarios);
                        break;

                }
            } catch (IOException e) {
                System.out.println("Error en la comunicaci�n " + "Informaci�n para el usuario");
                break;
            }
        }

        System.out.println("se desconecto el servidor");
    }

}
