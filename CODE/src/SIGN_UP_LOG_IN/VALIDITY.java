package SIGN_UP_LOG_IN;

import java.util.*;

public class VALIDITY {
    static ArrayList<String> mobileNumbers = new ArrayList<>();
    static ArrayList<String> emails = new ArrayList<>();
    static ArrayList<String> passwords=new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void sign_in(){

        System.out.print("\n---------------------------------------------------------\nEnter first name: ");
        String f = sc.next().trim().toUpperCase();
        System.out.print("Enter Last name: ");
        String l = sc.next().trim().toUpperCase();


        boolean exit = true;
        String mobileNumber="";
        while (exit) {
            boolean status = true;
            System.out.print("Enter Mobile Number: ");
            mobileNumber = sc.next().trim();
            for (int i = 0; i < mobileNumbers.size() - 1; i++) {
                if (mobileNumber.contains(mobileNumber)) {
                    System.out.println("\n---------------------------------------------------------\n" +
                            "Mobile Number already exist\nPlease try again...\n---------------------------------------------------------\n");
                    status = false;
                    break;
                } else {
                    status = true;
                }
            }
            if (status) {
                if (mobileNumber.length() == 10) {
                    if (mobileNumber.startsWith("9") || mobileNumber.startsWith("8") || mobileNumber.startsWith("7") || mobileNumber.startsWith("6")) {
                        for (int i = 1; i < mobileNumber.length(); i++) {
                            if (mobileNumber.charAt(i) >= '0' && mobileNumber.charAt(i) <= '9') {
                                status = false;
                            } else {
                                System.out.println("\n---------------------------------------------------------\n" +
                                        "Invalid Mobile Number\nPlease try again...\n---------------------------------------------------------\n");
                                status = true;
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("\n---------------------------------------------------------\n" +
                                "Invalid Mobile Number\nPlease try again...\n---------------------------------------------------------\n");
                        status = true;
                    }
                } else {
                    System.out.println("\n---------------------------------------------------------\n" +
                            "Invalid Mobile Number\nPlease try again...\n---------------------------------------------------------\n");
                    status = true;
                }
                if (status) {
                    continue;
                } else {
                    exit = false;
                }
            } else {
                continue;
            }
        }
        mobileNumbers.add(mobileNumber);

        while (!exit) {
            System.out.print("Enter Birth Date (mm/dd/yyyy): ");
            String birthDate = sc.next().trim();
            if (new VALIDITY().ValidDate(birthDate)) {
                exit = true;
            } else {
                System.out.println("\n---------------------------------------------------------\n" +
                        "Invalid Date\nPlease try again...\n---------------------------------------------------------\n");
                continue;
            }
        }
        String email="";
        while (exit) {
            boolean status = true;
            boolean isValid = false;
            System.out.print("Enter Email-Id: ");

            email = sc.next().trim();

            for (int i = 0; i < emails.size() - 1; i++) {
                if (emails.contains(email)) {
                    System.out.println("\n---------------------------------------------------------\n" +
                            "Email already exist\nPlease try again...\n---------------------------------------------------------\n");
                    status = false;
                    break;
                } else {
                    status = true;
                }
            }
            if (status) {
                if (email.contains("@") && email.contains(".com")) {
                    int at = email.indexOf("@");
                    int dot = email.lastIndexOf(".");
                    if (dot <= at) {
                        System.out.println("\n---------------------------------------------------------\n" +
                                "Format: abc@xyz.com\nPlease try again...\n---------------------------------------------------------\n");
                        continue;
                    } else {
                        for (int i = 0; i < email.length(); i++) {
                            if (i == at || i == dot) {
                                continue;
                            } else if ((email.charAt(i) >= 'a' && email.charAt(i) <= 'z')
                                    || (email.charAt(i) >= '0' && email.charAt(i) <= '9')) {
                                isValid = true;
                            } else {
                                isValid = false;
                                break;
                            }
                        }
                    }
                    if (isValid) {
                        exit = false;
                        break;
                    } else {
                        System.out.println("\n---------------------------------------------------------\n" +
                                "Format: abc@xyz.com\nPlease try again...\n---------------------------------------------------------\n");
                        continue;
                    }
                } else {
                    System.out.println("\n---------------------------------------------------------\n" +
                            "Format: abc@xyz.com\nPlease try again...\n---------------------------------------------------------\n");
                    continue;
                }
            } else {
                continue;
            }

        }
        emails.add(email);
        String password = "";

        while (!exit) {
            System.out.print("Enter Password: ");
            password = sc.next().trim();
            if (password.length() >= 6) {
                exit = true;
            } else {
                System.out.println("\n---------------------------------------------------------\n" +
                        "Password should be minimum 6 characters\nPlease try again...\n---------------------------------------------------------\n");
                continue;
            }
        }
        passwords.add(password);

        while (exit) {
            System.out.print("Confirm Password: ");
            String confirmPassword = sc.next().trim();
            if (confirmPassword.equals(password)) {
                System.out.println("\n---------------------------------------------------------\n" +
                        "Signup Successful\n---------------------------------------------------------\n");
                exit = false;
            } else {

                System.out.println("\n---------------------------------------------------------\nPassword does not match\nPlease try again...\n---------------------------------------------------------\n");
                continue;
            }
        }
        //login();
    }



boolean ValidDate(String date) {
    if (date.length() != 10) {
        return false;
    }
    if (date.charAt(2) != '/' || date.charAt(5) != '/') {
        return false;
    }
    String monthStr = date.substring(0, 2);
    String dayStr = date.substring(3, 5);
    String yearStr = date.substring(6, 10);
    if (!isNumber(yearStr) || !isNumber(monthStr) || !isNumber(dayStr)) {
        return false;
    }
    int day = toInt(dayStr);
    int month = toInt(monthStr);
    int year = toInt(yearStr);
    if (year > 2007 ) {
        System.out.println("\n---------------------------------------------------------\n" +
                "You are not eligible for this service\n---------------------------------------------------------");
        return true;
    }
    if (year > 2007  || month < 1 || month > 12) {
        return false;
    }
    int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if (month == 2 && isLeapYear(year)) {
        daysInMonth[1] = 29;
    }
    return day >= 1 && day <= daysInMonth[month - 1];
}

boolean isNumber(String str) {

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
    }

int toInt(String str) {
    int result = 0;
    for (int i = 0; i < str.length(); i++) {
        result = result * 10 + (str.charAt(i) - '0');
    }
    return result;
}

boolean isLeapYear(int year) {
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        return true;
    } else {
        return false;
    }
}

boolean isValidTicketDate(String date) {
    if (date.length() != 10) {
        return false;
    }
    if (date.charAt(2) != '/' || date.charAt(5) != '/') {
        return false;
    }
    String monthStr = date.substring(0, 2);
    String dayStr = date.substring(3, 5);
    String yearStr = date.substring(6, 10);
    if (!isNumber(yearStr) || !isNumber(monthStr) || !isNumber(dayStr)) {
        return false;
    }
    int day = toInt(dayStr);
    int month = toInt(monthStr);
    int year = toInt(yearStr);
    if (year != 2025 || month < 1 || month > 2) {
        return false;
    }
    int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if (month == 2 && isLeapYear(year)) {
        daysInMonth[1] = 29;
    }
    if (month == 2) {
        return day >= 23 && day <= daysInMonth[month - 1];
    } else if (month == 3) {
        return day >= 1 && day <= daysInMonth[month - 1];
    } else {
        return false;
    }
}

public static boolean login() {
    boolean status = true;
    while (status){
        System.out.print("\n---------------------------------------------------------\nEnter Email-Id: ");
        String emailId = sc.next().trim();
        System.out.print("Enter password: ");
        String pass = sc.next().trim();
        for (int i = 0; i < emails.size(); i++) {
            if (passwords.contains(pass) && emails.contains(emailId)) {
                System.out.println("\n---------------------------------------------------------\n" +
                        "Login Successful\n---------------------------------------------------------");
                //accountNumber = i;
                status = false;
                break;
            }
        }
        if (status) {
            System.out.println("\n---------------------------------------------------------\n" +
                    "Invalid Email-Id or Password\nPlease try again...\n---------------------------------------------------------\n");

        }

    }return status;




    }
}


