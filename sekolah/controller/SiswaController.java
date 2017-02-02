/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sekolah.controller;
import java.util.List;
import org.apache.log4j.Logger;
import sekolah.dao.SiswaDaoSql;
import sekolah.model.Action;
import sekolah.model.Kelas;
import sekolah.model.Siswa;
/**
 *
 * @author sma
 */


public class SiswaController {
private static final Logger logger = Logger.getLogger(SiswaController.class);
private final SiswaDaoSql dao = new SiswaDaoSql();

public boolean manipulate(Action act,Siswa s)
{
    boolean result=false;
    switch(act)
    {
        case INSERT:
            result = dao.insert(s);
            break;
        case UPDATE:
            result = dao.edit(s);
            break;
        case DELETE:
            result = dao.delete(s);
            break;
    }
    return result;
}
public Siswa get(int nis)
{
    return dao.get(nis);
}
public List<Siswa> getAll()
{
    return dao.getAll();
}
public List<Siswa> getByKelas(Kelas k)
{
    return dao.getBy(k);
}
public List<Siswa> getByName(String nama)
{
    return dao.getByNama(nama);
}
}
