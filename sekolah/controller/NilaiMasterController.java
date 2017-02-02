/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sekolah.controller;
import java.util.List;
import org.apache.log4j.Logger;
import sekolah.dao.NilaiMasterSql;
import sekolah.model.Action;
import sekolah.model.Kelas;
import sekolah.model.MataPelajaran;
import sekolah.model.NilaiMaster;
import sekolah.model.TahunAjaran;
import sekolah.model.TipeNilai;
/**
 *
 * @author sma
 */

public class NilaiMasterController {
private static final Logger logger = Logger.getLogger(NilaiMasterController.class);
NilaiMasterSql dao = new NilaiMasterSql();

public boolean manipulate(Action act,NilaiMaster nm)
{
    boolean result=false;
    switch(act)
    {
        case INSERT:
            result = dao.insert(nm);
            break;
        case UPDATE:
            result = dao.update(nm);
            break;
        case DELETE:
            result = dao.delete(nm);
            break;
    }
    return result;
}

public NilaiMaster get(int id)
{
    return dao.get(id);
}


public NilaiMaster get(TahunAjaran ta,MataPelajaran mp,TipeNilai tn,Kelas k)
{
    return dao.get(ta, mp, tn, k);
}

public List<NilaiMaster> getAll()
{
    return dao.getAll();
}

public int nextId()
{
    return dao.nextId();
}
}
