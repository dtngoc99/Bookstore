/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bookstore;

import java.util.Scanner;

/**
 *
 * @author NGOC TY
 */
public class Book extends Author{
    private int bookCode;
    private String bookName;
    private int amount;
    private float price;
    private int yearOfManufacture;

    public int getBookCode() {
        return bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public int getAmount() {
        return amount;
    }

    public float getPrice() {
        return price;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    public void input(){
        Scanner scan=new Scanner(System.in);
        System.out.printf("bookCode: ");
        this.bookCode=scan.nextInt();
        System.out.printf("bookName: ");
        scan.nextLine();
        this.bookName=scan.nextLine();
        System.out.printf("amount: ");
        this.amount=scan.nextInt();
        System.out.printf("price: ");
        this.price=scan.nextInt();
        System.out.printf("year of manufacture: ");
        this.yearOfManufacture=scan.nextInt();
        super.input();
    }
    @Override
    public String toString() {
        return "Book{" + "bookCode=" + bookCode + ", bookName=" + bookName + ", amount=" + amount + ", price=" + price + ", yearOfManufacture=" + yearOfManufacture + '}'+"\n\t"+super.toString();
    }
}
