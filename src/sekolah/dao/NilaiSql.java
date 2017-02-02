/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;
import sekolah.controller.NilaiMasterController;

import sekolah.database.DatabaseSql;
import sekolah.misc.CalendarUtil;
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
public class NilaiSql implements NilaiDao {

    private static final Logger logger = Logger.getLogger(NilaiSql.class);
    KelasDaoSql kelasDao = new KelasDaoSql();
    SiswaDaoSql siswaDao = new SiswaDaoSql();
    TahunAjaranSql taDao = new TahunAjaranSql();
    MataPelajaranSql mpDao = new MataPelajaranSql();
    TipeNilaiSql tnDao = new TipeNilaiSql();
    NilaiMasterController nmc = new NilaiMasterController();

    @Override
    public boolean insert(Nilai n) {
        boolean result = false;
        String sql = "insert into Nilai values(?,?,?)";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, n.getNilaiMaster().getId());
                ps.setInt(2, n.getSiswa().getNis());
                ps.setDouble(3, n.getValue());
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
    public boolean update(Nilai n) {
        boolean result = false;
        String sql = "update Nilai set NilaiMaster=?,Nis=?,Value=? where NilaiMaster=? and nis=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, n.getNilaiMaster().getId());
                ps.setInt(2, n.getSiswa().getNis());
                ps.setDouble(3, n.getValue());
                ps.setInt(4, n.getNilaiMaster().getId());
                ps.setInt(5, n.getSiswa().getNis());
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
    public boolean delete(Nilai n) {
        boolean result = false;
        String sql = "delete from nilai where nilaimaster=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, n.getNilaiMaster().getId());
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
    public Nilai get(NilaiMaster nm) {
       
        Nilai n = null;
        String sql = "select * from Nilai where nilaimaster=?";
 
        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setInt(1, nm.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int nilaiMaster = rs.getInt("NilaiMaster");
                int Nis = rs.getInt("Nis");
                double Value = rs.getDouble("Value");
                NilaiMaster NM = nmc.get(nilaiMaster);

                Siswa s = siswaDao.get(Nis);
                n = new Nilai(NM, s, Value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public Nilai get(TahunAjaran ta, MataPelajaran mp, TipeNilai tn, Kelas k, Calendar tanggal, Siswa s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Nilai> get(TahunAjaran ta, MataPelajaran mp, TipeNilai tn, Kelas k, Calendar tanggal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nilai get(NilaiMaster nm, Siswa s) {
        Nilai n = null;
        String sql = "select * from Nilai where NilaiMaster=? and nis=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setInt(1, nm.getId());
            ps.setInt(2, s.getNis());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int nilaiMaster = rs.getInt("NilaiMaster");
                int Nis = rs.getInt("Nis");
                double Value = rs.getDouble("Value");
                NilaiMaster NM = nmc.get(nilaiMaster);
                n = new Nilai(NM, s, Value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

}
