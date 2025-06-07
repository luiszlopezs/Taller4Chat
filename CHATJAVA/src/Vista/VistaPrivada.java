/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Control.ControlVentanaCliente;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VistaPrivada extends JFrame {

    private ControlVentanaCliente cVentana;
    private JTextArea panMostrar;
    private JTextField txtMensage;
    private JButton butEnviar;
    private String amigo;

    public VistaPrivada(ControlVentanaCliente cVentana) {
        this.cVentana = cVentana;
        super("Mensaje Privado");
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        txtMensage = new JTextField(30);
        butEnviar = new JButton("Enviar");
        panMostrar = new JTextArea();
        panMostrar.setEditable(false);
    }

    private void setupLayout() {
        // Panel inferior (campo de texto y botón enviar)
        JPanel panAbajo = new JPanel(new BorderLayout());
        panAbajo.add(new JLabel("  Mensaje privado:"), BorderLayout.NORTH);
        panAbajo.add(txtMensage, BorderLayout.CENTER);
        panAbajo.add(butEnviar, BorderLayout.EAST);

        // Configuración principal
        setLayout(new BorderLayout());
        add(new JScrollPane(panMostrar), BorderLayout.CENTER);
        add(panAbajo, BorderLayout.SOUTH);

        // Configuración de la ventana
        setSize(400, 300);
        setMinimumSize(new Dimension(300, 200));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    //Getters y setters
    public JTextArea getPanelMostrar() {
        return panMostrar;
    }

    public void setPanelMostrar(JTextArea panMostrar) {
        this.panMostrar = panMostrar;
    }

    public JTextField getTxtMensage() {
        return txtMensage;
    }

    public void setTxtMensage(JTextField txtMensage) {
        this.txtMensage = txtMensage;
    }

    public JButton getBtnEnviar() {
        return butEnviar;
    }

    public void setBtnEnviar(JButton butEnviar) {
        this.butEnviar = butEnviar;
    }

    public void setAmigo(String ami) {
        this.amigo = ami;
        this.setTitle(ami);
    }

    private void cerrarVentana() {
        this.setVisible(false);
    }

    public void mostrarMsg(String msg) {
        this.panMostrar.append(msg + "\n");
    }

    public String getMensaje() {
        return txtMensage.getText();
    }



    public void limpiarCampoTexto() {
        txtMensage.setText("");
    }

    public void mostrar() {
        setVisible(true);
    }

    public String getAmigo() {
        return amigo;
    }
    
    
}
