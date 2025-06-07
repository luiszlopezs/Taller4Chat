/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Control.ControlVentanaCliente;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

public class VistaCliente extends JFrame {

    private ControlVentanaCliente cVentana;
    private JTextArea panMostrar;
    private JTextField txtMensage;
    private JButton butEnviar;
    private JButton butPrivado;
    private JList<String> lstActivos;
    private DefaultListModel<String> listModel;
    private Vector<String> nomUsers;

    public VistaCliente(ControlVentanaCliente cVentana) {
        this.cVentana = cVentana;
        super("Cliente Chat");
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        txtMensage = new JTextField(30);
        butEnviar = new JButton("Enviar");
        butPrivado = new JButton("Privado");
        panMostrar = new JTextArea();
        panMostrar.setEditable(false);
        listModel = new DefaultListModel<>();
        lstActivos = new JList<>(listModel);
    }

    private void setupLayout() {
        // Panel inferior (área de mensaje y botón enviar)
        JPanel panAbajo = new JPanel(new BorderLayout());
        panAbajo.add(new JLabel("  Ingrese mensaje a enviar:"), BorderLayout.NORTH);
        panAbajo.add(txtMensage, BorderLayout.CENTER);
        panAbajo.add(butEnviar, BorderLayout.EAST);

        // Panel derecho (área de chat y panel inferior)
        JPanel panRight = new JPanel(new BorderLayout());
        panRight.add(new JScrollPane(panMostrar), BorderLayout.CENTER);
        panRight.add(panAbajo, BorderLayout.SOUTH);

        // Panel izquierdo (lista de usuarios y botón privado)
        JPanel panLeft = new JPanel(new BorderLayout());
        panLeft.add(new JScrollPane(lstActivos), BorderLayout.CENTER);
        panLeft.add(butPrivado, BorderLayout.NORTH);

        // Barra de menú
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAyuda = new JMenuItem("Ayuda");
        itemAyuda.setActionCommand("AYUDA");
        //itemAyuda.addActionListener(this::menuActionPerformed);
        menuAyuda.add(itemAyuda);
        barraMenu.add(menuAyuda);

        // SplitPane central (une izquierda y derecha)
        JSplitPane splitCentral = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panLeft, panRight);
        splitCentral.setDividerLocation(150);
        splitCentral.setDividerSize(5);
        splitCentral.setOneTouchExpandable(true);

        // Configuración final de la ventana
        setLayout(new BorderLayout());
        add(barraMenu, BorderLayout.NORTH);
        add(splitCentral, BorderLayout.CENTER);

        setSize(600, 400);
        setMinimumSize(new Dimension(500, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JTextArea getPanMostrar() {
        return panMostrar;
    }

    public void setPanMostrar(JTextArea panMostrar) {
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

    public JButton getBtnPrivado() {
        return butPrivado;
    }

    public void setBtnPrivado(JButton butPrivado) {
        this.butPrivado = butPrivado;
    }

    public JList<String> getLstActivos() {
        return lstActivos;
    }

    public void setLstActivos(JList<String> lstActivos) {
        this.lstActivos = lstActivos;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    public void setListModel(DefaultListModel<String> listModel) {
        this.listModel = listModel;
    }

    // Métodos para interactuar con el controlador


    public void setNombreUser(String user) {
        //lblNomUser.setText("Usuario " + user);
    }

    public void mostrarMsg(String msg) {
        this.panMostrar.append(msg + "\n");
    }

    public void ponerActivos(Vector datos) {
        nomUsers = datos;
        ponerDatosList(this.lstActivos, nomUsers);
    }

    public void agregarUser(String user) {
        nomUsers.add(user);
        ponerDatosList(this.lstActivos, nomUsers);
    }

    public void retirraUser(String user) {
        nomUsers.remove(user);
        ponerDatosList(this.lstActivos, nomUsers);
    }

    private void ponerDatosList(JList list, final Vector datos) {
        list.setModel(new AbstractListModel() {
            @Override
            public int getSize() {
                return datos.size();
            }

            @Override
            public Object getElementAt(int i) {
                return datos.get(i);
            }
        });
    }

    public String getMensaje() {
        return txtMensage.getText();
    }

    public void limpiarCampoTexto() {
        txtMensage.setText("");
    }

    public int getUsuarioSeleccionado() {
        return lstActivos.getSelectedIndex();
    }

    public void mostrar() {
        setVisible(true);
    }

    public String nombreCliente() {
        String nomCliente = JOptionPane.showInputDialog("Introducir Nick :");
        return nomCliente;
    }

    public String numeroIP() {
        String IP = JOptionPane.showInputDialog("Introducir IP_SERVER :", "localhost");

        return IP;
    }

    public Vector<String> getNomUsers() {
        return nomUsers;
    }
    
    
}
