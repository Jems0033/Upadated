package AIROPLANE;
import MAIN.MAIN;
import connection.*;

import java.sql.*;
import java.util.*;

public class AIRLINE  {
    static PreparedStatement pst;

static Scanner sc=new Scanner(System.in);
    public static void run() throws Exception{
        Connection con=CONNECTION.connection();
        Statement st=con.createStatement();
        System.out.println("Press 1 for Domestic Flight Booking");
        System.out.println("Press 2 for International Flight Booking");
        int choise=sc.nextInt();
        sc.nextLine();
        switch (choise){

            case 1:
            {

                System.out.println("Enter Location of Your Origin");
                String Origin=sc.nextLine();
                Origin=Origin.trim().toUpperCase();
                System.out.println("Enter Locationn of Your Destination");
                String Destination= sc.nextLine();
                Destination=Destination.trim().toUpperCase();
                String Dom_ID="select Domestic_ID from domestic_flights where Origin=? and Destination=?";
                PreparedStatement  pst= con.prepareCall(Dom_ID);
                pst.setString(1,Origin);
                pst.setString(2,Destination);
                pst.executeQuery();
                ResultSet ID=pst.getResultSet();
                int DomesticID=0;
                while (ID.next()) {
                    DomesticID = ID.getInt(1);
                    if(DomesticID==0){
                        System.out.println("Sorry for The Inconvenience!");
                        System.out.println("Looks like there are no flights available right now.\n" +
                                "You can try other dates or routes — we’re here to help you book your trip!\n");
                    }
                }
                String Details = "select * from df_details where Domestic_ID=?";
                pst=con.prepareStatement(Details);
                pst.setInt(1,DomesticID);
                ResultSet flightDetails = pst.executeQuery();

                while (flightDetails.next()){
                    System.out.println("\n---------------------------------------------------------\n");
                    //System.out.println("Domestic Id ==>"+flightDetails.getInt(1));
                    System.out.println("Plane Id ==>> "+flightDetails.getInt(2));
                    System.out.println("Flight Company ==>> "+flightDetails.getString(3));
                    System.out.println("Starting Time ==>> "+flightDetails.getTime(4));
                    System.out.println("Reaching Time ==>> "+flightDetails.getTime(5));
                    System.out.println("Duration ==>> "+flightDetails.getTime(6));
                    System.out.println("Price ==>> "+flightDetails.getDouble(7));
                    System.out.println("Date of Flight ==>> "+flightDetails.getDate(8));
                    System.out.println("\n---------------------------------------------------------\n");
                }

                break;
            }
            case 2:
            {
                break;
            }
            default:
                System.out.println("Enter Valid Choice !!!");

        }



    }

}
