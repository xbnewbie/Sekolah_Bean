/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.util.List;
import sekolah.model.Kelas;
import sekolah.model.MataPelajaran;
import sekolah.model.NilaiMaster;
import sekolah.model.Siswa;
import sekolah.model.TahunAjaran;
import sekolah.model.TipeNilai;

/**
 *
 * @author sma
 */
public interface NilaiMasterDao {
    public boolean insert(NilaiMaster nm);
    public boolean update(NilaiMaster nm);
    public boolean delete(NilaiMaster nm);
    public NilaiMaster get(int id);
    public NilaiMaster get(TahunAjaran ta,MataPelajaran mp,TipeNilai tn,Kelas k);
    public List<NilaiMaster> get(Siswa s);
    public List<NilaiMaster> getAll();
}
