/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.model;

/**
 *
 * @author sma
 */
public class TahunAjaran {
    int id;
    String tahunAjaran;
    public TahunAjaran(int id,String tahunAjaran)
    {
        this.id = id;
        this.tahunAjaran= tahunAjaran;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
    }
    
}
