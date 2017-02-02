/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.util.Calendar;
import java.util.List;
import sekolah.model.Kelas;
import sekolah.model.MataPelajaran;
import sekolah.model.Nilai;
import sekolah.model.NilaiMaster;
import sekolah.model.Siswa;
import sekolah.model.TahunAjaran;
import sekolah.model.TipeNilai;

/**
 *
 * @author sma
 */
public interface NilaiDao {
    public boolean insert(Nilai n);
    public boolean update(Nilai n);
    public boolean delete(Nilai n);
    public Nilai get(NilaiMaster nm);
    public Nilai get(NilaiMaster nm,Siswa s);
    public Nilai get(TahunAjaran ta,MataPelajaran mp,TipeNilai tn,Kelas k,Calendar tanggal,Siswa s);
    public List<Nilai> get(TahunAjaran ta,MataPelajaran mp,TipeNilai tn,Kelas k,Calendar tanggal);
}
