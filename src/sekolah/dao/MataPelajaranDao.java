/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sekolah.dao;
 
import java.util.List;
import sekolah.model.MataPelajaran;

/**
 *
 * @author sma
 */

public interface MataPelajaranDao {
 public boolean insert(MataPelajaran mp);
 public boolean update(MataPelajaran mp);
 public boolean delete(MataPelajaran mp);
 public MataPelajaran get(int id);
 public MataPelajaran get(String nama);
 public List<MataPelajaran> getAll();
}
