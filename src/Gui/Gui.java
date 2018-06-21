/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Thread.AnimalThread;
import Thread.RegresoThread;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author LN710Q
 */
public class Gui extends JFrame {

    private JLabel[] labels;
    private JButton inicio;
    private JButton Regreso;
    private String[] nombres = {"canguro", "tortuga", "dragon"};

    public Gui() {
        super("Carrera de animales");
        initialComponets();
    }

    private void initialComponets() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        labels = new JLabel[3];
        inicio = new JButton("Inicio");
        Regreso = new JButton("Regreso");
        Container container = getContentPane();

        for (int i = 0; i < 3; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i] + ".gif")));
            labels[i].setBounds(10, (i * 220) + 10, 200, 200);
            container.add(labels[i]);
        }
        inicio.setBounds(10, 0, 100, 30);
        container.add(inicio);

        inicio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalThread canguro = new AnimalThread("canguro", labels[0].getX(), labels[0].getY(), 510, labels[0]);
                AnimalThread tortuga = new AnimalThread("tortuga", labels[1].getX(), labels[1].getY(), 510, labels[1]);
                AnimalThread dragon = new AnimalThread("dragon", labels[2].getX(), labels[2].getY(), 510, labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();

            }
        });
        setSize(700, 650);

        Regreso.setBounds(410, 0, 100, 30);
        container.add(Regreso);
        Regreso.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RegresoThread canguro = new RegresoThread("canguro", labels[0].getX(), labels[0].getY(), 0, labels[0]);
                RegresoThread tortuga = new RegresoThread("tortuga", labels[1].getX(), labels[1].getY(), 0, labels[1]);
                RegresoThread dragon = new RegresoThread("dragon", labels[2].getX(), labels[2].getY(), 0, labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();

            }
        });
        setSize(700, 650);

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui().setVisible(true);
            }
        });
        
    }

}
