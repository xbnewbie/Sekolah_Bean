/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.dao;

import sekolah.database.DatabaseSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import sekolah.model.Jabatan;
 

/**
 *
 * @author sma
 */
public class JabatanDaoSql implements JabatanDao {
private static final Logger logger = Logger.getLogger(JabatanDaoSql.class);
    @Override
    public boolean insertJabatan(Jabatan j) {
        if(this.cekJabatan(j))
        {
            logger.info("Error fail");
            return false;
        }
        boolean result=false;
        String sql ="insert into jabatan values(?,?)";
    try{
      PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql);
      ps.setInt(1, nextId());
      ps.setString(2, j.getNama());
      if(ps.executeUpdate()!=0)
      {
          result=true;
      }
       
      
    }catch(Exception e)
    {
        e.printStackTrace();
       logger.info("[Error ]" + e.getMessage());
    }
    return result;
    }

    @Override
    public boolean editJabatan(Jabatan j) {
       boolean result=false;
  String sql ="update jabatan set id_jabatan=?,nama_jabatan=? where id_jabatan=?"; 
try{
try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
ps.setInt(1,j.getId()); 
ps.setString(2,j.getNama()); 
ps.setInt(3, j.getId());
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
    public boolean delete(Jabatan j) {
      boolean result=false;
  String sql ="delete from jabatan where id_jabatan=?"; 
try{
try (PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql)) {
ps.setInt(1,j.getId()); 
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
    public List<Jabatan> getAllJabatan() {
    List<Jabatan> listJabatan = new ArrayList<Jabatan>();
    try{
         String sql="select * from jabatan";
        PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
       while(rs.next())
        {
        Jabatan j = new Jabatan(rs.getInt("id_jabatan"),rs.getString("nama_jabatan"));
        listJabatan.add(j);
        }
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    return listJabatan;
    }

    @Override
    public Jabatan getJabatan(int id) {
    Jabatan j=null;
    try{
        String sql="select * from jabatan where id_jabatan=?";
        PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
         j = new Jabatan(id,rs.getString("nama_jabatan"));
        }
        
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    return j;
    }
     public int nextId()
    {
        int next=0;
        try
        {
          
            String query="select max(id_jabatan) as t from jabatan";
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
    public boolean cekJabatan(Jabatan j) {
        boolean result=false;
    try{
        String sql="select * from Jabatan where nama_jabatan=?";
        PreparedStatement ps = DatabaseSql.getConnection().prepareStatement(sql);
        ps.setString(1, j.getNama());
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            logger.info("ada");
            result=true;
        }
    }catch(Exception e)
    {
        System.out.println("[Error ]" + e.getMessage());
    }
    return result;
    }
}
