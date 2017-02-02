/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sma
 */
public class Pegawai {
    int NIK;
    Calendar tglLahir;
    String nama,tempatTinggal;
    Jabatan jabatan;

    public Pegawai(int NIK,  String nama,Calendar tglLahir,  Jabatan jabatan) {
        this.NIK = NIK;
        this.tglLahir = tglLahir;
        this.nama = nama;
       
        this.jabatan = jabatan;
    }

    public int getNIK() {
        return NIK;
    }

    public void setNIK(int NIK) {
        this.NIK = NIK;
    }

    public Calendar getTglLahir() {
        return tglLahir;
    }

    public void Calendar(Calendar tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatTinggal() {
        return tempatTinggal;
    }

    public void setTempatTinggal(String tempatTinggal) {
        this.tempatTinggal = tempatTinggal;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }
    
}
