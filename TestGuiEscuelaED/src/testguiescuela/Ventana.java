/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testguiescuela;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Instancio la ventana de la aplicación
 * @author Alba María Megías Guerrero
 * @see javax.swing.JFrame
 */
public class Ventana extends JFrame {

    /**
     * Constructor donde instanciamos la ventana de la aplicación.
     */
    public Ventana (){
        
        this.setContentPane(new Panel());
        this.setTitle(" - IES ALBA");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        
        // Cambiar Icono de la ventana
        Toolkit icon = Toolkit.getDefaultToolkit();
        Image changeIcon = icon.getImage("dibujar.png");
        this.setIconImage(changeIcon);
        

    }
}
