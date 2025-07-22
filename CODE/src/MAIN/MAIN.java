package MAIN;

import AIROPLANE.*;
import BUS.*;
import SIGN_UP_LOG_IN.*;
import TRAINLINE.*;

import java.lang.reflect.Array;
import java.util.*;


public class MAIN {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> mobileNumbers = new ArrayList<>();
    static ArrayList<String> emails = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();

    public static void main(String[] args)throws Exception {
        System.out.println("Already Have An Account!!!\nThan Press 1 For Sign_in");
        System.out.println("New User... \nThan Press 2 For Log_In");


        int choise= sc.nextInt();
        switch (choise){
            case 1:
            {
                VALIDITY.sign_in();
                sc.nextLine();
                System.out.println("You Want To Log_In?");
                System.out.println("YES  "+" NO  " );
                String Boolean=sc.nextLine();
                Boolean=Boolean.trim().toUpperCase();
                if(Boolean.equals("NO")){
                    System.out.println("Exiting.....");
                    break;
                }

            }
            case 2:
            {
                VALIDITY.login();
                int input;
                do{
                    System.out.println("Press 1 for Flight Booking");
                    System.out.println("Press 2 for Train Booking");
                    System.out.println("Press 3 for Bus Booking ");
                    System.out.println("Press 4 for Exit !");
                    input= sc.nextInt();

                        switch (input) {
                            case 1: {
                                AIRLINE.run();
                                break;
                            }
                            case 2: {
                                TRAINLINE.run();
                                break;
                            }
                            case 3: {
                                BUSLINE.run();
                                break;
                            }
                            case 4:{
                                System.out.println("Existing.....");
                                break;
                            }
                            default:{
                                System.out.println("Enter Valid Choice !!!");
                            }

                         }
                }while (input!=4);
                break;
            }

            default:
            {
                System.out.println("Enter Valid Choice !!!");
            }
        }
    }
}








