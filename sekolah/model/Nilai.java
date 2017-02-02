/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sekolah.model;
import java.util.Calendar;
import org.apache.log4j.Logger;
/**
 *
 * @author sma
 */

public class Nilai {
private static final Logger logger = Logger.getLogger(Nilai.class);
 
NilaiMaster nilaiMaster;
Siswa siswa;
double value;

    public Nilai(NilaiMaster nilaiMaster, Siswa siswa, double value) {
        this.nilaiMaster = nilaiMaster;
        this.siswa = siswa;
        this.value = value;
    }

    public NilaiMaster getNilaiMaster() {
        return nilaiMaster;
    }

    public void setNilaiMaster(NilaiMaster nilaiMaster) {
        this.nilaiMaster = nilaiMaster;
    }

    public Siswa getSiswa() {
        return siswa;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

 
}