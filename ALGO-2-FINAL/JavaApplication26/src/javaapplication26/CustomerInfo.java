/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication26;

/**
 *
 * @author Mahmut
 */
public class CustomerInfo { //CustomerInfo sınıfı
    private String adSoyad; //private String tipinde adSoyad olusturdum
    private String adres;   //private String tipinde adres olusturdum
    private Object numaralar;   //private Object tipinde numaralar olusturdum arraylistten gelen kısım buraya gelecek

    public CustomerInfo(String adSoyad, String adres,Object numaralar) {    //constructor olusturdum 
        this.adSoyad = adSoyad;
        this.adres = adres;
        this.numaralar = numaralar;
    }
    
    public Object getNumaralar() {  //private olarak olusturdugum icin getter ve setterları yazdım
        return numaralar;
    }

    public void setNumaralar(Object numaralar) { //private olarak olusturdugum icin getter ve setterları yazdım
        this.numaralar = numaralar;
    }
    

    public String getAdSoyad() { //private olarak olusturdugum icin getter ve setterları yazdım
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) { //private olarak olusturdugum icin getter ve setterları yazdım
        this.adSoyad = adSoyad;
    }

    public String getAdres() { //private olarak olusturdugum icin getter ve setterları yazdım
        return adres;
    }

    public void setAdres(String adres) { //private olarak olusturdugum icin getter ve setterları yazdım
        this.adres = adres;
    }

    @Override
    public String toString() {  //CustomerInfo sınıfının toString metodu kullanıldıgında musteri ile ilgili bilgilerin yazdırılmasını saglar
        return "\nMüşteri Ad Soyad: " + getAdSoyad() + "\nAdres:" + getAdres() + "\nNumara(lar): " + getNumaralar();
    }

}
