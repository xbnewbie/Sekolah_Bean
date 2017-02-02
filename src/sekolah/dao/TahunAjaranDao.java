/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.util.List;
import sekolah.model.TahunAjaran;

/**
 *
 * @author sma
 */
public interface TahunAjaranDao {
   public boolean insert(TahunAjaran ta); 
   public boolean edit(TahunAjaran ta); 
   public boolean delete(TahunAjaran ta); 
   public List<TahunAjaran> getAll();
   public TahunAjaran get(int id);
   public TahunAjaran get(String nama);
   public boolean cek(TahunAjaran ta);
   
   
}
