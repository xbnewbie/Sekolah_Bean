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
import sekolah.model.TipeNilai;

/**
 *
 * @author sma
 */
public class TipeNilaiSql implements TipeNilaiDao {

    private static final Logger logger = Logger.getLogger(TipeNilaiSql.class);

    @Override
    public boolean insert(TipeNilai tn) {
        boolean result = false;
        String sql = "insert into tipe_nilai values(?,?)";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, nextId());
                ps.setString(2, tn.getNama());
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
    public boolean update(TipeNilai tn) {
        boolean result = false;
        String sql = "update tipe_nilai set id=?,nama=? where id=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, tn.getId());
                ps.setString(2, tn.getNama());
                ps.setInt(3, tn.getId());
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
    public boolean delete(TipeNilai tn) {
        boolean result = false;
        String sql = "delete from tipe_nilai where id=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, tn.getId());
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
    public TipeNilai get(int id) {
        TipeNilai t = null;
        String sql = "select * from tipe_nilai where id=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nama = rs.getString("nama");
                t = new TipeNilai(id, nama);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
@Override
    public TipeNilai get(String nama) { 
        TipeNilai t = null;
        String sql = "select * from tipe_nilai where nama=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setString(1, nama);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                int id = rs.getInt("id");
                t = new TipeNilai(id, nama);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public List<TipeNilai> getAll() {
        List<TipeNilai> t = new ArrayList<>();
        String sql = "select * from tipe_nilai";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                TipeNilai tn = new TipeNilai(id, nama);
                t.add(tn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    
    public int nextId()
    {
        int next=0;
        try
        {
          
            String query="select max(id) as t from tipe_nilai";
            Statement st = DatabaseSql.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                
               next = rs.getInt("t") +1;
               
            }else
            {
                logger.info("ga");
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return next;
    } 
}
