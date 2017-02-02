/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sekolah.controller;
import java.util.List;
import org.apache.log4j.Logger;
import sekolah.dao.TipeNilaiSql;
import sekolah.model.Action;
import sekolah.model.TipeNilai;
/**
 *
 * @author sma
 */

public class TipeNilaiController {
private static final Logger logger = Logger.getLogger(TipeNilaiController.class);
private static final TipeNilaiSql dao = new TipeNilaiSql();

public boolean manipulate(Action act,TipeNilai tn)
{
    boolean result=false;
    switch(act)
    {
        case INSERT:
            result = dao.insert(tn);
            break;
        case UPDATE:
            result = dao.update(tn);
            break;
        case DELETE:
            result = dao.delete(tn);
            break;
    }
    return result;
}

public TipeNilai get(String nama)
{
    return dao.get(nama);
}
public TipeNilai get(int id)
{
    return dao.get(id);
}
public List<TipeNilai> getAll()
{
    return dao.getAll();
}

     
}
