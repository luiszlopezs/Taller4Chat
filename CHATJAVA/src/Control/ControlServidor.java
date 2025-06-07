/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Servidor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Random;

/**
 *
 * @author hailen
 */
public class ControlServidor {

    private ControlPrincipalServidor cPrinc;

    private Servidor servidor;
    private ServidorThread servidorThread;
    private Random random;

    public ControlServidor(ControlPrincipalServidor cPrinc) {
        this.cPrinc = cPrinc;
        random = new Random();
        servidor = new Servidor();

    }

    public void runServer() {
        try {
            cPrinc.metodoCortoListasBan();
            System.out.println(servidor.getGroserias());
            System.out.println(servidor.getReemplazos());
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

    public String banearPalabras(String mensaje) {
        String[] palabras = mensaje.split("\\s+");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            String palabraLimpia = palabra.toLowerCase().replaceAll("[^a-záéíóúüñ]", "");

            if (servidor.getGroserias().contains(palabraLimpia)) {
                String reemplazo = servidor.getReemplazos().get(random.nextInt(servidor.getReemplazos().size()));
                resultado.append(reemplazo);
            } else {
                resultado.append(palabra);
            }
            resultado.append(" ");
        }

        return resultado.toString().trim();
    }

    public void inicializarDesdeProperties(Properties props) {

        int i = 1;
        int i2 = 1;
        while (true) {
            if (props.getProperty("groseria" + i) == null) {
                break;
            }
            servidor.getGroserias().add(props.getProperty("groseria" + i));

            // Leer los valores
            // Si no hay más gatos, salir del ciclo
            i++;

        }

        while (true) {

            if (props.getProperty("reemplazo" + i2) == null) {
                break;
            }
            servidor.getReemplazos().add(props.getProperty("reemplazo" + i2));

            i2++;
        }
    }

    public ControlPrincipalServidor getcPrinc() {
        return cPrinc;
    }

}
