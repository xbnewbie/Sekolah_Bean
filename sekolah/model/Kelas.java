/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.model;

/**
 *
 * @author sma
 */
public class Kelas {
    int id;
    Pegawai waliKelas;
    String nama;
    public Kelas(int id,String nama,Pegawai waliKelas)
    {
        this.id =id;
        this.waliKelas=  waliKelas;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pegawai getWaliKelas() {
        return waliKelas;
    }

    public void setWaliKelas(Pegawai waliKelas) {
        this.waliKelas = waliKelas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
}
