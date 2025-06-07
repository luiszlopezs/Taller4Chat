/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Control.ControlVentanaServidor;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class VistaServidor extends JFrame {

    private ControlVentanaServidor cVentana;
    JTextArea txaMostrar;

    public VistaServidor(ControlVentanaServidor cVentana) {
        this.cVentana = cVentana;
        super("Consola servidor");
        txaMostrar = new JTextArea();

        this.setContentPane(new JScrollPane(txaMostrar));
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }

    public JTextArea getTxaMostrar() {
        return txaMostrar;
    }

    public void setTxaMostrar(JTextArea txaMostrar) {
        this.txaMostrar = txaMostrar;
    }

    public void mostrar(String msg) {
        txaMostrar.append(msg + "\n");
    }

    public File rutaJfileChooserListasBan() {
        File f;
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        fc.showDialog(null, "Seleccionar Archivo Lista Groserias/Reemplazo");

        f = fc.getSelectedFile();
        
        return f;
    }
}
