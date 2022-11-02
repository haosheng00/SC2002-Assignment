package Classes;
import java.util.Scanner; 
import java.util.ArrayList;
public class AccountUI {



    /*Created a customer controller object here for practice but need to discuss with team 
    on where it should actually be */
    static AdminController adminPrac = new AdminController();
    static CustomerController custPrac = new CustomerController();

    public void chooseAccountType(){
        System.out.println("MOBLIMA Login");
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Customer: 1");
            System.out.println("Admin: 2");
            System.out.println("Back: 3");
            System.out.println("Choose login account type: ");
            choice = sc.nextInt();
            if(choice == 1){
                initiateCustomerUI();
            }
            else if(choice == 2){
                initiateAdminUI();
            }
            else if(choice == 3) {
                break;
            }
        }while(choice<4);
        sc.close();
    }
    public void initiateCustomerUI(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Please select an option");
            System.out.println("(1) Login to an existing account");
            System.out.println("(2) Create a new account");
            System.out.println("(3) Delete account");
            System.out.println("(4) Change Password");
            System.out.println("(5) back");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    logInCustomer();
                    break;
                case 2:
                    custPrac.addCustomer();
                    break;
                case 3:
                    custPrac.deleteCustomer();
                case 4:
                    custPrac.updateCustomerPassword();
                default:
                    break;
            }
        }while(choice<5);
        sc.close();
    }



    public  void initiateAdminUI(){
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Please select an option");
            System.out.println("(1) Login to an existing account");
            System.out.println("(2) back");
            
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    logInAdmin();
                    break;
                default:
                    break;
            }
        }while(choice<2);
        sc.close();
    }

    public boolean logInCustomer(){
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        int i;
        ArrayList<Customer> arr = custPrac.getCustomerList();
        int quit = 0;
        do{
            System.out.println("Enter username: ");
            username = sc.next();
            System.out.println("Enter password: ");
            password = sc.next();
            i = custPrac.searchCustomer(username);
            if(i==-1){
                System.out.println("username not found");
                System.out.println("If you would like to quit enter 0 else enter 1");
                quit = sc.nextInt();
            }
            else {
                    if(arr.get(i).getPassword() == password){
                    System.out.println("Login Successful");
                    return true;
                    }
                    else{
                        System.out.println("Wrong password. Try again");
                        System.out.println("If you would like to quit enter 0 else enter 1");
                        quit = sc.nextInt();
                    }
                }
        }while(quit!=1);
        sc.close();
        return false;
    }

    public boolean logInAdmin(){
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        int i;
        ArrayList<Admin> arr = adminPrac.getAdminsList();
        int quit = 0;
        do{
            System.out.println("Enter username: ");
            username = sc.next();
            System.out.println("Enter password: ");
            password = sc.next();
            i = adminPrac.searchAdmin(username);
            if(i==-1){
                System.out.println("username not found");
                System.out.println("If you would like to quit enter 0 else enter 1");
                quit = sc.nextInt();
            }
            else {
                    if(arr.get(i).getPassword() == password){
                    System.out.println("Login Successful");
                    return true;
                    }
                    else{
                        System.out.println("Wrong password. Try again");
                        System.out.println("If you would like to quit enter 0 else enter 1");
                        quit = sc.nextInt();
                    }
                }
        }while(quit!=1);
        sc.close();
        return false;
    }
}

