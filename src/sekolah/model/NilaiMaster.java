/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sekolah.model;
 
import java.util.Calendar;

/**
 *
 * @author sma
 */

public class NilaiMaster {
 int id;
TahunAjaran ta;
MataPelajaran mp;
Kelas k;
Calendar tanggal;
 String keterangan;
TipeNilai tn;
    public NilaiMaster(int id, TahunAjaran ta, MataPelajaran mp, TipeNilai tn,Kelas k, Calendar tanggal, String keterangan) {
        this.id = id;
        this.ta = ta;
        this.mp = mp;
        this.k = k;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.tn = tn;
    }

    public TipeNilai getTn() {
        return tn;
    }

    public void setTn(TipeNilai tn) {
        this.tn = tn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TahunAjaran getTa() {
        return ta;
    }

    public void setTa(TahunAjaran ta) {
        this.ta = ta;
    }

    public MataPelajaran getMp() {
        return mp;
    }

    public void setMp(MataPelajaran mp) {
        this.mp = mp;
    }

    public Kelas getK() {
        return k;
    }

    public void setK(Kelas k) {
        this.k = k;
    }

    public Calendar getTanggal() {
        return tanggal;
    }

    public void setTanggal(Calendar tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
  
 
}
