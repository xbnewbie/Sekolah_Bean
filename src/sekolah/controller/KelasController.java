/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.controller;

import java.util.List;
import org.apache.log4j.Logger;
import sekolah.dao.KelasDaoSql;
import sekolah.model.Action;
import sekolah.model.Kelas;

 

/**
 *
 * @author sma
 */
public class KelasController {
    private static final Logger logger = Logger.getLogger(KelasController.class);
    KelasDaoSql dao = new KelasDaoSql();
    public boolean manipulate(Action act,Kelas k)
    {
       boolean result= false;
        switch(act)
        {
            case INSERT:
                result = dao.insert(k);
                break;
            case UPDATE:
                result = dao.edit(k);
                break;
            case DELETE:
                result = dao.delete(k);
                break;
        }
        return result;
    }
    public Kelas get(int id)
    {
        return dao.get(id);
    }
    
    public Kelas get(String nama)
    {
        return dao.getByNama(nama);
    }
    public List<Kelas> getAll()
    {
        return dao.getAll();
    }
    public boolean sudahAdaKelas()
    {
        if(dao.nextId()==1)
        {
            return false;
        }
        return true;
    }
}
