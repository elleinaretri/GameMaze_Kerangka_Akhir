/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Aweng
 */
public class Tembok extends Sel {

    private int lebar;
    private int tinggi;
    private char nilai;

    public Tembok(int x, int y, int lebar, int tinggi, char nilai) {
        super(x, y); 
        URL loc = this.getClass().getResource("/Image/GRASS.png");
        ImageIcon wall = new ImageIcon(loc);
        Image image = wall.getImage();
        this.setImage(image);
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.nilai = nilai;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

    public int getLebar() {
        return lebar;
    }

    public int getTinggi() {
        return tinggi;
    }

    public char getNilai() {
        return nilai;
    }
}
