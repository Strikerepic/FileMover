import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Transport{
    public static void main(String[] args) {
        clearSc();
        int counter = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("File Path For Closed Files WITH \\");
        String closedLoc = sc.nextLine();

        System.out.println("Number After File");
        String boxNum = sc.nextLine();

        boolean again = true;
        
        System.out.println("\n\n\n\n\n\n\n\n");
        System.out.flush();
        clearSc();

        

        while(again) {

            System.out.print("Tranfer Location:    ");
            System.out.println(closedLoc);
            System.out.print("Box Number:   ");
            System.out.println(boxNum);
            System.out.println("==================================================================================");

            System.out.println("File Name:");
            String name = sc.nextLine();
            File temp = new File(name);
            
            while(!temp.exists()){
                System.out.println("\nCouldnt Locate File With that name\nFile Name:");
                name = sc.nextLine();
                temp = new File(name);
                System.out.println(temp.exists());
            }

            System.out.println("\n\n\n\n\n\n\n\n");
            System.out.flush();
            clearSc();
            System.out.println("File Succesfully Loacted!");
            System.out.println("==========================");
            

            System.out.print("File To Be Moved:     ");
            System.out.println(temp.getAbsolutePath());


            File dest = new File(closedLoc + "\\" + name+" Box "+ boxNum);
            System.out.print("New Loaction + Rename:      ");
            System.out.println(dest.getAbsolutePath());


            System.out.println("Y to Continue\nN to Cancel");
            String dec = sc.nextLine();

            boolean isValidDec = false;
            boolean forward = false;

            while(!isValidDec) {
                if(dec.equals("y") || dec.equals("Y")) {
                    isValidDec = true;
                    forward = true;
                } else if(dec.equals("N") || dec.equals("n")) {
                    isValidDec = true;
                }  else {
                    System.out.println("Improper Command.\nY to Continue\nN to Cancel");
                    dec = sc.nextLine();
                }
            }

            if(forward) {

                if(temp.renameTo(dest)) {
                    System.out.println("Success: File Was Renamed and Moved");
                    counter++;
                } else {
                    System.out.println("FAULT: Error occured in File Movement-------------------------------------------------");
                }
            } else {
                System.out.println("Previous Action Canceled");
            }


            System.out.println("Press Enter to Go Again. Type 1 To Change Box Num. Anything Else To Exit:");
            String act = sc.nextLine();

            if(act.equals("1")) {
                System.out.println("\n\n\n\n\n\n\n\n");
                System.out.flush();
                clearSc();

                System.out.println("=================================");
                System.out.println("Enter New Box Number:");
                boxNum = sc.nextLine();
            } else if(act.equals("")) {
                again = true;
            } else {
                again = false;
            } 
            System.out.println("\n\n\n\n\n\n\n\n");
            System.out.flush();
            clearSc();
        }


        System.out.println("You closed: " + counter + " files! Good Work!");

    }



    public static void clearSc()  {



        try {
            new ProcessBuilder("cmd","/c", "cls").inheritIO().start().waitFor();
        } catch(Exception e) {
            System.out.println(e);
        }

    }



}