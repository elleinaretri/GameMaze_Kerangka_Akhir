/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import Model.*;

/**
 *
 * @author user only
 */
public class GameFrame extends JFrame {

    private Tempat peta;
    private JLabel perintahlabel;
    private JTextField perintahText, perintahTextHistory;
    private JButton okButton;
    private JMenuItem exitMenuItem, bacaKonfigurasiMenuItem, simpanKonfigurasiMenuItem;
    private JMenuBar menuBar;
    private JMenu gameMenu;

    public GameFrame(String title, Tempat peta) {
        setTitle(title);
        this.peta = peta;
        this.init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public GameFrame(String title) {
        this.setTitle(title);
        this.init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        this.setSize(500, 480);
        this.setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        gameMenu = new JMenu("GAME");
        exitMenuItem = new JMenuItem("EXIT");
        bacaKonfigurasiMenuItem = new JMenuItem("BACA");
        simpanKonfigurasiMenuItem = new JMenuItem("SIMPAN");
        gameMenu.add(bacaKonfigurasiMenuItem);
        gameMenu.add(simpanKonfigurasiMenuItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        );
        bacaKonfigurasiMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                Tempat peta = null;
                int returnVal = jf.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    boolean check = false;
                    if (!check) {
                        peta = new Tempat(jf.getSelectedFile());
                        check = true;
                    } else {
                        peta.bacaObjekKonfigurasi(jf.getSelectedFile());
                    }
                    System.out.println("\nIsi peta Baru = ");
                    System.out.println(peta.getIsi());
                    if (peta.getSel() != null) {
                        for (int i = 0; i < peta.getSel().size(); i++) {
                            System.out.println(
                                    peta.getSel().get(i).getPosisiX() + ","
                                    + peta.getSel().get(i).getPosisiY() + ",");
                        }
                    }
                }
                peta = new Tempat();
                init();
            }
        });

        simpanKonfigurasiMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnVal = fc.showSaveDialog(null);
                Tempat peta = new Tempat();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    peta.simpanObjekKonfigurasi(fc.getSelectedFile());
                }
            }
        });
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        this.perintahlabel = new JLabel("PERINTAH");
        southPanel.add(perintahlabel);

        this.perintahText = new JTextField(10);
        southPanel.add(perintahText);

        this.perintahTextHistory = new JTextField(10);
        this.add(this.perintahTextHistory, BorderLayout.EAST);

        this.okButton = new JButton("OK");
        southPanel.add(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peta.PerintahGerak(perintahText.getText());
                perintahTextHistory.setText(peta.getTeksPerintah());
            }
        });
        Container cp = this.getContentPane();
        if (peta != null) {
            cp.add(peta, BorderLayout.CENTER);
        }
        cp.add(southPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
