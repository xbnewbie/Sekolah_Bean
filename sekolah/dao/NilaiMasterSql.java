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
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;
import sekolah.controller.KelasController;
import sekolah.controller.MataPelajaranController;
import sekolah.controller.TahunAjaranController;
import sekolah.controller.TipeNilaiController;
import sekolah.dao.NilaiMasterDao;
import sekolah.database.DatabaseSql;
import sekolah.misc.CalendarUtil;
import sekolah.model.Kelas;
import sekolah.model.MataPelajaran;
import sekolah.model.NilaiMaster;
import sekolah.model.Siswa;
import sekolah.model.TahunAjaran;
import sekolah.model.TipeNilai;

/**
 *
 * @author sma
 */
public class NilaiMasterSql implements NilaiMasterDao {
KelasController kc = new KelasController();
MataPelajaranController mpc = new MataPelajaranController();
TahunAjaranController tac = new TahunAjaranController();
TipeNilaiController tnc = new TipeNilaiController();
    private static final Logger logger = Logger.getLogger(NilaiMasterSql.class);

    @Override
    public boolean insert(NilaiMaster nm) {
        boolean result = false;
        String sql = "insert into nilaimaster values(?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, nm.getId());
                ps.setInt(2, nm.getTa().getId());
                ps.setInt(3, nm.getMp().getId());
                  ps.setInt(4, nm.getTn().getId());
                ps.setInt(5, nm.getK().getId());
              
                ps.setString(6, CalendarUtil.TanggalToString(nm.getTanggal()));
                ps.setString(7, nm.getKeterangan());
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
    public boolean update(NilaiMaster nm) {
        boolean result = false;
        String sql = "update nilaimaster set id=?,TahunAjaran=?,MataPelajaran=?,TipeNilai=?,Kelas=?,Tanggal=?,keterangan=? where id=?";
        try {
            
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                  ps.setInt(1, nm.getId());
                ps.setInt(2, nm.getTa().getId());
                ps.setInt(3, nm.getMp().getId());
                
                ps.setInt(4, nm.getTn().getId());
                ps.setInt(5, nm.getK().getId());
                ps.setString(6, CalendarUtil.TanggalToString(nm.getTanggal()));
                ps.setString(7, nm.getKeterangan());
                ps.setInt(8, nm.getId());
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
    public boolean delete(NilaiMaster nm) {
        boolean result = false;
        String sql = "delete from nilaiMaster where id=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, nm.getId());
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
    public NilaiMaster get(int id) {
        NilaiMaster n = null;
        String sql = "select * from nilaimaster where id=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
           
                int tahunAjaran= rs.getInt("TahunAjaran");
                int mataPelajaran = rs.getInt("MataPelajaran");
                int kelas = rs.getInt("Kelas");
                int tipeNilai = rs.getInt("TipeNilai");
                String tgl = rs.getString("Tanggal");
                Calendar tanggal = CalendarUtil.StringToCalendar(tgl);
                String keterangan = rs.getString("keterangan");
                Kelas k = kc.get(kelas); 
                TipeNilai tn = tnc.get(tipeNilai);
                TahunAjaran ta = tac.get(tahunAjaran);
                MataPelajaran mp = mpc.get(mataPelajaran);
                n = new NilaiMaster(id, ta, mp,tn, k, tanggal, keterangan);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<NilaiMaster> getAll() {
        NilaiMaster n = null;
        List<NilaiMaster> nm = new ArrayList<>();
        String sql = "select * from NilaiMaster";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                    int tahunAjaran= rs.getInt("TahunAjaran");
                int mataPelajaran = rs.getInt("MataPelajaran");
                int kelas = rs.getInt("Kelas");
                int tipeNilai = rs.getInt("TipeNilai");
                String tgl = rs.getString("Tanggal");
                Calendar tanggal = CalendarUtil.StringToCalendar(tgl);
                String keterangan = rs.getString("keterangan");
                Kelas k = kc.get(kelas); 
                TipeNilai tn = tnc.get(tipeNilai);
                TahunAjaran ta = tac.get(tahunAjaran);
                MataPelajaran mp = mpc.get(mataPelajaran);
                n = new NilaiMaster(id, ta, mp,tn, k, tanggal, keterangan);
                nm.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nm;
    }

    public int nextId() {
        int next = 0;
        try {

            String query = "select max(id) as t from NilaiMaster";
            Statement st = DatabaseSql.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {

                next = rs.getInt("t") + 1;

            } else {
                logger.info("ga");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return next;
    }

    @Override 
    public List<NilaiMaster> get( Siswa s) {
    NilaiMaster n = null;
    List<NilaiMaster> nList = new ArrayList<>();
        String sql = "select * from nilaimaster where nis=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
           
            ps.setInt(1, s.getNis());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
           
                int id = rs.getInt("id");
                int tahunAjaran= rs.getInt("TahunAjaran");
                int mataPelajaran = rs.getInt("MataPelajaran");
                int kelas = rs.getInt("Kelas");
                int tipeNilai = rs.getInt("TipeNilai");
                String tgl = rs.getString("Tanggal");
                Calendar tanggal = CalendarUtil.StringToCalendar(tgl);
                String keterangan = rs.getString("keterangan");
                Kelas k = kc.get(kelas); 
                TipeNilai tn = tnc.get(tipeNilai);
                TahunAjaran ta = tac.get(tahunAjaran);
                MataPelajaran mp = mpc.get(mataPelajaran);
                n = new NilaiMaster(id, ta, mp,tn, k, tanggal, keterangan);
                nList.add(n);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nList; 
    }

    @Override
    public NilaiMaster get(TahunAjaran ta, MataPelajaran mp, TipeNilai tn, Kelas k) {
    NilaiMaster n = null;
    if(ta==null || mp==null || tn==null || k==null){
        System.out.println("cannot null");
    }
        String sql = "select * from nilaimaster where TahunAjaran=? and MataPelajaran=? and TipeNilai=? and Kelas=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setInt(1, ta.getId());
            ps.setInt(2, mp.getId());
            ps.setInt(3, tn.getId());
            ps.setInt(4,k.getId());
          
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
              String tgl = rs.getString("Tanggal");
                Calendar tanggal = CalendarUtil.StringToCalendar(tgl);
                String keterangan = rs.getString("keterangan");
               
                n = new NilaiMaster(id, ta, mp,tn, k, tanggal, keterangan);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;}
 
}
