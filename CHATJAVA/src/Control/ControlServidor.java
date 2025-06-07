/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Servidor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hailen
 */
public class ControlServidor {
    
    private ControlPrincipalServidor cPrinc;

    private Servidor servidor;
    private ServidorThread servidorThread;

    public ControlServidor(ControlPrincipalServidor cPrinc) {
        this.cPrinc = cPrinc;
        servidor = new Servidor();
        runServer();
    }

    public void runServer() {
        try {
            servidor.setServ(new ServerSocket(8081));
            servidor.setServ2(new ServerSocket(8082));
            cPrinc.getcVentana().getvServidor().mostrar(".::Servidor activo :");
            while (servidor.isListening()) {
                Socket sock = null, sock2 = null;
                try {
                    //muestra un mensaje en la vista del server
                    cPrinc.getcVentana().getvServidor().mostrar("Esperando Usuarios");
                    sock = servidor.getServ().accept();
                    sock2 = servidor.getServ2().accept();
                } catch (IOException e) {
                    //muestra un mensaje en la vista del server
                    cPrinc.getcVentana().getvServidor().mostrar("Accept failed: " + servidor.getServ() + ", " + e.getMessage());
                    continue;
                }
                ServidorThread user = new ServidorThread(sock, sock2, this);
                user.start();
            }

        } catch (IOException e) {
            //muestra un mensaje en la vista del server
            cPrinc.getcVentana().getvServidor().mostrar("error :" + e);
        }
    }

    public ControlPrincipalServidor getcPrinc() {
        return cPrinc;
    }
    
    
}
