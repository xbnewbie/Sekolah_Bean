/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.util.List;
import sekolah.model.TipeNilai;

/**
 *
 * @author sma
 */
public interface TipeNilaiDao {
    public boolean insert(TipeNilai tn);
    public boolean update(TipeNilai tn);
    public boolean delete(TipeNilai tn);
    public TipeNilai get(int id);
    public TipeNilai get(String nama);
    public List<TipeNilai> getAll();
    
}
