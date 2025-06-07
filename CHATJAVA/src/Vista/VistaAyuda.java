/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import Control.ControlVentanaCliente;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.URL;

/**
 *
 * @author Administrador
 */
public class VistaAyuda extends JFrame{
    private ControlVentanaCliente cVentana;
    
    
    /** Creates a new instance of VentanaAyuda */
     JScrollPane panelPrincipal;
    JEditorPane html;
    public VistaAyuda(ControlVentanaCliente cVentana) {
        this.cVentana = cVentana;
        super("Ventana de Ayuda :");
        setSize(600,700);
        setLocation(450,0);
        panelPrincipal=new JScrollPane();
        
        try{ 
            URL url=getClass().getResource("index.html");
            html=new JEditorPane(url);
            html.setEditable(false);
            setVisible(true);
             
        }catch(Exception e){
            e.getMessage();
        }
        
        JViewport jv=panelPrincipal.getViewport();
        jv.add(html);
        
        setContentPane(panelPrincipal);
    }
    
}