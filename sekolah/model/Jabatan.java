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
public class Jabatan {
    int id;
    String nama;
    public Jabatan(int id,String nama)
    {
        this.id = id;
        this.nama = nama;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
