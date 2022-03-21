/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication26;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


//Merhaba hocam. Kodumda cozemedigim bi eksiklik var uzun ugras verdım fakat sebebini cozemedım 
//Acıklayacak olursam; 1 tusuna bastıgımda txtden isimleri okuyup listeye olması gerektiği sırada ekliyor. Bu kısımda problem yok.
//2 tusuyla fazla tekrarda kullanıcılar girdiğimde isimleri listeye olması gerektiği sırada ekliyor. Bu kısımda da problem yok.
// Ancak once 1 sonrasında 2 ile eleman eklediğimde txtden okunan veriler kendi içinde sıralanıyor 2 ile eklenenler kendi içinde sıralanıyor mantıken boyle olmaması gerekiyor cunku ikisiyle de elemanı aynı metodla ekliyorum listeler aynı ama nedenini cozemedım
// once 2 sonra 1 ile ekleme yaptıgımda da aynı durum soz konusu 
//Teşekkürler, iyi günler.



/**
 *
 * @author Mahmut
 */
public class Deneme {
    public static void main(String[] args){ //main classı 
                
        DoublyLinkedList liste = new DoublyLinkedList();    // tüm müşterilerin ve bilgilerinin tutulacağı liste
        
        Scanner scanner = new Scanner(System.in);   //kullanıcıdan veri almak için scanner  olusturdum
        
        System.out.println("PROGRAMA HOŞGELNDİNİZ\n");
        System.out.println("İŞLEM YAPABİLECEĞİNİZ KOMUTLARI KULLANMAK İÇİN YANLARINDAKİ SAYILARI KULLANINIZ\n");
        
        komutlar(); //kullanıcının görüp içinden yapmak istediği işlemi secmesini sağlayacak yazılar
        int sayi ;  // kullanıcıdan yapmak istediği işlemin sayısını tutacak deger

        do{ //en az 1 defa calısacak döngü
            System.out.print("\nLÜTFEN SAYI GİRİNİZ:");
            
            sayi = scanner.nextInt();   // kullanıcıdan sayiyi  alan kısım
            scanner.nextLine();
            
            if(sayi ==1){   // 1 oldugunda customer.txt deki musterileri alan ve listeye ekleyen kısım
                Scanner scanner_2 = null;   // yeni scanner olusturma
                
                try{    // try catch kontrolü ile belgenin okunması
                    scanner_2 = new Scanner(new FileInputStream("customer.txt"));
                }
                catch(FileNotFoundException e){ // dosya bulunamadıgında calısacak catch blogu 
                    
                    System.out.println("DOSYA BULUNAMADI..");
                    System.exit(0);
                    
                }
                
                try{    //dosyanın okunması için try catch blogu
                    while(scanner_2.hasNext()){//devamında eleman oldugu surece donecek while döngüsü
                        
                        ArrayList<String> liste_3 = new ArrayList<>();  //liste_3 ü olusturmamın sebebi müsterinin telefon numaralarını saklamak için

                        String satir = scanner_2.nextLine();    // tüm satırı alan kısım txtden
                        
                        String[] parcalar = satir.split(",");   // alınan satırı , gördükçe bölen ve diziye ekleyen kısım
                        
                        String isim = parcalar[0];  //dizidekilerin atamaları
                        String adres = parcalar[1]; 
                        
                        for(int i =2; i<parcalar.length;i++){   //2.indexten sona kadar yani tüm telefon numaralarını ekleyen kısım
                            liste_3.add(parcalar[i]);
                        }
                        
                        CustomerInfo txt_elemani = new CustomerInfo(isim, adres, liste_3);  //müsterinin olusturulması
                        
                        liste.elemanEkle(txt_elemani);  //elemanın eklenme yapılması
                        
                    }   
                    
                    
                }
                
                catch(NoSuchElementException e){    //txt dosyasında sona 1 defa enter basılmadıgında hata alınacaktır ve bu kısım calısır
                    System.out.println("TXT dosyasının sonunda ENTER tusuna 1 defa basınız");
                }
                finally{    //dosyanın kapatılması
                    scanner_2.close();
                }
                
            }
            
            else if(sayi ==2){  // 2girildiğinde kullanıcıdan veri alan ve listeye ekleyen kısım
                ArrayList<String> liste_2 = new ArrayList<>();  //kullanıcının telefon numaralarını saklayacagım ArrayList 

                
                System.out.print("\nKullanıcı Adını Giriniz:");
                String kullanici_adi = scanner.nextLine();  // ismi kullanıcıdan alan kısım
                
                System.out.print("Kullanıcı Adresini Giriniz:");
                String kullanici_adresi = scanner.nextLine();   // adresi kullanıcıdan alan kısım
                
                System.out.print("Kullanıcı Telefon Numara(lar) Giriniz:");
                String ilk_no = scanner.nextLine(); //ilk numarayı kullanıcıdan alan kısım
                liste_2.add(ilk_no);    //ArrayList e alınan degeri ekleyen kısım
                
                String devam;
                do{ // Bu döngüde en az 1 defa calısacak baska numara olup olmadıgı kısım eger kullanıcı + girerse devamında numara istenir ve ArrayList e ekler sonrasında fonksiyon kullanarak listeye eklenir
                    System.out.print("\nEKLEMEK İSTEDİĞİNİZ BAŞKA NUMARA VARSA (+)'ya yoksa (-)'ye basınız: ");
                    devam = scanner.next(); // kullanıcıdan devam etme durumunu alan kısım
                    scanner.nextLine();
                    
                    if(devam.equals("+")){  // eger + girilirse numara alınır
                        System.out.print("\nKullanıcı Telefon Numara(lar) Giriniz:");
                        String diger_no = scanner.nextLine();   // diger numarayı kullanıcıdan alan kısım
                        liste_2.add(diger_no);  // numaralar ArrayListine ekleyen kısım
                    }
                    
                }while(devam.equals("+"));  // kullanıcıdan + alındıgı surece calısacak dongu
                
                CustomerInfo eklenecek_eleman = new CustomerInfo(kullanici_adi, kullanici_adresi, liste_2); // yeni bir musteri elemanı olusturma kısmı
                liste.elemanEkle(eklenecek_eleman); //listeye elemanı ekleyen kısım
            }
            
            else if(sayi ==3){  // 3 girildğinde kullanıcıdan veri alır ve adVerilenMusteriYazdır fonksiyonu kullanılarak kullanıcı listede bulunur ve yazdırılır
                System.out.print("\nBİLGİLERİNİ GÖRMEK İSTEDİĞİNİZ KULLANICININ ADINI VE SOYADINI GİRİNİZ:");
                String goruntulenecek = scanner.nextLine(); // kullanıcıdan veri alan kısım
                liste.adVerilenMusteriYazdir(goruntulenecek);   //fonksiyona gecen kısım
            
            }
            
            else if(sayi ==4){  // 4 girildiğinde kullanıcıdan veri alır ve adVerilenMusteriSil fonksiyonu kullanılarak silinir
                System.out.print("\nSİLMEK İSTEDİĞİNİZ KULLANICININ ADINI VE SOYADINI GİRİNİZ:");
                String silinecek = scanner.nextLine();  // kullanıcıdan veri alan kısım
                
                liste.adVerilenMusteriSil(silinecek);   //fonksiyona gecis kısmı
            }
            
            else if(sayi ==5){  //5 girildiğinde listeyi bastan sona yazdıracak kısım
                liste.yazdir();
            }
            
            else if(sayi ==6){  //6 girildiğinde listeyi sondan basa yazdıracak kısım
                liste.terstenYazdir();
            }
            
            else if(sayi ==7){  // 7 girildiğinde cıkılmayı sağlayan kısım
                System.out.println("\nSİSTEMDEN ÇIKILIYOR");
                System.exit(0);
            }
            
            else{   // verilen seceneklerden girilmediğinde calıscak kısım
                System.out.println("\nVERİLEN KOMUT TABLOSUNDAKİ SAYILARDAN BİRİNİ GİRİNİZ");
            }
            
            
            
        }while(sayi!=7);    // sayı 7 olmadıgı surece donecek döngü
        
        
        
    }
    public static void komutlar(){  //kullanıcı arayuzu görünecek kısım
        System.out.println("(1) -- TXT DOSYASINDAKİ VERİLERİ OKU");
        System.out.println("(2) -- EKLEME YAP");
        System.out.println("(3) -- ADI VERİLECEK MÜŞTERİYİ GÖSTER");
        System.out.println("(4) -- ADI VERİLECEK MÜŞTERİYİ SİL");
        System.out.println("(5) -- TÜM KAYITLARI ARTAN ALFABETİK SIRADA YAZDIR (A -> Z)");
        System.out.println("(6) -- TÜM KAYITLARI AZALAN ALFABETİK SIRADA YAZIR (Z -> A)");
        System.out.println("(7) -- PROGRAMDAN ÇIKIŞ YAP");

    }
}
