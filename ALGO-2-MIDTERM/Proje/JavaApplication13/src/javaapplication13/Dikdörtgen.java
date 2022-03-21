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
public class Dikdörtgen extends GeometrikNesne{ // Dikdörtgen classını olusturdum ve GeometrikNesne den extend ettim

    private double en;  //private en olusturdum
    private double boy; //private boy olusturdum
    
    public Dikdörtgen(){    //parametresiz constructor olusturdum
        super();    //super kullanarak GeometrikNesne deki parametresiz constructor ı kullandım
        en = 1.0;   //veri girilmediğinde atanacak değerler
        boy = 1.0;   
    }

    public Dikdörtgen(String etiket,double en, double boy, Date date) { //constructor olusturdum 
        super(etiket,date); // super kullanarak GeometrikNesne deki constructor ı kullandım
        //hata kontrolleri
        if (en<=0){
            System.out.println("Fatal Error");
            System.exit(0);
        }
        if (boy<=0){
            System.out.println("Fatal Error");
            System.exit(0);
        }
        this.en = en;
        this.boy = boy;
    }
    
    public Dikdörtgen(Dikdörtgen otherDikdörtgen){  //copyconstructor ı olusturdum
        super(otherDikdörtgen); //super kullanarak GeometrikNesne deki copyconstructor ı kullandım
        en = otherDikdörtgen.en;
        boy = otherDikdörtgen.boy;
    }

    public double getEn() { //private olarak olusturdugum en e erişmek veya değiştirmek için getter ve setterlar kullandım
        return en;   //private olarak olusturdugum en e erişmek veya değiştirmek için getter ve setterlar kullandım
    }

    public void setEn(double newEn) {    //private olarak olusturdugum en e erişmek veya değiştirmek için getter ve setterlar kullandım
        if (newEn <=0){ //hata kontrolü için if
            System.out.println("Fatal ERROR");
            System.exit(0);
        }
        else{
            en = newEn;
        }
    }

    public double getBoy() {     //private olarak olusturdugum en e erişmek veya değiştirmek için getter ve setterlar kullandım
        return boy;
    }

    public void setBoy(double newBoy) {  //private olarak olusturdugum en e erişmek veya değiştirmek için getter ve setterlar kullandım
        if (newBoy<=0){ //hata kontrolü için if
            System.out.println("Fatal ERROR");
            System.exit(0);
        }
        else{
            boy = newBoy;
        }
    }

    @Override
    public String toString() {  //super kullanarak GeometrikNesne deki toString metoduna erişim sağladım ve Dikdörtgenin sahip oldugu ek özellikleri de ekleyerek toString metodu olusturdum
        return super.toString() + "\nEn = " + getEn() + "\nBoy = " + getBoy();
    }   
    
    @Override
    public double alanHesapla() {   // extend sonucu mecburi yazılması gerekenlerden alanHesaplayı formule uygun sekilde yazdım
        return (getEn() * getBoy()); 
    }

    @Override
    public double cevreHesapla() {   // extend sonucu mecburi yazılması gerekenlerden cevreHesaplayı formule uygun sekilde yazdım
        return (2*(getBoy()+getEn())); 
    }

    @Override
    public int compareTo(Object otherObject) { // compareTo metodunu karşılaştırma için kullanılacak ve extend kullanıldığı ve GeometrikNesne de abstarct oldugu için yazılması zorunlu
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
        //system.exit calısmazsa diğer nesneyi Dikdörtgen olarak belirtiyor
        
        Dikdörtgen otherDikdörtgen = (Dikdörtgen) otherObject;
        
        //dokumanda istenen değerlere göre if blokları
        if (alanHesapla() > otherDikdörtgen.alanHesapla()){
            return 1;
        }
        else if (alanHesapla() == otherDikdörtgen.alanHesapla()){
            return 0 ;
            
        }
        
        else {
            return  -1;
        }




    }
     
}

