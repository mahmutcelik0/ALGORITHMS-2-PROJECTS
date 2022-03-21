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
public class Silindir extends GeometrikNesne{   //Geometrik nesne classından extend edilmiş Silindir classı olusturdum
    private double yaricap; //private yarıcap olusturdum
    private double uzunluk; //private uzunluk olusturdum

    public Silindir() {  // değer verilmediğinde otomatik atanacak verilerin bulunduğu parametresiz constructor olusturdum
        super();   // GeometrikNesne nin constructor ı kullanılır bu sayede işlem tekrarına gerek kalmaz 
        yaricap =1.0;
        uzunluk = 1.0;
    }

    public Silindir( String etiket,double yaricap, double uzunluk, Date date) { //constructor olusturdum
        super(etiket,date); //GeometrikNesne classının constructorını kullandım
        //hata kontrolleri
        if (yaricap<=0){
            System.out.println("Fatal Error");
            System.exit(0);
        }
        if (uzunluk<=0){
            System.out.println("Fatal Error");
            System.exit(0);
        }
        
        this.yaricap = yaricap;
        this.uzunluk = uzunluk;
    }

    public Silindir(Silindir otherSilindir) {   //copyconstructor olusturdum
        super(otherSilindir);
        yaricap = otherSilindir.yaricap;
        uzunluk = otherSilindir.uzunluk;
    }

    public double getYaricap() {    // yarıcap private oldugu için getter ve setter kullandım erişebilmek ve değiştirebilmek için
        return yaricap;
    }

    public void setYaricap(double newYaricap) { // yarıcap private oldugu için getter ve setter kullandım erişebilmek ve değiştirebilmek için
        //hata kontrolü
        if (newYaricap <=0){
            System.out.println("Fatal ERROR");
            System.exit(0);
        }
        else{
            yaricap = newYaricap;
        }  
    }

    public double getUzunluk() {    // uzunluk private oldugu için getter ve setter kullandım erişebilmek ve değiştirebilmek için
        return uzunluk;
    }

    public void setUzunluk(double newUzunluk) { // uzunluk private oldugu için getter ve setter kullandım erişebilmek ve değiştirebilmek için
        //hata kontrolü       
        if (newUzunluk <=0){
            System.out.println("Fatal ERROR");
            System.exit(0);
        }
        else{
            uzunluk = newUzunluk;
        } 
    }
    
    @Override
    public String toString() {  // GeometrikNesne de tanımlanmıs toString  ve super i kullanarak kod tekrarından kurtuldum uzunluk ve yarıcapı ekleyerek toString metodu olusturdum
        return super.toString() + "\nYarıçap = " + yaricap + "\nUzunluk = " + uzunluk;
    }
    
    public double hacimHesapla(){   //implement edilme kısmı Silindirin hacmi için gerekli override ettim
        return (Math.PI * getYaricap() * getYaricap() * getUzunluk());
    }
        
    @Override
    public double alanHesapla() {   //implement edilme kısmı Silindirin alanı için gerekli override ettim
        return (2 * getYaricap() * Math.PI * (getUzunluk() + getYaricap()) );
    }

    @Override
    public double cevreHesapla() {  //implement edilme kısmı Silindirin çevresi için gerekli override ettim
        return ((2*2*getYaricap()*Math.PI)+(2*getUzunluk()));
    }

    @Override
   public int compareTo(Object otherObject) { //karşılaştırma için gerekli implement
       //hata kontrolleri
        if (this.getClass() != otherObject.getClass()){
            System.out.println("Fatal Error: Karşılaştırılacak objeler aynı sınıftan olmalı");
            System.out.println("Bu sınıfın objesi : " + this.getClass() + "\n Gönderilen obje : " + otherObject.getClass());
            System.exit(0);
        
        }
        
        else if (otherObject == null){
            System.out.println("Fatal ERROR : Gönderilen obje boş");
            System.exit(0);
        }
        
                // hata kontrolleri bittikten sonra sistemden cıkılmazsa calısacak kısım

        Silindir otherSilindir = (Silindir) otherObject;
        
        //dokumanda istenen karsılastırma sonucları
        
        if(hacimHesapla() > otherSilindir.hacimHesapla()){
           return 1; 
        }
        
        else if(hacimHesapla() < otherSilindir.hacimHesapla()){
            return -1;
        }
        
        else{
            return 0;
        }
        
    }
    
}
