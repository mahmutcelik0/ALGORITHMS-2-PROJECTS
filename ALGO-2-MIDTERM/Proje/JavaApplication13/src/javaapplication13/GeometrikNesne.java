/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

/**
 *
 * @author Mahmut
 */
public abstract class GeometrikNesne implements Comparable<Object>{ // diğer sınıflarla ortak özelliklerin bulundugu class diyebiliriz abstarct sınıf
    
  
    private Date date;  // Date tipinde private date olusturdum
    private String etiket;  //private etiket olusturdum

    public GeometrikNesne() {   //parametresiz constructor olusturdum veri girilmediğinde atanacak değerleri içinde barındırır
        date = new Date("Jan",1,1000);  
        etiket = "NoData";
    }
    
    public GeometrikNesne(String etiket,Date date) {    //constructor olusturdum
        setEtiket(etiket);
        setTarih(date);
    }
    
    public GeometrikNesne(GeometrikNesne other){   //copy constructor olusturdum
        date = new Date(other.date);
        etiket = other.etiket;
    }

    public void setTarih(Date newDate) {    //private olarak olusturdugum için erişmek ve değiştirmek için getter ve setter yazdım
        //hata kontrolü
        if (newDate ==null){
            System.out.println("Fatal ERROR");
            System.exit(0);
        }
        else {
            date = new Date(newDate);
            
        }
    }

    public void setEtiket(String newEtiket) {    //private olarak olusturdugum için erişmek ve değiştirmek için getter ve setter yazdım
        //hata kontrolü
        if(newEtiket == null){
            System.out.println("Fatal ERROR"); 
            System.exit(0);
        }
        else{
            etiket = newEtiket;
        }
    }

    public Date getTarih() {    //private olarak olusturdugum için erişmek ve değiştirmek için getter ve setter yazdım
        return date;
    }

    public String getEtiket() {    //private olarak olusturdugum için erişmek ve değiştirmek için getter ve setter yazdım
        return etiket;
    }

    @Override
    public String toString() {  //toString metodu daha kolay yazmayı sağlar tek metod 
        return ("Etiket = " + etiket + "\nTarih = "+date.toString());
    }
    
    
    public abstract double alanHesapla();   //diğer classlar GeometrikNesneyi extend ettiklerinde mecburi kullanmaları gereken implementler
    public abstract double cevreHesapla();
    
    
    
}
