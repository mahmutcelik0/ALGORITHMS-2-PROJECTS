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
public class Daire extends GeometrikNesne{ //Geometrik nesne classından extend edilmiş Daire classı olusturdum

    private double yaricap; //private yaricap olusturdum

    public Daire() {   // değer verilmediğinde otomatik atanacak verilerin bulunduğu parametresiz constructor olusturdum
        super();    // GeometrikNesne nin constructor ı kullanılır bu sayede işlem tekrarına gerek kalmaz 
        yaricap = 1.0;  
    }

    public Daire( String etiket,double yaricap, Date date) { //constructor
        super(etiket,date); //GeometrikNesnenin constructor ını kullandım tekrardan kurtuldum ve özellikler burada da geçerli
        
        if (yaricap <=0){   //yarıcap 0dan küçük oldugunda calısack bir if ve calıstıgında kullanıcıya bilgi verip uygulamayı sonlandıracak
            System.out.println("Fatal Error");
            System.exit(0);
        }
        this.yaricap = yaricap;
    }

    public Daire(Daire otherDaire) { //copy constructor olusturdum
        super(otherDaire);  //GeometrikNesnenin copy constructor ını kullandım
        yaricap = otherDaire.yaricap;

    }
    
      public double getYaricap() {  // yarıcap private oldugu için getter ve setter kullandım erişebilmek ve değiştirebilmek için
        return yaricap;
    }

    public void setYaricap(double newYaricap) {  // yarıcap private oldugu için getter ve setter kullandım erişebilmek ve değiştirebilmek için
        if (newYaricap <=0){    //yarıcap kontrolu 0 dan kucuk oldugunda calısack bir if ve calıstıgında kullanıcıya bilgi verip uygulamayı sonlandıracak
            System.out.println("Fatal error");
            System.exit(0);
        }
        else {
            yaricap = newYaricap;
        }
    }

    @Override
    public String toString() {  // GeometrikNesne de tanımlanmıs toString  ve super i kullanarak kod tekrarından kurtuldum Daire için toString metodu olusturdum
        return super.toString() + "\nYarıçap = " + getYaricap() ;    //YARICAP EKLEMESI Yapıldı
    }

    
    
    
    @Override
    public double alanHesapla() {   //implement edilme kısmı Dairenin alanı için gerekli override ettim
        return (Math.PI*getYaricap()*getYaricap());
    }

    @Override
    public double cevreHesapla() {  //implement edilme kısmı Dairenin cevresi için gerekli override ettim
        return (2 * Math.PI * getYaricap());

        
    }

    @Override
    public int compareTo(Object otherObject) { // karşılaştırma için gerekli implement
        if (this.getClass() != otherObject.getClass()){ //hata kontrolleri
            System.out.println("Fatal Error: Karşılaştırılacak objeler aynı sınıftan olmalı");
            System.out.println("Bu sınıfın objesi : " + this.getClass() + "\n Gönderilen obje : " + otherObject.getClass());
            System.exit(0);
        
        }
        
        else if (otherObject == null){
            System.out.println("Fatal ERROR : Gönderilen obje boş");
            System.exit(0);
        }
        
        // hata kontrolleri bittikten sonra sistemden cıkılmazsa calısacak kısım
        Daire otherDaire = (Daire) otherObject; //karsılastırma için ikinci objeyi Daire oldugunu tanımladım
        
        //dokumanda istenen karsılastırma sonucları
        if (getYaricap()> otherDaire.getYaricap()){ 
            return 1;
        }
        else if ( getYaricap() < otherDaire.getYaricap()){
            return -1;
        }
        else{
            return 0;
        }
        
        
    }

  
    
}

