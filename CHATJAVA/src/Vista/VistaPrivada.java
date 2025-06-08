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
        aplicarEstiloWhatsApp();
    }

    private void initializeComponents() {
        txtMensage = new JTextField(30);
        txtMensage.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtMensage.setBackground(Color.WHITE);
        txtMensage.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        butEnviar = new JButton("Enviar");
        butEnviar.setBackground(new Color(37, 211, 102)); // verde WhatsApp
        butEnviar.setForeground(Color.WHITE);
        butEnviar.setFocusPainted(false);
        butEnviar.setFont(new Font("Segoe UI", Font.BOLD, 13));

        panMostrar = new JTextArea();
        panMostrar.setEditable(false);
        panMostrar.setBackground(new Color(230, 255, 230)); // fondo verde claro
        panMostrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panMostrar.setForeground(new Color(33, 33, 33));
        panMostrar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void setupLayout() {
        // Panel inferior (campo de texto y botón enviar)
        JPanel panAbajo = new JPanel(new BorderLayout(5, 5));
        JLabel lblMensaje = new JLabel("  Mensaje privado:");
        lblMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        panAbajo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panAbajo.add(lblMensaje, BorderLayout.NORTH);
        panAbajo.add(txtMensage, BorderLayout.CENTER);
        panAbajo.add(butEnviar, BorderLayout.EAST);

        // Scroll decorado
        JScrollPane scrollPane = new JScrollPane(panMostrar);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Configuración principal
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panAbajo, BorderLayout.SOUTH);

        // Configuración de la ventana
        getContentPane().setBackground(new Color(220, 248, 198)); // fondo tipo WhatsApp
        setSize(400, 300);
        setMinimumSize(new Dimension(300, 200));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void aplicarEstiloWhatsApp() {
        UIManager.put("OptionPane.background", new Color(236, 229, 221)); // #ECE5DD
        UIManager.put("Panel.background", new Color(236, 229, 221));      // Fondo de JOptionPane
        UIManager.put("OptionPane.messageForeground", new Color(48, 48, 48)); // Texto
        UIManager.put("Button.background", new Color(37, 211, 102));      // Verde WhatsApp
        UIManager.put("Button.foreground", Color.WHITE);                 // Texto blanco
        UIManager.put("Button.font", new Font("SansSerif", Font.PLAIN, 13));
        UIManager.put("OptionPane.messageFont", new Font("SansSerif", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("SansSerif", Font.PLAIN, 13));
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
