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
public class DoublyLinkedList {
    class Node{ //Inner node sınıfı
        private CustomerInfo musteri;   // musteri , previous ve next olusturdum
        private Node previous;
        private Node next;
        
        public Node(){  //parametresiz constructor olusturdum
            musteri =null;
            next= null;
            previous = null;
        }
        
        public Node(CustomerInfo newEleman, Node previousNode , Node nextNode){ //parametreli constructor olusturdum ve atamaları yaptım
            musteri = newEleman;
            previous = previousNode;
            next = nextNode;
        }  
    }
    
    private Node head;  //Node tipinde head ve tail olustudum
    private Node tail;
    
    public void elemanEkle(CustomerInfo musteri){   //listeye eleman eklemeyi saglayan metod
        if(head ==null){ //listede eleman olmadıgında calısacak if blogu gelen eleman eklenir ve head tail bu eleman olur
            head = new Node(musteri,null,null);
            tail = head;
        }
        
        else{   //listede eleman varsa calısacak else kısmı
            Node temp = new Node(musteri,null,null);
            Node current = head;
            boolean yerlestirildi = false;
            
            
            //Hocam burada bir eksiklik daha var en basta soylemeliyim. aynı soyada sahip 3 kişi olursa sıralamalarda ilk gelen aynı soyaddaki kişiye gore karsılastırma yapıp sonraki soyaddakine göre karsılastırılma yapılmıyor cunku kod daha da karmasıklasıyor bende tam kafamda kuramadıgımm icin yazmayı denemedım
            // Ahmet BBB Ali BBB Berk BBB bu şekilde 3 eleman olursa sıralamalarda hata olabilir
            while(!yerlestirildi){  //eleman yerlestirilemediği surece donecek while dongusu
                String[] eklenecek_eleman = temp.musteri.getAdSoyad().split(" ");   //musterının isim ve soyismini birden cok olma ihtimali oldugu ıcın ismin parcalayarak diziye ekledim
                String[] mevcut_eleman = current.musteri.getAdSoyad().split(" ");
            
                if (eklenecek_eleman[eklenecek_eleman.length-1].equals(mevcut_eleman[mevcut_eleman.length-1])){ //aynı soyada sahip iki müşteri olursa bu bloga girilir
                    String eklenecek_eleman_isim;   //müsterilerin kac elemanlı olduklarını bilmediğimiz için yeni String yapılı degiskenler olusturdum ve isimleri buraya esitledim
                    String mevcut_eleman_isim;
                    
                    if(eklenecek_eleman.length>2){  //eklenecek eleman 2 isimli oldugunda calısacak blok // burada mantık olarak hata var while dongusu kullanmam gerekirdi 3 isimli de olabilir =3 dersem kucuk mantık hatası denk gelirse bulunamayacagı için >2 dedim musterılerın en az 1 en fazla 2 isimli olabilecegini varsaydım
                        eklenecek_eleman_isim = eklenecek_eleman[0] + eklenecek_eleman[1];  //musterı ısmının yerlestırılmesı
                        
                    }
                    else{   //tek isimli ise calısacak blok
                        eklenecek_eleman_isim = eklenecek_eleman[0];
                        
                    }
                    if(mevcut_eleman.length>2){ //mevcut eleman 2 isimli oldugunda calısacak blok // yukarıdakiyle aynı durum soz konusu
                        mevcut_eleman_isim = mevcut_eleman[0] + mevcut_eleman[1];   // mevcut eleman isminin yerlestirilmesi
                        
                    }
                    else{   //tek isimli ise calısacak blok
                        mevcut_eleman_isim = mevcut_eleman[0];
                    }
                    
                    if(eklenecek_eleman_isim.compareTo(mevcut_eleman_isim)<0){  //aynı soyada sahip iki müsterinin isimleri karsılastırıldıgında yeni eklenecek elemanın ismi alfabetik olarak mevcut elemanın isminden buyukse calısacak blok
                        if(current.equals(head)){   //listedeki eleman head e esit olunca calısacak blok bu kısımda head else de ise tail kullanılacak cunku alfabetik olarak buyuk olunca head in ustune eklenebilir else de ise alfabetik olarak kucuk olunca tail in altına eklenebilir
                            yerlestirildi = true;
                            Node eleman = head; //gerekli atamalar
                            head = new Node(musteri,null,head.next);
                            head.next = eleman;
                            eleman.previous = head;
                        }
                        else{   //listenin devamında calısacak durum
                            yerlestirildi = true;
                            Node eleman_2 = current.previous;
                            Node newNode = new Node(musteri,current.previous,current);
                            current.previous = newNode;
                            eleman_2.next = newNode;
                        }
                        
                    }
                    else{   //aynı soyada sahip iki müsterinin isimleri karsılastırıldıgında yeni eklenecek elemanın ismi alfabetik olarak mevcut elemanın isminden kucukse calısacak blok
                        if(current.equals(tail)){   //yukarıdaki head icin anlattıgım durumda mevcut
                            yerlestirildi = true;   //atamalar
                            Node eleman = tail;
                            tail = new Node(musteri,tail.previous,null);
                            tail.previous = eleman;
                            eleman.next = tail;
                        }
                        else{   //listenin kalanında calısacak durum
                            yerlestirildi = true;   //atamalar
                            Node eleman_2 = current.next;
                            Node newNode = new Node(musteri,current,eleman_2);
                            current.next = newNode;
                            eleman_2.previous = newNode;
                        }
                    }
                    
                }
                else if((eklenecek_eleman[eklenecek_eleman.length-1].compareTo(mevcut_eleman[mevcut_eleman.length-1]))<0){  //eklenecek musterının soyadı listede bulunulan musterının soyadından alfabetik olarak büyükse calısacak blok
                    if(current.equals(head)){   // listedeki elemanın head e esit oldugunda calısacak blok
                        yerlestirildi = true;   //head degistirilir ve yeni head olusur
                        Node eleman = head;
                        head = new Node(musteri,null,head.next);
                        head.next = eleman;
                        eleman.previous = head;
                    }
                    else{   //devamındaki kosullarda calısacak blok
                        yerlestirildi = true;   // listedeki elemanın üstüne ekleme yapılır 
                        Node eleman_2 = current.previous;
                        Node newNode = new Node(musteri,current.previous,current);
                        current.previous = newNode;
                        eleman_2.next = newNode;
                    }
                }
                else if(current.next == null){  //eleman sona eklenir cunku soyadı alfabetik olarak en kucuk kısı
                    Node kuyruk = new Node(musteri, tail,null); //kuyruk ataması ve degıstırılmesı
                    tail.next= kuyruk;
                    tail = kuyruk;
                    yerlestirildi = true;   
                }
                current = current.next;        //if else if blokları calısmadıgında listedeki mevcut eleman bir sonrakine gecilir   
            }
        }       
    }
    
