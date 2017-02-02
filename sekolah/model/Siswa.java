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
public class Siswa {
    int NIS;
    Kelas kelas;
    String nama,tempatLahir,ayah,ibu,jenisKelamin;
    Calendar tanggalLahir;
    
    public Siswa(int NIS, Kelas kelas, String nama, String tempatLahir, Calendar tanggalLahir, String ayah, String ibu,String jk) {
        this.NIS = NIS;
        this.kelas = kelas;
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.ayah = ayah;
        this.ibu = ibu;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin =jk;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public int getNis() {
        return NIS;
    }

    public void setNis(int NIS) {
        this.NIS = NIS;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getAyah() {
        return ayah;
    }

    public void setAyah(String ayah) {
        this.ayah = ayah;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public Calendar getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Calendar tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    
}
