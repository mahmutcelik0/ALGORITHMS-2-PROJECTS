/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

//GEREKLİ OLAN IMPORTLAR
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Deneme { //Deneme class ı olusturdum içinde main barındıracak
    public static void main(String[] args){
        
        //ilk nesne son nesne ve sondan önceki nesnelere ulaşmak için index kullanmayı düşündüm bunun için 4 tane tanımlama yaptım
        int eklenen_nesne = 0;
        int dikdortgen_sayisi =0;
        int daire_sayisi =0;
        int silindir_sayisi =0;
        
        Scanner dosya = null;   //dosyayı okuma için gerekli
        
        GeometrikNesne[] liste = new GeometrikNesne[50];    // 50 elemanlı liste oluşturdum GeometrikNesne tipinde elemanlar bulunduracak
        
        int index =0;
        
        try{    //dosya bulunamadığında hatanın yakalanması için try catch bloğu olusturdum
            dosya = new Scanner(new FileInputStream("input.txt"));  // dosyayı atadım
        }
        
        catch (FileNotFoundException e){    //try blogu içinde FileNotFoundException hatası alındıgında catch blogu calısır ve system.exit ile program sonlandırılır
            System.out.println("Dosya BULUNAMADI...");
            System.exit(0);
        }
        
        try{    // hata olmaması için try catch blogu olusturdum
            while ( dosya.hasNext()){   // dosyada bir sonraki nesne oldugu sürece donecek while döngüsü
                String isim = dosya.next(); //isim i dosyadan aldım
                String cisim_etiket = dosya.next() ;    //etiketi dosyadan aldım
                if (isim.equals("daire")){  //isimlere göre if else blokları
                    double yaricap = dosya.nextDouble();    //yarıcapı dosyadan aldım
                    dosya.next();   //date yazısının atlanması için
                    
                    int ay = dosya.nextInt();   //date atamaları
                    int gun = dosya.nextInt();
                    int yil = dosya.nextInt();
                    
                    
                    Date tarih = new Date(ay,gun,yil);
                    
                    Daire daire = new Daire(cisim_etiket,yaricap,tarih);    //nesne daire oldugu için daire nesnesi olusturdum
                    liste[index] = daire;   //olusturulan listenin gerekli indexine nesne ataması ve gerekli arttırmalar
                    eklenen_nesne+=1;
                    
                    daire_sayisi++;
                }
                
                else if (isim.equals("dikdortgen")){  
                    double en = dosya.nextDouble(); // dosyadan en i aldım
                    double boy = dosya.nextDouble();    //boy u dosyadan aldım
                    dosya.next();
                    
                    int ay = dosya.nextInt();   //date atamaları
                    int gun = dosya.nextInt();
                    int yil = dosya.nextInt();
                    
                    Date tarih = new Date(ay,gun,yil);
                    
                    Dikdörtgen dikdörtgen = new Dikdörtgen(cisim_etiket,en,boy,tarih);  //nesne dikdörtgen oldugu için dikdörtgen nesnesi olusturdum
                    liste[index] = dikdörtgen;    //olusturulan listenin gerekli indexine nesne ataması ve gerekli arttırmalar 
                    eklenen_nesne+=1;
                    
                    dikdortgen_sayisi++;
                }
                
                else if(isim.equals("silindir")){
                    double yaricap = dosya.nextDouble();    //yarıcapı dosyadan aldım
                    double uzunluk = dosya.nextDouble();    //uzunlugu dosyadan aldım
                    dosya.next();
                    
                    int ay = dosya.nextInt();   //date atamaları
                    int gun = dosya.nextInt();
                    int yil = dosya.nextInt();
                    
                    Date tarih = new Date(ay,gun,yil);
                    
                    Silindir silindir = new Silindir(cisim_etiket,yaricap,uzunluk,tarih);   //nesne silindir oldugu için silindir nesnesi olusturdum
                    liste[index] = silindir;   //olusturulan listenin gerekli indexine nesne ataması ve gerekli arttırmalar
                    eklenen_nesne+=1;
                    
                    silindir_sayisi++;
                }
                
                else {
                    continue;
                }
                
                dosya.nextLine();   //satırın sonuna gelindiğinde alt satıra geçmeyi sağlayan komut
                index+=1;       //her döngüde index 1 artar çünkü her döngü yeni 1 eleman eklenmesi demektir
            }        
        } 
        
        catch(NoSuchElementException e){    //eleman kalmadıgında calısacak kısım dosyanın sonunda 1 defa enter basılmadıgında calısır
                System.out.println("Txt dosyasının sonunda ENTER tusuna 1 defa basınız"); 
                
        }
        
        finally{    //dosyanın işi bittiğinde finally   blogu ile kapatılması
            dosya.close();
        }
        
                
        //listeyi sondan basa dogru dolasacak for dongüsü sayesinde son elemanlar bulunur ve bu elemanlar copy constructor kullanılarak listeye eklenir
        int sonDaire = 0;
        int sonSilindir =0;
        int sonDikdörtgen =0;
        for (int i = liste.length-1;i>=0; i--){ //for döngüsü
            GeometrikNesne dongudeki_nesne  = liste[i]; //nesneyi listeden alır
            
            if (dongudeki_nesne instanceof Daire && sonDaire ==0){  //dongudeki nesne Daire ise ve sonDaire değeri 0 a eşit oldugunda calısacak if blogu
                Daire daireKopyalanacak = (Daire) dongudeki_nesne;  // dongüdeki nesne daire olarak tanımlanır ve adı daireKopyalanacak olarak değiştirilir
                Daire daire = new Daire(daireKopyalanacak); //Daire classının copy constructor ı kullanılarak nesne olusturulur
                liste[eklenen_nesne] = daire;   //listeye olusturulan kopya eklenir ve gerekli arttırmalar yapılır
                eklenen_nesne+=1;
                sonDaire +=1;  
                
                daire_sayisi++; 

            }
            
            else if (dongudeki_nesne instanceof Dikdörtgen && sonDikdörtgen==0){  //dongudeki nesne Dikdörtgen ise ve sonDikdörtgen değeri 0 a eşit oldugunda calısacak if blogu
                Dikdörtgen dikdörtgenKopyalanacak = (Dikdörtgen) dongudeki_nesne;    // dongüdeki nesne dikdörtgen olarak tanımlanır ve adı dikdörtgenKopyalanacak olarak değiştirilir
                Dikdörtgen dikdörtgen = new Dikdörtgen(dikdörtgenKopyalanacak);  //Dikdörgen classının copy constructor ı kullanılarak nesne olusturulur
                sonDikdörtgen+=1;      //listeye olusturulan kopya eklenir ve gerekli arttırmalar yapılır
                liste[eklenen_nesne] = dikdörtgen;
                eklenen_nesne+=1;
                
                dikdortgen_sayisi++;    
            }
            
            else if (dongudeki_nesne instanceof Silindir && sonSilindir ==0){  //dongudeki nesne Silindir ise ve sonSilindir değeri 0 a eşit oldugunda calısacak if blogu
                Silindir silindirKopyalanacak = (Silindir) dongudeki_nesne;    // dongüdeki nesne silindir olarak tanımlanır ve adı silindirKopyalanacak olarak değiştirilir
                Silindir silindir = new Silindir(silindirKopyalanacak);   //Silindir classının copy constructor ı kullanılarak nesne olusturulur
                sonSilindir +=1;       //listeye olusturulan kopya eklenir ve gerekli arttırmalar yapılır

                liste[eklenen_nesne] = silindir;    
                eklenen_nesne+=1;
                
                silindir_sayisi++; 
            }      
        }
        
        for(int s =0 ; s<liste.length;s++){ //listeyi bastan sona dolasacak for döngüsü
            GeometrikNesne nesne = liste[s];    //liste indexindeki elemanı nesne olarak tanımlanıp atanıyor
            if (liste[s] != null){  //nesne bos olmadığında calısacak if blogu
                polymorphicYazdir(nesne);   // dokumanda istenen yazdırmaları içeren fonksiyon
            }
        } 
             
        //ilk eleman sondan onceki eleman ve son elemanı bulmak için bu sekilde atamalar kullandım aklıma daha efektif bir yol gelmedi bu atamalarla indexlere ulasıp liste indexleriyle elemanlara erişim sağladım
        int bulunan_daire = 0;
        int bulunan_dikdortgen = 0;
        int bulunan_silindir =0;
        
        int ilk_daire_indexi=0;
        int sondan_onceki_daire_indexi =0;
        int son_daire_indexi =0;
        int ilk_dikdörtgen_indexi =0;
        int sondan_onceki_dikdörtgen_indexi =0;
        int son_dikdörtgen_indexi =0;
        int ilk_silindir_indexi =0;
        int sondan_onceki_silindir_indexi =0;
        int son_silindir_indexi =0;
        
        for (int a=0 ; a<liste.length;a++){ //liste uzunlugundan kucuk oldugu sürece yanı max 49 olabilecek for döngüsü
            // listeden elemanları sırasıyla aldım ve GeometrikNesne classında nesne olarak atadım nesnenin ne olduguna göre farklı if blokları olusturdum
            //bulunan_dikdörtgen değişkeni ve toplam dikdörtgen_degiskeni sayesinde indexlere erisim sağladım (örnek olarak)
            
            GeometrikNesne nesne = liste[a];
            
            
            if(nesne instanceof Daire){
                bulunan_daire++;
                
                if(bulunan_daire ==1){
                    ilk_daire_indexi =a;
                }
                
                else if(bulunan_daire== (daire_sayisi -1)){
                    sondan_onceki_daire_indexi =a;
                    
                }
                else if (bulunan_daire ==daire_sayisi){
                    son_daire_indexi =a;
                }
                
            }
            else if (nesne instanceof Dikdörtgen){
                bulunan_dikdortgen++;
                
                if(bulunan_dikdortgen ==1){
                    ilk_dikdörtgen_indexi =a;
                    
                }
                
                else if(bulunan_dikdortgen == (dikdortgen_sayisi-1)){
                    sondan_onceki_dikdörtgen_indexi=a;
                }
                
                else if(bulunan_dikdortgen == dikdortgen_sayisi){
                    son_dikdörtgen_indexi =a;
                }
                
            }
            
            else if (nesne instanceof Silindir){
                bulunan_silindir++;
                
                if(bulunan_silindir ==1){
                    ilk_silindir_indexi =a;
                    
                }
                
                else if(bulunan_silindir == (silindir_sayisi-1)){
                    sondan_onceki_silindir_indexi=a;
                }
                
                else if(bulunan_silindir == silindir_sayisi){
                    son_silindir_indexi =a;
                }
                
            }         
        }
        
           
        //dokumanda istenilen karsılastırmalar karsilastir fonksiyonu sayesinde yapıldı
        karsilastir(liste[ilk_daire_indexi], liste[son_daire_indexi]);
        karsilastir(liste[son_daire_indexi], liste[sondan_onceki_daire_indexi]);
        karsilastir(liste[ilk_dikdörtgen_indexi], liste[son_dikdörtgen_indexi]);
        karsilastir(liste[son_dikdörtgen_indexi], liste[sondan_onceki_dikdörtgen_indexi]);
        karsilastir(liste[ilk_silindir_indexi], liste[son_silindir_indexi]);
        karsilastir(liste[son_silindir_indexi], liste[sondan_onceki_silindir_indexi]);
        
        
        
        
        double[] veri_listesi = new double[9];  //2. liste olusturdum ve 9 index uzunlugunda    elemanlara atama yaptım
        
        double cevre_ortalamasi =0.0;
        double alan_ortalamasi =0.0;
        double hacim_ortalamasi =0.0;
        double en_kucuk_cevre_degeri =0.0;
        double en_buyuk_cevre_degeri =0.0;
        double en_kucuk_alan_degeri =0.0;
        double en_buyuk_alan_degeri =0.0;
        double en_kucuk_hacim_degeri =0.0;
        double en_buyuk_hacim_degeri =0.0;  
        
        int gecici_silindir_sayisi = 0; //kacıncı silindirde oldugu bilinmesi için değişken olusturdum
        
        for (int m=0 ; m<liste.length;m++){ //listeyi dolasan for döngüsü

            if(liste[m] != null){   //listedeki deger boş olmadıgında calışan if blogu
                
                cevre_ortalamasi += liste[m].cevreHesapla();    //hesaplamalar
                alan_ortalamasi += liste[m].alanHesapla();
                
                if (liste[m].getEtiket().startsWith("sil")){    //gelen nesnenin etiketi sil ile başladıgında calısacak if blogu
                    Silindir silindir1 = (Silindir) liste[m];   //nesne olusturma ve hesaplamalar
                    hacim_ortalamasi += silindir1.hacimHesapla();
                    gecici_silindir_sayisi++;
                }
                
                if(gecici_silindir_sayisi ==1){ //gecici silindir sayısı değişkeni 1 oldugunda calısacak if blogu içinde atamalar ve hesaplamalar bulunmakta
                    if (liste[m].getEtiket().startsWith("sil")){
                        Silindir silindir = (Silindir) liste[m];
                        en_buyuk_hacim_degeri = silindir.hacimHesapla();
                        en_kucuk_hacim_degeri = silindir.hacimHesapla();
                    }
                }
                
                if (m==0){  // en kucuk ve en buyuk değer atamaları ilk döngü için
                    en_kucuk_cevre_degeri = liste[m].cevreHesapla();
                    en_kucuk_alan_degeri = liste[m].alanHesapla();
                    en_buyuk_cevre_degeri = liste[m].cevreHesapla();
                    en_buyuk_alan_degeri = liste[m].alanHesapla();    
                }
                
                else{   //sonraki döngüler için karsılastırmali else blogu 
                    if (liste[m].cevreHesapla()< en_kucuk_cevre_degeri){
                        en_kucuk_cevre_degeri = liste[m].cevreHesapla();
                    }
                    
                    else if (liste[m].cevreHesapla()> en_buyuk_cevre_degeri){
                        en_buyuk_cevre_degeri = liste[m].cevreHesapla();
                    }
                    
                    if(liste[m].alanHesapla() < en_kucuk_alan_degeri){
                        en_kucuk_alan_degeri = liste[m].alanHesapla();
                    }
                    
                    else if (liste[m].alanHesapla() > en_buyuk_alan_degeri){
                        en_buyuk_alan_degeri = liste[m].alanHesapla();
                    }
                    
                    if (liste[m].getEtiket().startsWith("sil")){
                        Silindir silindir3 = (Silindir) liste[m];
                        
                        if (silindir3.hacimHesapla()< en_kucuk_hacim_degeri){
                            en_kucuk_hacim_degeri = silindir3.hacimHesapla();
                        }
                        
                        else if(silindir3.hacimHesapla() > en_buyuk_hacim_degeri){
                            en_buyuk_hacim_degeri = silindir3.hacimHesapla();
                        }
                    }   
                    
                }
                
            }
        }
        
        //elde edilen değerler istenilen sırada listeye atanır
   
        veri_listesi[0] = cevre_ortalamasi/eklenen_nesne;
        veri_listesi[1] = alan_ortalamasi/eklenen_nesne;
        veri_listesi[2] = hacim_ortalamasi/silindir_sayisi;
        veri_listesi[3] = en_kucuk_cevre_degeri;
        veri_listesi[4] = en_buyuk_cevre_degeri;
        veri_listesi[5] = en_kucuk_alan_degeri;
        veri_listesi[6] = en_buyuk_alan_degeri;
        veri_listesi[7] = en_kucuk_hacim_degeri;
        veri_listesi[8] = en_buyuk_hacim_degeri;
        
        //listenin yazdırılması
        listeYazdir(veri_listesi);

        
                
    } 
    
    public static void karsilastir(GeometrikNesne nesne1,GeometrikNesne nesne2){    //karşılastır fonksiyonu iki tane GeometrikNesne tipinde nesne alır ve compareTo metodunu kullanarak sonucu verir
        System.out.println(nesne1.getEtiket()+" in " +nesne2.getEtiket()+ " ile karşılaştırılması sonucu = "+nesne1.compareTo(nesne2));

    }
    
    
    public static void polymorphicYazdir(GeometrikNesne nesne){ //nesnelerin bilgilerinin yazdırıldığı fonksiyon gelen nesnelerin biçimine göre atamalar yapılır ve class larına göre metodları kullanılır
        String donecek_nesne="";
        System.out.println("Nesne Bilgisi");
        
        if (nesne.getEtiket().startsWith("sil")){
            Silindir silindir = (Silindir) nesne;
            donecek_nesne= silindir.toString() + "\nSilindirin Alanı = " +silindir.alanHesapla() +"\nSilindirin Çevresi = " + silindir.cevreHesapla() +"\nSilindirin Hacmi = " + silindir.hacimHesapla()+"\n";
        }
        
        else if(nesne.getEtiket().startsWith("dik") ){
            Dikdörtgen dikdörtgen = (Dikdörtgen) nesne;
            donecek_nesne= dikdörtgen.toString() + "\nDikdörtgenin Alanı = "+dikdörtgen.alanHesapla() + "\nDikdörtgenin Çevresi = " + dikdörtgen.cevreHesapla()+"\n";
        }
        
        else if(nesne.getEtiket().startsWith("dai")){
            Daire daire = (Daire) nesne;
            donecek_nesne= daire.toString() + "\nDairenin Alanı = " + daire.alanHesapla() + "\nDairenin Çevresi = "+daire.cevreHesapla()+"\n";
        }
        
        System.out.println(donecek_nesne);
    }
    
    
    public static void listeYazdir(double[] list){  //2. listenin sırasıyla yazdırılması 
        
        System.out.println("\nGenel Veriler");
        System.out.println("Cevre Ortalaması = " +list[0]);
        System.out.println("Alan Ortalaması = " + list[1]);
        System.out.println("Hacim Ortalaması = "+list[2]);
        System.out.println("En Küçük Çevre Değeri = " + list[3]);
        System.out.println("En Büyük Çevre Değeri = " + list[4]);
        System.out.println("En Küçük Alan Değeri = " + list[5]);
        System.out.println("En Büyük Alan Değeri = " + list[6]);
        System.out.println("En Küçük Hacim Değeri = " + list[7]);
        System.out.println("En Büyük Hacim Değeri = " + list[8]);
        
    }
    
    
}

