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
import sekolah.model.TahunAjaran;

/**
 *
 * @author sma
 */
public class TahunAjaranSql implements TahunAjaranDao { 
private static final Logger logger = Logger.getLogger(TahunAjaranSql.class);

    @Override
    public boolean insert(TahunAjaran ta) {
   
        boolean result = false;
        if(this.cek(ta))
        {
            logger.info("Mask");
            return false;
        }
        String sql = "insert into Tahun_Ajaran values(?,?)";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, nextId());
                ps.setString(2, ta.getTahunAjaran());
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
    public boolean edit(TahunAjaran ta) {
        boolean result = false;
        String sql = "update Tahun_Ajaran set Id=?,TahunAjaran=? where id=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, ta.getId());
                ps.setString(2, ta.getTahunAjaran());
                ps.setInt(3, ta.getId());
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
    public boolean delete(TahunAjaran ta) {
        boolean result = false;
        String sql = "delete from Tahun_Ajaran where id=?";
        try {
            try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
                ps.setInt(1, ta.getId());
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
    public List<TahunAjaran> getAll() {
        List<TahunAjaran> ta = new ArrayList<>();
     String sql = "select * from Tahun_Ajaran";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("Id");
                String TahunAjaran = rs.getString("TahunAjaran");
                TahunAjaran t = new TahunAjaran(Id,TahunAjaran);
                ta.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return ta;
    }

    @Override
    public TahunAjaran get(int id) {
        TahunAjaran t = null;
        String sql = "select * from Tahun_Ajaran where id=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int Id = rs.getInt("Id");
                String TahunAjaran = rs.getString("TahunAjaran");
                t = new TahunAjaran(Id,TahunAjaran);
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
          
            String query="select max(id) as t from Tahun_Ajaran";
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

    @Override
    public boolean cek(TahunAjaran ta) {
   boolean result=false;
    try{
        String sql="select * from Tahun_Ajaran where TahunAjaran=?";
        PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql);
        ps.setString(1, ta.getTahunAjaran());
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
           
            result=true;
        }
    }catch(Exception e)
    {
        System.out.println("[Error ]" + e.getMessage());
    }
    return result;  
    }

    @Override
    public TahunAjaran get(String nama) {
      TahunAjaran t = null;
        String sql = "select * from Tahun_Ajaran where TahunAjaran=?";

        try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
            ps.setString(1, nama);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int Id = rs.getInt("Id");
                String TahunAjaran = rs.getString("TahunAjaran");
                t = new TahunAjaran(Id,TahunAjaran);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t; }

}
