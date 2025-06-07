/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author hailen
 */
public class ControlPrincipalServidor {

    private ControlServidor cServidor;
    private ControlVentanaServidor cVentana;

    public ControlPrincipalServidor() {

        cVentana = new ControlVentanaServidor(this);
        cServidor = new ControlServidor(this);
        cServidor.runServer();
        System.out.println("ssssssssssssssssss");

    }

    public ControlServidor getcServidor() {
        return cServidor;
    }

    public ControlVentanaServidor getcVentana() {
        return cVentana;
    }

    public void inicializarListasBan(File archivo) {
        if (archivo != null) {
            try (FileInputStream fis = new FileInputStream(archivo)) {
                Properties props = new Properties();
                props.load(fis);

                cServidor.inicializarDesdeProperties(props);

            } catch (IOException e) {

            }
        } else {

        }
    }
    
    public void metodoCortoListasBan(){
        inicializarListasBan(cVentana.getvServidor().rutaJfileChooserListasBan());
        cVentana.getvServidor().setVisible(true);
    }

}
