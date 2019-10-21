/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bookstore;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author NGOC TY
 */
public class Manage {
    ArrayList<Book> bookList=new ArrayList<>();
    final static String link="D:\\NetBean\\Java\\JavaApplication6\\src\\BookManager\\Book.txt";
    public void readFile() throws IOException, ClassNotFoundException{
        try {
            
            Scanner scan=new Scanner(Paths.get(link),"UTF-8");
            String s;
            while(scan.hasNextLine()){
                Book bk=new Book();
                bk.setBookCode(scan.nextInt());
                bk.setAmount(scan.nextInt());
                bk.setPrice(scan.nextFloat());
                bk.setYearOfManufacture(scan.nextInt());
                s=scan.nextLine().trim();
                StringTokenizer token=new StringTokenizer(s,",");
                bk.setBookName(token.nextToken());
                bk.setAuthorName(token.nextToken());
                bookList.add(bk);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error ReadFile");
            //Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void writeFile() throws IOException{         
        try {
            FileOutputStream fos=new FileOutputStream(link);
            OutputStreamWriter osw=new OutputStreamWriter(fos);
            BufferedWriter bw=new BufferedWriter(osw);
            for(Book bk:bookList){
                bw.write(bk.getBookCode()+" ");
                bw.write(bk.getAmount()+" ");
                bw.write(bk.getPrice()+" ");
                bw.write(bk.getYearOfManufacture()+" ");
                bw.write(bk.getBookName()+",");
                bw.write(bk.getAuthorName()+"\n");
            }
            bw.close();
            osw.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void addBook(){
        Book b=new Book();
        b.input();
        for(Book bk:bookList){
            if(b.getBookCode()==bk.getBookCode() ){
                bk.setAmount(bk.getAmount()+b.getAmount());
                return;
            }
        }

        bookList.add(b);
    }
    public void deleteBook(int bookCode){
        for(Book bk: bookList){
            if(bookCode==bk.getBookCode()){
                if(bk.getAmount()>1){
                    bk.setAmount(bk.getAmount()-1);
                }
                else bookList.remove(bk);
                break;
            }
            
        }
    }
    public String searchByAuthor(String name){
        for(Book b: bookList){
            if(name.equals(b.getAuthorName())){
                return b.toString();
            }
        }
        return "Not exists";
    }
    public String searchByBookName(String name){
        for(Book b: bookList){
            if(name.equals(b.getBookName()))
            {
                return b.toString();
            }
        }
        return "Not exists";
        
    }
    public static void clrscr(){
       //Clears Screen in java
       try {
           if (System.getProperty("os.name").contains("Windows"))
               new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
           else
               Runtime.getRuntime().exec("clear");
       } catch (IOException | InterruptedException ex) {}
    }
    public void menu() throws IOException{
        Scanner scan=new Scanner(System.in);
        try {
            readFile();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error ReadFile");
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true){
//            Runtime run=Runtime.getRuntime();
//            run.exec("cls");
            //clrscr();
            System.out.println("\t0.Break");
            System.out.println("\t1.BookList");
            System.out.println("\t2.AddBook");
            System.out.println("\t3.DeleteBook");
            System.out.println("\t4.SearchByAuthor");
            System.out.println("\t5.SearchByBookName");
            int select = 0;
            System.out.printf("Selection: ");
            select=scan.nextInt();
            switch(select){
                case 1:
                    for(Book b: bookList){
                        System.out.println(b.toString());
                    }
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    int code=0;
                    System.out.printf("BookCode: ");
                    code=scan.nextInt();
                    deleteBook(code);
                    break;
                case 4:
                    System.out.printf("Author: ");
                    scan.nextLine();
                    String author=scan.nextLine();
                    System.out.println(searchByAuthor(author));
                    break;
                case 5:
                    System.out.printf("BookName: ");
                    scan.nextLine();
                    String bookName=scan.nextLine();
                    System.out.println(searchByBookName(bookName));
                    break;
                default:
                    writeFile();
                    return;
                    
            }
            
        }
       
    }
                        
}
