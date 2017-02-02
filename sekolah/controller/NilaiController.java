/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sekolah.controller;
import java.util.Calendar;
import org.apache.log4j.Logger;
import sekolah.dao.NilaiSql;
import sekolah.model.Action;
import sekolah.model.Kelas;
import sekolah.model.MataPelajaran;
import sekolah.model.Nilai;
import sekolah.model.NilaiMaster;
import sekolah.model.Siswa;
import sekolah.model.TahunAjaran;
import sekolah.model.TipeNilai;
/**
 *
 * @author sma
 */

public class NilaiController {
private static final Logger logger = Logger.getLogger(NilaiController.class);
NilaiSql dao = new NilaiSql();
public boolean manipulate(Action act,Nilai n)
{
    boolean result=false;
    switch(act)
    {
        case INSERT:
            result = dao.insert(n);
            break;
        case UPDATE:
            result = dao.update(n);
            break;
        case DELETE:
            result = dao.delete(n);
            break;
    }
    return result;
}
public Nilai get(NilaiMaster nm)
{
    return dao.get(nm);
}
public Nilai get(NilaiMaster nm,Siswa s)
{
    return dao.get(nm, s);
}
public Nilai get(TahunAjaran ta,MataPelajaran mp,TipeNilai tn,Kelas k,Calendar tanggal,Siswa s)
{
    return dao.get(ta, mp, tn, k, tanggal, s);
}
}
