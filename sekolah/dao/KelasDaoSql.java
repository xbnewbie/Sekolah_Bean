/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sekolah.database.DatabaseSql;
import sekolah.model.Kelas;
import sekolah.model.Pegawai;

/**
 *
 * @author sma
 */
public class KelasDaoSql implements KelasDao {

    PegawaiDaoSql pegawaiSql = new PegawaiDaoSql();

    @Override
    public boolean insert(Kelas k) {
        boolean result = false;
        String sql = "insert into kelas values(?,?,?)";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, nextId());
                ps.setString(2, k.getNama());
             
                ps.setInt(3, k.getWaliKelas().getNIK());
                int row = ps.executeUpdate();
                if (row > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean edit(Kelas k) {
        boolean result = false;
        String sql = "update kelas set id=?,nama=?,wali_kelas=? where id=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, k.getId());
                ps.setString(2, k.getNama());
                ps.setInt(3, k.getWaliKelas().getNIK());
                ps.setInt(4, k.getId());
                int row = ps.executeUpdate();
                if (row > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Kelas k) {
        boolean result = false;
        String sql = "delete from kelas where id=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, k.getId());
                int row = ps.executeUpdate();
                if (row > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Kelas get(int id) {
        Kelas k = null;
        String sql = "select * from kelas where id=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nama = rs.getString("nama");
                int wali_kelas = rs.getInt("wali_kelas");
                Pegawai p = pegawaiSql.get(wali_kelas);
                k = new Kelas(id, nama, p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }

    @Override
    public List<Kelas> getAll() {
    List<Kelas> k =new ArrayList<>();
        String sql = "select * from kelas";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
         
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                int wali_kelas = rs.getInt("wali_kelas");
                Pegawai p = pegawaiSql.get(wali_kelas);
                Kelas ktemp = new Kelas(id, nama, p);
                k.add(ktemp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }

    @Override
    public Kelas getByNama(String nama) {
    Kelas k = null;
        String sql = "select * from kelas where nama=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setString(1, nama);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               int id = rs.getInt("id");
                int wali_kelas = rs.getInt("wali_kelas");
                Pegawai p = pegawaiSql.get(wali_kelas);
                k = new Kelas(id, nama, p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
     }

    public int nextId() {
        int next = 0;
        try {

            String query = "select max(id) as t from kelas";
            Statement st = DatabaseSql.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {

                next = rs.getInt("t") + 1;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return next;
    }

    @Override
    public boolean sudahAdaKelas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
