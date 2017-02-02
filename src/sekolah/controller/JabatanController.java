/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.controller;

import org.apache.log4j.Logger;
import sekolah.dao.JabatanDaoSql;
import sekolah.model.Action;
import sekolah.model.Jabatan;

/**
 *
 * @author sma
 */
public class JabatanController {
    private static final Logger logger = Logger.getLogger(JabatanController.class);
    private JabatanDaoSql dao = new JabatanDaoSql();
    public boolean manipulate(Action act, Jabatan j)
    {
        boolean result=false;
        switch(act)
        {
            case INSERT:    
                result = dao.insertJabatan(j);
                break;
            case UPDATE:
                result = dao.editJabatan(j);
                break;
            case DELETE:
                result = dao.delete(j);
                break;
        }
        
        return result;
    }
    
    public Jabatan get(int id)
    {
        return dao.getJabatan(id);
    }
}
