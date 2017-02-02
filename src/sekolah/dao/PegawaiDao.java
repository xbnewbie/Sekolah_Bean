/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.util.List;
import sekolah.model.Pegawai;

/**
 *
 * @author sma
 */
public interface PegawaiDao {
    public boolean insert(Pegawai p);
    public boolean edit(Pegawai p);
    public boolean delete(Pegawai p);
    public Pegawai get(int nik);
    public List<Pegawai> getAll();
    public List<Pegawai> getByNama(String nama);
    
    
}
