/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.util.Scanner;       // Gerekli kütüphanenin class a import edilmesi

public class Date   //date adında class olusturdum
{
    private String month;   // private olacak sekilde degiskenler olusturdum ve bunlara erişebilmek için getter ve setterlarını yazdım
    private int day;
    private int year; //a four digit number.

    public Date( )  // Date classının parametresiz classını olusturdum veri girilmeden cagırılıdıgında atanacak degerleri icinde barındırır
    {
        month = "January";
        day = 1;
        year = 1000;
    }

    public Date(int monthInt, int day, int year)    // Date classının constructor ını olusturdum 3 tane veri girildiğinde calısacak constructor
    {
        setDate(monthInt, day, year);
    }

    public Date(String monthString, int day, int year)  // Date classının copy constructor ını olusturdum bir nesne kopyalanmak istendiginde bu constructor kullanılacaktır
    {
        setDate(monthString, day, year);
    }

    public Date(int year)   // sadece yıl girilerek Date classı cagırıldıgında bu constructor calısacaktır
    {
        setDate(1, 1, year);
    }

    public Date(Date aDate) // Date tipinde nesne olusturup atamalar yaptım
    {
        if (aDate == null)//Not a real date.
        {
             System.out.println("Fatal Error.");
             System.exit(0);
        }

        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }

    public void setDate(int monthInt, int day, int year)    //Datete gelen ay a göre farklı atamalar olusturmak gerekliydi 2 tip setter kullanıldı
    {
        if (dateOK(monthInt, day, year))    //date kontrolü
        {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setDate(String monthString, int day, int year)      //Datete gelen ay a göre farklı atamalar olusturmak gerekliydi 2 tip setter kullanıldı
    {
        if (dateOK(monthString, day, year)) //date kontrolü
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setDate(int year)   //sadece yıl girildiğinde yapılacak atama
    {
        setDate(1, 1, year);
    }

    public void setYear(int year)   // yıl setter ı içinde kontrol mekanizması bulundurmakta
    {
        if ( (year < 1000) || (year > 9999) )
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.year = year;
    }
    public void setMonth(int monthNumber)   // ay setter ı içinde kontrol mekanizması bulundurmakta
    {
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }

    public void setDay(int day) // gün setter ı içinde kontrol mekanizması bulundurmakta
    {
        if ((day <= 0) || (day > 31))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.day = day;
    }

    public int getMonth( )  // ay a erişmek için getter içinde if else blokları ile yazıyla yazılanı sayı olarak geri döndürmeyi sağlar
    {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equals("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equals("November"))
            return 11;
        else if (month.equals("December"))
            return 12;
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
            return 0; //Needed to keep the compiler happy
        }
    }

    public int getDay( )    // gün e erişmek için getter
    {
        return day;
    }

    public int getYear( )   //yıl a erişmek için getter
    {
        return year;
    }

    public String toString( )   //Date classının toString metodu
    {
        return (month + " " + day + ", " + year);
    }

    public boolean equals(Date otherDate)   // Date classının equals metodu karşılaştırma için kullanılır iki farklı nesnede
	{
	    if (otherDate == null)
	        return false;
	    else
	        return ( (month.equals(otherDate.month)) &&
	            (day == otherDate.day) && (year == otherDate.year) );
    }

    public boolean precedes(Date otherDate)
    {
        return ( (year < otherDate.year) ||
           (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
           (year == otherDate.year && month.equals(otherDate.month)
                                         && day < otherDate.day) );
    }

    public void readInput( )    //tarihin scanner yardımıyla alınması
    {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year.");
              System.out.println("Do not use a comma.");
            String monthInput = keyboard.next( );
            int dayInput = keyboard.nextInt( );
            int yearInput = keyboard.nextInt( );
            if (dateOK(monthInput, dayInput, yearInput) )
            {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
         }
    }

    private boolean dateOK(int monthInt, int dayInt, int yearInt)   //tarih kontrol metodu int olarak ay geldiğinde calısır  
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean dateOK(String monthString, int dayInt, int yearInt) // tarih kontrol metodu string olarak ay geldiğinde calısır
    {
        return ( monthOK(monthString) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean monthOK(String month)   // ay kontrol metodu
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

    private String monthString(int monthNumber) // aylar sayı oldugunda yazıyla döndürülmesini sağlayan metod 
    {
        switch (monthNumber)
        {
        case 1:
            return "January";
        case 2:
            return "February";
        case 3:
            return "March";
        case 4:
            return "April";
        case 5:
            return "May";
        case 6:
            return "June";
        case 7:
            return "July";
        case 8:
            return "August";
        case 9:
            return "September";
        case 10:
            return "October";
        case 11:
            return "November";
        case 12:
            return "December";
        default:
            System.out.println("Fatal Error");
            System.exit(0);
            return "Error"; //to keep the compiler happy
        }
    }
}

