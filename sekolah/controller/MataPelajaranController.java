/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sekolah.controller;
import java.util.List;
import org.apache.log4j.Logger;
import sekolah.dao.MataPelajaranSql;
import sekolah.model.Action;
import sekolah.model.MataPelajaran;
/**
 *
 * @author sma
 */

public class MataPelajaranController {
private static final Logger logger = Logger.getLogger(MataPelajaranController.class);
private static final MataPelajaranSql dao = new MataPelajaranSql();
public boolean manipulate(Action act,MataPelajaran mp)
{
    boolean result=false;
    switch(act)
    {
        case INSERT:
            result = dao.insert(mp);
            break;
        case UPDATE:
            result = dao.update(mp);
            break;
        case DELETE:
            result = dao.delete(mp);
            break;
    }
    return result;
}
public MataPelajaran get(int id)
{
    return dao.get(id);
}
public MataPelajaran get(String nama)
{
    return dao.get(nama);
}
public List<MataPelajaran> getAll()
{
    return dao.getAll();
}
}
