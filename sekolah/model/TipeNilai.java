/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sekolah.model;
import org.apache.log4j.Logger;
/**
 *
 * @author sma
 */

public class TipeNilai {
private static final Logger logger = Logger.getLogger(TipeNilai.class);
int id;
String nama;
public TipeNilai(int id,String nama)
{
    this.id = id;
    this.nama =nama;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}
