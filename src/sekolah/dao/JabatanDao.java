/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.util.List;
import sekolah.model.Jabatan;

/**
 *
 * @author sma
 */
public interface JabatanDao {
    public boolean insertJabatan(Jabatan j);
    public boolean editJabatan(Jabatan j);
    public boolean delete(Jabatan j);
    public List<Jabatan> getAllJabatan();
    public Jabatan getJabatan(int id);
    public boolean cekJabatan(Jabatan j);
}
