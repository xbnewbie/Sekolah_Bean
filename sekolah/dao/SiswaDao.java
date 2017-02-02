/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.util.List;
import sekolah.model.Kelas;
import sekolah.model.Siswa;

/**
 *
 * @author sma
 */
public interface SiswaDao {
    public boolean insert(Siswa s);
    public boolean edit(Siswa s);
    public boolean delete(Siswa s);
    public Siswa get(int nis);
    public List<Siswa> getAll();
    public List<Siswa> getBy(Kelas k);
    public List<Siswa> getByNama(String nama);
}
