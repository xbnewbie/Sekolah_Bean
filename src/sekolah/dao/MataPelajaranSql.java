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
import org.apache.log4j.Logger;
import sekolah.database.DatabaseSql;
import sekolah.model.MataPelajaran;

/**
 *
 * @author sma
 */

public class MataPelajaranSql implements MataPelajaranDao {

    private static final Logger logger = Logger.getLogger(MataPelajaranSql.class);

    @Override
    public boolean insert(MataPelajaran mp) {
        boolean result = false;
        String sql = "insert into mata_pelajaran values(?,?)";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, nextId());
                ps.setString(2, mp.getNama());
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
    public boolean update(MataPelajaran mp) {
        boolean result = false;
        String sql = "update mata_pelajaran set id=?,nama=? where id=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, mp.getId());
                ps.setString(2, mp.getNama());
                ps.setInt(3, mp.getId());
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
    public boolean delete(MataPelajaran mp) {
        boolean result = false;
        String sql = "delete from mata_pelajaran where id=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, mp.getId());
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
    public MataPelajaran get(int id) {
        MataPelajaran m = null;
        String sql = "select * from mata_pelajaran where id=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nama = rs.getString("nama");
                m = new MataPelajaran(id, nama);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public List<MataPelajaran> getAll() {
     MataPelajaran m = null;
     List<MataPelajaran> mapelList = new ArrayList<>();
        String sql = "select * from mata_pelajaran ";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                m = new MataPelajaran(id, nama);
                mapelList.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapelList;
    }

    public int nextId() {
        int next = 0;
        try {

            String query = "select max(id) as t from mata_pelajaran";
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
    public MataPelajaran get(String nama) {
        MataPelajaran m = null;
        String sql = "select * from mata_pelajaran where nama=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setString(1, nama);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                int id = rs.getInt("id");
                m = new MataPelajaran(id, nama);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m; }
}
