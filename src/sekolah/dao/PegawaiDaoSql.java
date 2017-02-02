/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import sekolah.database.DatabaseSql;
import sekolah.misc.CalendarUtil;
import sekolah.model.Jabatan;
import sekolah.model.Pegawai;

/**
 *
 * @author sma
 */
public class PegawaiDaoSql implements PegawaiDao {

    JabatanDaoSql jabatanSql = new JabatanDaoSql();

    @Override
    public boolean insert(Pegawai p) {
        boolean result = false;
        String sql = "insert into pegawai values(?,?,?,?)";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, p.getNIK());
                ps.setString(2, p.getNama());
                ps.setInt(3, p.getJabatan().getId());
                ps.setString(4, CalendarUtil.TanggalToString(p.getTglLahir()));
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
    public boolean edit(Pegawai p) {
        boolean result = false;
        String sql = "update pegawai set nik=?,nama=?,jabatan=?,lahir=? where nik=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, p.getNIK());
                ps.setString(2, p.getNama());
                ps.setInt(3, p.getJabatan().getId());
                ps.setString(4, CalendarUtil.TanggalToString(p.getTglLahir()));
                ps.setInt(5, p.getNIK());
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
    public boolean delete(Pegawai p) {
        boolean result = false;
        String sql = "delete from pegawai where nik=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, p.getNIK());
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
    public Pegawai get(int nik) {
        Pegawai p = null;
        String sql = "select * from pegawai where nik=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setInt(1, nik);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nama = rs.getString("nama");
                int jabatan = rs.getInt("jabatan");
                String lahir = rs.getString("lahir");
                Jabatan j = jabatanSql.getJabatan(jabatan);
                p = new Pegawai(nik, nama, CalendarUtil.StringToCalendar(lahir), j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Pegawai> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pegawai> getByNama(String nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
