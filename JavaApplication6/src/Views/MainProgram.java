/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.BookManager;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Toanne
 */
public class MainProgram {
    public static int menu(){
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("\t1.Add book records");
        System.out.println("\t2.Save");
        System.out.println("\t3.Display book records");
        System.out.println("\t4.Exit");
        
        while(true)
        {
            try{
                System.out.print("\t\t(-->)Enter your choice (1-4): ");
                choice = sc.nextInt();  
                return choice;
            }
            catch(InputMismatchException e)
            {
                sc.nextLine();
                System.out.println("\t(!)Nhập số");
            }
        }
    }
    public static void main(String[] args) {
        int chon;
        Scanner sc = new Scanner(System.in);
        BookManager bmng = new BookManager();
        do{
            chon = menu();
            
            switch(chon){
                case 1:
                    System.out.println("\t1.Add book records:");
                    bmng.AddBook();
                    break;
                case 2:
                    System.out.println("\t2.Save:");
                    if(bmng.list.isEmpty()==false)
                        bmng.Save();
                    else
                        System.out.println("List is empty");
                    break;
                case 3:
                    System.out.println("\t3.Display book records:");
                    bmng.doc_file();
                    bmng.DisplayBook();
                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("(!)This function is not available, please choose again");
            }
        }while(chon!=4);
    }
}