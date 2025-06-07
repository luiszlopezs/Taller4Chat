/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author hailen
 */
public class Servidor {

    private ArrayList<String> groserias;
    private ArrayList<String> reemplazos;

    private ServerSocket serv;
    private ServerSocket serv2;
    boolean listening = true;

    public Servidor() {
        groserias = new ArrayList();
        reemplazos = new ArrayList();
        cargarPalabras();
        serv = null;//para comunicacion
        serv2 = null;//para enviar mensajes    
    }

    public ServerSocket getServ() {
        return serv;
    }

    public void setServ(ServerSocket serv) {
        this.serv = serv;
    }

    public ServerSocket getServ2() {
        return serv2;
    }

    public void setServ2(ServerSocket serv2) {
        this.serv2 = serv2;
    }

    public boolean isListening() {
        return listening;
    }

    public void setListening(boolean listening) {
        this.listening = listening;
    }

    public ArrayList<String> getGroserias() {
        return groserias;
    }

    public void setGroserias(ArrayList<String> groserias) {
        this.groserias = groserias;
    }

    public ArrayList<String> getReemplazos() {
        return reemplazos;
    }

    public void setReemplazos(ArrayList<String> reemplazos) {
        this.reemplazos = reemplazos;
    }
    

    public void cargarPalabras() {
        groserias.add("marica");
        groserias.add("marika");
        groserias.add("gonorrea");
        groserias.add("hijueputa");
        groserias.add("malparido");
        groserias.add("carechimba");
        groserias.add("careverga");
        groserias.add("pichurria");
        groserias.add("verga");
        groserias.add("pirobo");
        groserias.add("culicagado");
        groserias.add("monda");
        groserias.add("mierda");
        groserias.add("puta");
        groserias.add("puto");
        groserias.add("perra");
        groserias.add("zorra");
        groserias.add("cojudo");
        groserias.add("idiota");
        groserias.add("imbécil");
        groserias.add("imbecil");
        groserias.add("estúpido");
        groserias.add("estupido");
        groserias.add("pendejo");
        groserias.add("culero");
        groserias.add("cabron");
        groserias.add("mierdero");
        groserias.add("jueputa");
        groserias.add("caremonda");
        
        //reemplazos de las groserias
        reemplazos.add("pastelito");
        reemplazos.add("florcita");
        reemplazos.add("arcoíris");
        reemplazos.add("ponycornio");
        reemplazos.add("gatito rosa");
        reemplazos.add("chocolatina");
        reemplazos.add("abrazo mágico");
        reemplazos.add("zanahoria feliz");
        reemplazos.add("pollito tierno");
        reemplazos.add("tacita de té");
        reemplazos.add("rosita fresita");

    }

}
