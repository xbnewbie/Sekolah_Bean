/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.util.List;
import sekolah.model.Kelas;

/**
 *
 * @author sma
 */
public interface KelasDao {
    public boolean insert(Kelas k);
    public boolean edit(Kelas k);
    public boolean delete(Kelas k);
    public boolean sudahAdaKelas();
    public Kelas get(int k);
    public List<Kelas> getAll();
   // public List<Kelas> getByNama(String nama);
    public Kelas getByNama(String nama); 
}
