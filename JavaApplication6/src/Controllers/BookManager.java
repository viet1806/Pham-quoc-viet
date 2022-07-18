/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Book;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vietk
 */
public class BookManager {
    public ArrayList<Book> list;

    public BookManager() {
        list = new ArrayList<Book>();
    }
    
    public void AddBook(){
        Scanner sc = new Scanner(System.in);
        Book st =  new Book();
        System.out.print("Book ID:");
        st.setBookID(sc.nextLine());
        System.out.print("Book name:");
        st.setBookName(sc.nextLine());
        System.out.print("Author:");
        st.setAuthor(sc.nextLine());
        System.out.print("Price:");
        st.setPrice("$"+sc.nextLine());
        list.add(st);
    }
    
    public void DisplayBook(){
        System.out.println("Display all students");
        System.out.println(" Book ID         Book Name            Author     Price");
        System.out.println("---------    -------------------    ----------  -------");
        for(Book book : list)
        {
            System.out.printf("%5s    ", book.getBookID());
            System.out.printf("%15s    ", book.getBookName());
            System.out.printf("%15s", book.getAuthor());
            System.out.printf("%10s\n", book.getPrice());
        }
    }
    
    public void Save() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\books.dat");
            oos = new ObjectOutputStream(fos);

            oos.writeInt(list.size());
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }
            list.clear();
            System.out.println("Ghi tệp thành công");
        } catch (FileNotFoundException ex) {
            System.out.println("Có lỗi mở tệp để ghi!");
        } catch (Exception e) {
            System.out.println("Có lỗi!");
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void doc_file(){
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("D:\\books.dat");
            ois = new ObjectInputStream(fis);
            int n = ois.readInt();
            list.clear();
            for(int i=0; i<n;i++){
                Book sv = (Book)ois.readObject();
                list.add(sv);
            }
        } catch (FileNotFoundException ex){
                System.out.println("Có lỗi mở tệp để đọc!");
        }
        catch(EOFException e1){
            System.out.println("Kết thúc tệp");
        }
        catch(Exception e2){
            System.out.println("Có lỗi đọc tệp!");
            e2.printStackTrace();
        }
        finally{
            try{
                ois.close();
                fis.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}