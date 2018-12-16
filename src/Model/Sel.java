/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;

/**
 *
 * @author Aweng
 */
public class Sel {

    private int lebar;
    private int tinggi;
    private int posisiX;
    private int posisiY;
    private char nilai;
    private Image image;

    private int Jarak = 30;
    // membuat ukuran  gambar, spt contoh diatas jarak = 30, berarti gambarnya 30 x 30
    public Sel(int x, int y) {
        this.posisiX = x;
        this.posisiY = y;
    }
    
    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public void setPosisiX(int posisiX) {
        this.posisiX = posisiX;
    }

    public void setPosisiY(int posisiY) {
        this.posisiY = posisiY;
    }

    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setJarak(int Jarak) {
        this.Jarak = Jarak;
    }
    
    
    public int getLebar() {
        return lebar;
    }

    public int getTinggi() {
        return tinggi;
    }

    public int getPosisiX() {
        return posisiX;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public char getNilai() {
        return nilai;
    }

    public Image getImage() {
        return image;
    }

    public int getJarak() {
        return Jarak;
    }
    
    public boolean PosisiKiriObjek(Sel Objek) {
        if (((this.getLebar() - Jarak) == Objek.getLebar()) && (this.getTinggi() == Objek.getTinggi())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiKananObjek(Sel Objek) {
        if (((this.getLebar() + Jarak) == Objek.getLebar()) && (this.getTinggi() == Objek.getTinggi())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiAtasObjek(Sel Objek) {
        if (((this.getTinggi() - Jarak) == Objek.getTinggi()) && (this.getLebar() == Objek.getLebar())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiBawahObjek(Sel Objek) {
        if (((this.getTinggi() + Jarak) == Objek.getTinggi()) && (this.getLebar() == Objek.getLebar())) {
            return true;
        } else {
            return false;
        }
    }

    
}