     public void adVerilenMusteriYazdir(String adSoyad){    // adi verilen musteriyi listede bulan ve bilgilerini yazdıran metod
        Node current = head;    //current e head ataması yaptım
        
        if(head == null){   //head null oldugunda liste bos olur ve asaıgdakı kısım yazdırılır
            System.out.println("LİSTE BOŞ, ELEMAN EKLEYİNİZ...");
            
        }
        boolean deger = false;  //musterı bulunasıya kadar false olacak deger true oldugunda while dongusu durur

        while(current != null && deger ==false){    //liste bittiginde ya da musterı oncesınde bulundugunda duracak while dongusu
            
            if(current.musteri.getAdSoyad().equals(adSoyad)){   // listeden gelen elemanın ad soyadı aranan  elemanın ad soyadına esit oldugunda calisacak if blogu
                
                System.out.println(current.musteri.toString()); //musteri bilgilerinin yazdırılması ve deger e true atanıp dongunun durdurulması
                deger =true;
            }
            
            else if(current.next == null){  // listenin son elemanına gelinip hala yoksa boyle bir kullanıcının bulunmadıgı anlasılır ve bu blok calısır ve dongu durması ıcın deger e true ataması yapılır
                System.out.println("BÖYLE BİR KULLANICI BULUNMAMAKTADIR");
                deger =true;
            }
            
            else{
                current = current.next; // eleman bulunamadıgında listedeki sonraki elemana gecis
            }
            
        }   
    }
     
     public int elemanSayisi(){ //listedeki eleman sayısını bulmayı saglayan metod
         Node current = head;   //headden baslayarak devam eder ve a degıskenıne ekleme yapar
         int a =0;
         
         while(current !=null){ //listenin sonuna kadar gidecek while dongusu ve icinde a ya ekleme yapar
             a++;
             current = current.next;
         }
         
         return a;
         
     }
     
     
     
     public void adVerilenMusteriSil(String adSoyad){   //adi verilen musterinin silinmesi
        Node current = head;    //headden baslayacak current degıskenı
        boolean girebilir = false;  //asagıdaki iki if blogundaki kosullardan sonra while dongusunun calısmaması icin gerekli kısım
        
        if(head == null ){  //eleman yoksa hata fırlatılır
            girebilir =true;

            throw new IllegalStateException();
        }
        
        else if(elemanSayisi() ==1 ){   //tek eleman varsa listeden silinir ve girebilir ifadesi true ya dondurulur ve while dongusu calısmaz
            head = null;
            tail = null;
            girebilir = true;
        }
        boolean deger = false;  //deger degıskeni musterı bulunasıya kadar false olur ve bulundugunda true ataması yapılarak dongunun durması saglanır
        
        while(current!=null && deger ==false && girebilir == false){    //dongü
            
            if(current.musteri.getAdSoyad().equals(adSoyad )){  //listeden gelen musteri aranan musterıyse calısacak if blogu calısmazsa else ile listedeki sonraki musteriye gecilir
                
                deger = true;
                
                if(current.previous ==null){    // headden silmeyi yapan kısım
                    current = current.next;
                    current.previous = null;
                    head = current;
                }
                
                else if(current.next ==null){   //tailden silmeyi yapan kısım
                    current = current.previous;
                    current.next = null;
                    tail = current;
                }
                
                else{   // ortadan silmeyi yapan kısım
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    current = current.next;
                }  
                
            }
            else{   //sonraki musteriye gecilecek blok
                current = current.next;
            }
        }
        
    }
        
    public void yazdir() {  // headden itibaren baslayarak sona kadar yazdıran metod
        Node position = head;   //head in oldugu yerden baslamak ıcın position a head atadım
        while(position != null){    // null olmadıgı surece yazdırıp devam edecek döngü
            System.out.println(position.musteri.toString());
            position = position.next;
        }
        
        if(elemanSayisi() ==0){ //listede eleman yoksa calısacak if blogu
            System.out.println("LİSTEDE ELEMAN YOK");
        }
    }
    
    public void terstenYazdir(){    //tailden itibaren baslayarak basa kadar yazdıran metod
        Node position=tail; // tail in oldugu yerden baslamak için position a tail atadım
        while(position != null){    //null olmadıgı surece yazdırıp devam edecek döngü
            System.out.println(position.musteri.toString());
            position= position.previous;
        }
        
        if (elemanSayisi() ==0){    //listede eleman yoksa calısacak if blogu
            System.out.println("LİSTEDE ELEMAN YOK");
        }
    }
    
    
    
    
    
    
}
