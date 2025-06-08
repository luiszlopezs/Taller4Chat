package Vista;

import Control.ControlVentanaCliente;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
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

        // Establecer icono estilo WhatsApp
        setIconImage(new ImageIcon(getClass().getResource("/resources/img3.png")).getImage());

        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        txtMensage = new JTextField(30);
        butEnviar = new JButton("Enviar");
        butPrivado = new JButton("Privado");
        panMostrar = new JTextArea();
        
        // Área de texto de chat
panMostrar = new JTextArea();
    panMostrar.setEditable(false);
    panMostrar.setOpaque(false); // Fondo transparente
    panMostrar.setForeground(Color.BLACK); // Color visible sobre fondo claro
    panMostrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
    panMostrar.setLineWrap(true);
    panMostrar.setWrapStyleWord(true);



        // Personalización botones estilo WhatsApp
        butEnviar.setBackground(new Color(37, 211, 102)); // verde WhatsApp
        butEnviar.setForeground(Color.WHITE);
        butEnviar.setFocusPainted(false);
        butEnviar.setFont(new Font("Segoe UI", Font.BOLD, 13));

        butPrivado.setBackground(new Color(18, 140, 126)); // tono más oscuro
        butPrivado.setForeground(Color.WHITE);
        butPrivado.setFocusPainted(false);
        butPrivado.setFont(new Font("Segoe UI", Font.BOLD, 13));

        listModel = new DefaultListModel<>();
        lstActivos = new JList<>(listModel);
        lstActivos.setBackground(new Color(245, 245, 245));
        lstActivos.setSelectionBackground(new Color(37, 211, 102));
        lstActivos.setSelectionForeground(Color.WHITE);
        lstActivos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    }
private JLabel lblAdvertencia;
private JLabel lblNombreUsuario;

private void setupLayout() {
    // Panel inferior (área de mensaje, botón enviar y advertencia)
    JPanel panAbajo = new JPanel(new BorderLayout());
    panAbajo.add(new JLabel("  Ingrese mensaje a enviar:"), BorderLayout.NORTH);
    panAbajo.add(txtMensage, BorderLayout.CENTER);
    panAbajo.add(butEnviar, BorderLayout.EAST);

    // Etiqueta de advertencia (inicialmente vacía)
    lblAdvertencia = new JLabel("");
    lblAdvertencia.setForeground(Color.RED);
    lblAdvertencia.setFont(new Font("Segoe UI", Font.BOLD, 12));
    panAbajo.add(lblAdvertencia, BorderLayout.SOUTH);

    // Etiqueta con el nombre del usuario
    lblNombreUsuario = new JLabel("Usuario: ", SwingConstants.LEFT);
    lblNombreUsuario.setFont(new Font("Segoe UI", Font.BOLD, 13));
    lblNombreUsuario.setForeground(new Color(18, 140, 126));

    // Fondo tipo WhatsApp en el área de mensajes
    JPanel fondoChat = new JPanel() {
    private Image bg = new ImageIcon(getClass().getResource("/resources/whatsapp_bg.png")).getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < getWidth(); x += bg.getWidth(null)) {
            for (int y = 0; y < getHeight(); y += bg.getHeight(null)) {
                g.drawImage(bg, x, y, this);
            }
        }
    }
};
fondoChat.setLayout(new BorderLayout());
fondoChat.add(panMostrar);

    JScrollPane scrollChat = new JScrollPane(fondoChat);
scrollChat.setOpaque(false);
scrollChat.getViewport().setOpaque(false);


    // Panel derecho (nombre usuario + chat + parte inferior)
    JPanel panRight = new JPanel(new BorderLayout());
    panRight.add(lblNombreUsuario, BorderLayout.NORTH);
    panRight.add(scrollChat, BorderLayout.CENTER);
    panRight.add(panAbajo, BorderLayout.SOUTH);

    // Panel izquierdo (lista de usuarios y botón privado)
    JPanel panLeft = new JPanel(new BorderLayout());
    JScrollPane scrollUsuarios = new JScrollPane(lstActivos);
    scrollUsuarios.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panLeft.add(scrollUsuarios, BorderLayout.CENTER);
    panLeft.add(butPrivado, BorderLayout.NORTH);

    // Barra de menú
    JMenuBar barraMenu = new JMenuBar();
    JMenu menuAyuda = new JMenu("Ayuda");
    JMenuItem itemAyuda = new JMenuItem("Ayuda");
    itemAyuda.setActionCommand("AYUDA");
    menuAyuda.add(itemAyuda);
    barraMenu.add(menuAyuda);

    // SplitPane central
    JSplitPane splitCentral = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panLeft, panRight);
    splitCentral.setDividerLocation(150);
    splitCentral.setDividerSize(5);
    splitCentral.setOneTouchExpandable(true);

    // Ventana
    setLayout(new BorderLayout());
    add(barraMenu, BorderLayout.NORTH);
    add(splitCentral, BorderLayout.CENTER);
    setSize(600, 400);
    setMinimumSize(new Dimension(500, 300));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(new Color(220, 248, 198));
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

    public void setNombreUsuario(String nombre) {
    lblNombreUsuario.setText("Usuario: " + nombre);
}

    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    public void setListModel(DefaultListModel<String> listModel) {
        this.listModel = listModel;
    }

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

    public void actualizarListaUsuarios(String[] usuarios) {
        Vector<String> nuevosUsuarios = new Vector<>(Arrays.asList(usuarios));
        ponerActivos(nuevosUsuarios);
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
        return JOptionPane.showInputDialog("Introducir Nick :");
    }

    public String numeroIP() {
        return JOptionPane.showInputDialog("Introducir IP_SERVER :", "localhost");
    }

    public Vector<String> getNomUsers() {
        return nomUsers;
    }
}
