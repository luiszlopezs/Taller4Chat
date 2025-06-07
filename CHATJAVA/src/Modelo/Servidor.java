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
    

    

}
