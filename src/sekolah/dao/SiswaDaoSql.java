/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;
import sekolah.controller.KelasController;
import sekolah.database.DatabaseSql;
import sekolah.misc.CalendarUtil;
import sekolah.model.Kelas;
import sekolah.model.Siswa;

/**
 *
 * @author sma
 */
public class SiswaDaoSql implements SiswaDao{
private static final Logger logger = Logger.getLogger(SiswaDaoSql.class);
    @Override
    public boolean insert(Siswa s) {
      boolean result=false;
  String sql ="insert into siswa values(?,?,?,?,?,?,?,?)"; 
try{
try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) { 
ps.setInt(1,s.getNis()); 
ps.setString(2,s.getNama());

ps.setString(3,CalendarUtil.TanggalToString(s.getTanggalLahir()));
ps.setString(4,s.getTempatLahir());
ps.setString(5,s.getJenisKelamin());
ps.setInt(6,s.getKelas().getId());
ps.setString(7,s.getAyah());
ps.setString(8,s.getIbu());
    int row = ps.executeUpdate();
                if(row >0)
                {
                    result=true;
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean edit(Siswa s) {
     boolean result=false;
  String sql ="update siswa set nis=?,nama=?,lahir=?,tempat_lahir=?,kelamin=?,kelas=?,ayah=?,ibu=? where nis=?"; 
try{
try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
ps.setInt(1,s.getNis()); 
ps.setString(2,s.getNama());

ps.setString(3,s.getTempatLahir());
ps.setString(4,CalendarUtil.TanggalToString(s.getTanggalLahir()));
ps.setString(5,s.getJenisKelamin());
ps.setInt(6,s.getKelas().getId());
ps.setString(7,s.getAyah());
ps.setString(8,s.getIbu());
ps.setInt(9, s.getNis());
    int row = ps.executeUpdate();
                if(row >0)
                {
                    result=true;
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
      }

    @Override
    public boolean delete(Siswa s) {
     boolean result=false;
  String sql ="delete from siswa where nis=?"; 
try{
try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
ps.setInt(1,s.getNis()); 
    int row = ps.executeUpdate();
                if(row >0)
                {
                    result=true;
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
     }

    @Override
    public Siswa get(int nis) {
        Siswa s = null;
        String sql = "select * from siswa where nis=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setInt(1, nis);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nama = rs.getString("nama");
                String lahir = rs.getString("lahir");
                Calendar tglLahir = CalendarUtil.StringToCalendar(lahir);
                String tempat_lahir = rs.getString("tempat_lahir");
                String kelamin = rs.getString("kelamin");
                int kelas = rs.getInt("kelas");
                KelasController kc = new KelasController();
                Kelas k= kc.get(kelas);
                String ayah = rs.getString("ayah");
                String ibu = rs.getString("ibu");
                s= new Siswa(nis, k, nama, tempat_lahir, tglLahir, ayah, ibu, kelamin);
                
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public List<Siswa> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Siswa> getBy(Kelas k) {
        List<Siswa> listSiswa = new ArrayList<>();
      Siswa s = null;
        String sql = "select * from siswa where kelas=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setInt(1, k.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int nis = rs.getInt("nis");
                String nama = rs.getString("nama");
                String lahir = rs.getString("lahir");
                Calendar tglLahir = CalendarUtil.StringToCalendar(lahir);
                String tempat_lahir = rs.getString("tempat_lahir");
                String kelamin = rs.getString("kelamin");
                int kelas = rs.getInt("kelas");
                KelasController kc = new KelasController();
            
                String ayah = rs.getString("ayah");
                String ibu = rs.getString("ibu");
                Siswa siswa = new Siswa(nis, k, nama, tempat_lahir, tglLahir, ayah, ibu, kelamin);
                listSiswa.add(siswa);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSiswa;
    
    }

    @Override
    public List<Siswa> getByNama(String nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
