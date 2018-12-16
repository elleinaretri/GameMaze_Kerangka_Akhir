package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;


public class Finish extends Sel {

    private int lebar;
    private int tinggi;
    private char nilai;

    public Finish(int x, int y, int lebar, int tinggi, char nilai) {
        super(x, y);
        URL loc = this.getClass().getResource("/Image/finish.jpg");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
       
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.setImage(image);
        this.setNilai(nilai);
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
