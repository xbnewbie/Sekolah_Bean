/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import sekolah.controller.JabatanController;
import sekolah.controller.KelasController;
import sekolah.controller.MataPelajaranController;
import sekolah.controller.NilaiController;
import sekolah.controller.PegawaiController;
import sekolah.controller.SiswaController;
import sekolah.controller.TipeNilaiController;
import sekolah.dao.JabatanDaoSql;
import sekolah.dao.TahunAjaranSql;
import sekolah.database.DatabaseSql;
import sekolah.misc.CalendarUtil;
import sekolah.model.Action;
import sekolah.model.Jabatan;
import sekolah.model.Kelas;
import sekolah.model.MataPelajaran;
import sekolah.model.Nilai;
import sekolah.model.Pegawai;
import sekolah.model.Siswa;
import sekolah.model.TahunAjaran;
import sekolah.model.TipeNilai;
 
 
 
 
 
/**
 *
 * @author sma
 */
public class Sekolah {

   // private static final String URL = "jdbc:odbc:TestDB";

 final static Logger logger = Logger.getLogger(Sekolah.class);
 
   
  public static void main(String[] args) throws Exception {
    PropertyConfigurator.configure("E:/LOGGER/config.properties");
 
 
    
    TahunAjaran ta = new TahunAjaran(1,"2016/2017");
    TahunAjaranSql dao = new TahunAjaranSql();
    JabatanController jc = new JabatanController();
    PegawaiController pc = new PegawaiController();
    KelasController kc = new KelasController();
    SiswaController sc = new SiswaController();
    MataPelajaranController mpc = new MataPelajaranController();
    TipeNilaiController tnc = new TipeNilaiController();
    NilaiController nc = new NilaiController();
    Calendar c = CalendarUtil.StringToCalendar("1995-09-28");
    Jabatan j = jc.get(1);
    Pegawai p = new Pegawai(200, "Anjas wari 2", c, j);
    Kelas k = new Kelas(1,"1A",p);
    
     
     for(int i=27;i<=70;i++)
     {
         Siswa s = new Siswa(i, k, "Siswa ke "+Integer.toString(i), "Suka Maja",c, "Ayah A", "Ibu A", "l"); 
    sc.manipulate(Action.DELETE, s);
     }
   // pc.manipulate(Action.DELETE, p);
    
    //pengecekan pegawai dan jabatan
    
    //Class.forName(DRIVER);
  //  Connection connection = getConnection();

  //  connection.close();
  }
  
}
