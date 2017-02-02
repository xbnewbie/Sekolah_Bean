/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.misc;

import java.util.Calendar;

/**
 *
 * @author sma
 */
public class CalendarUtil {
     static  String[] bulan_string={ "januari","februari","maret","april","mei","juni","juli","agustus","september","oktober","november","desember"};
     
    public static String TanggalToString(Calendar c)
    {
        //format tahun-bulan-tanggal
        int tahun = c.get(Calendar.YEAR);
        int bulan = c.get(Calendar.MONTH);
        int tanggal=c.get(Calendar.DATE);
        String r = Integer.toString(tahun) +"-"+Integer.toString(bulan)+"-"+Integer.toString(tanggal);
        return r;
    }
    public static Calendar StringToCalendar(String text)
    {
        Calendar c = Calendar.getInstance();
        String[] data = text.split("-");
        int tahun = Integer.parseInt(data[0]);
        int bulan = Integer.parseInt(data[1]);
        int tanggal = Integer.parseInt(data[2]);
        c.set(Calendar.YEAR, tahun);
        c.set(Calendar.MONTH, bulan);
        c.set(Calendar.DATE, tanggal);
        return c;
    }
    public static String CalendarToHuman(Calendar c)
    {
         int tahun = c.get(Calendar.YEAR);
        int bulan = c.get(Calendar.MONTH);
        int tanggal=c.get(Calendar.DATE);
        String r = Integer.toString(tahun) +"-"+bulan_string[bulan]+"-"+Integer.toString(tanggal);
        return r;
    }
    public static int selisihHari(Calendar kalendarA,Calendar kalendarB)
    {
        String[] bulan_string={ "januari","februari","maret","april","mei","juni","juli","agustus","september","oktober","november","desember"};
       
        int[] bulan={31,28,31,30,31,30,31,31,30,31,30,31};
         
        int tahunA = kalendarA.get(Calendar.YEAR);
        int bulanA = kalendarA.get(Calendar.MONTH);
        int tanggalA=kalendarA.get(Calendar.DATE);
        int tahunB = kalendarB.get(Calendar.YEAR);
        int bulanB = kalendarB.get(Calendar.MONTH);
        int tanggalB=kalendarB.get(Calendar.DATE);
         
        //cek apakah ditahun yang sama
         int jumlah_hari=0;
         
         //apakah di tahun yang sama ?
         if(tahunA== tahunB)
         {
             if( (tahunA  %4 ==0) || (tahunB %4==0))
             {
                 bulan[1]=29;
             }else
             {
                 bulan[1]=28;
             }
             //apakah tahun kabisat ?
             
              //apakah di bulan yang sama ?
             if(bulanA == bulanB)
             {
                 jumlah_hari += tanggalB - tanggalA;
             }else //beda bulan
             {
                 for(int i=bulanA;i<=bulanB;i++)
                 {
                      if(i==bulanA) //hitung di bulan awal
                      {
                          jumlah_hari+=bulan[i]-tanggalA;
                      } else if((i !=bulanA) && (i !=bulanB))
                      {
                          jumlah_hari+=bulan[i];
                      } else if(i==bulanB)
                      {
                          jumlah_hari+=tanggalB;
                      }
                 }
             }
         }else if(tahunA !=tahunB)
         {
             for (int i = tahunA; i <= tahunB; i++) {
                 //apakah tahun kabisat ?
                 if(i%4==0)
                 {
                     bulan[1]=29;
                 }else
                 {
                     bulan[1]=28;
                 }
                 if (i == tahunA) {
                     //hitung jumlah hari di tahun Awal
                     for (int x = bulanA; x < 12; x++) {
                         //hitung dibulan awal
                         if (x == bulanA) {
                             jumlah_hari += bulan[x] - tanggalA;
                         }else
                         {
                             jumlah_hari +=bulan[x];
                             
                         }
                     }
                 } else if(i !=tahunA && i !=tahunB)
                 {
                     //untuk kabisat nanti
                     jumlah_hari +=365;
                 }
                 else if(i==tahunB)
                 {
                     for (int s=0;s<=bulanB;s++)
                     {
                         if(s !=bulanB)
                         {
                             jumlah_hari+=bulan[s];
                         }else if(s==bulanB)
                         {
                             jumlah_hari +=tanggalB;
                         }
                     }
                 }
             }
         }
         
         
         return jumlah_hari;
    }
    /**
     * 
     * @param i index,mulai dari 0 = januari
     * @return nama bulan
     */
    public static String getBulanString(int i)
    {
       return bulan_string[i];
    }
}
