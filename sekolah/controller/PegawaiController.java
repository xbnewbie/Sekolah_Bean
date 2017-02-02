/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.controller;

import org.apache.log4j.Logger;
import sekolah.dao.PegawaiDaoSql;
import sekolah.model.Action;
import sekolah.model.Pegawai;

/**
 *
 * @author sma
 */
public class PegawaiController {
    private static final Logger logger = Logger.getLogger(PegawaiController.class);
    private PegawaiDaoSql dao = new PegawaiDaoSql();
    
    public boolean manipulate(Action act, Pegawai p)
    {
        boolean result=false;
        switch(act)
        {
            case INSERT:
                result = dao.insert(p);
                break;
            case UPDATE:
                result = dao.edit(p);
                break;
            case DELETE:
                result = dao.delete(p);
                break;
        }
        return result;
    }
    public Pegawai get(int nik)
    {
        return dao.get(nik);
    }
    
}
