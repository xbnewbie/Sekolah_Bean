/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.controller;

 
import java.util.List;
import org.apache.log4j.Logger;
import sekolah.dao.TahunAjaranSql;
import sekolah.model.Action;
import sekolah.model.TahunAjaran;

/**
 *
 * @author sma
 */
public class TahunAjaranController {
    private static final Logger logger = Logger.getLogger(TahunAjaranController.class);
    TahunAjaranSql dao = new TahunAjaranSql();
    
    public boolean manipulate(Action act,TahunAjaran ta)
    {
        boolean result= false;
        switch(act)
        {
            case INSERT:
                result = dao.insert(ta);
                break;
            case UPDATE:
                result = dao.edit(ta);
                break;
            case DELETE:
                result = dao.delete(ta);
                break;
        }
        return result;
    }
    public TahunAjaran get(int id)
    {
        return dao.get(id);
    }
    
    public TahunAjaran get(String nama)
    {
        return dao.get(nama);
    }
    public List<TahunAjaran> getAll()
    {
        return dao.getAll();
    }
}
