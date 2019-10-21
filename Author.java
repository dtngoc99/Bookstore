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
public class Author {
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    @Override
    public String toString() {
        return "Author{" + "authorName=" + authorName + '}';
    }  
    public void input(){
        Scanner scan=new Scanner(System.in);
        System.out.printf("authorName: ");
        this.authorName=scan.nextLine();
    }
}
