/**
 * @author eddy ayuketah
 * @Description 

 */
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
        //Create list of contacts
        static ArrayList<Contact> contactList=new ArrayList<Contact>();
        public static void main(String[] args) {

                Scanner sc=new Scanner(System.in);
                int choice=0;
                //Loop until user quits
                while(choice!=7)
                {
                        System.out.print("Address Book Operations: \n\t1) Add\n\t2) Remove\n\t3) Save\n\t4) Load\n\t5) Display All\n\t6) Search\n\t7) Exit\nSelect an option(number): ");
                        choice=sc.nextInt();sc.nextLine();
                        switch(choice)
                        {
                        //Add a contact
                        case 1:
                                System.out.print("Enter contact first name: ");
                                String firstName=sc.nextLine();
                                System.out.print("Enter contact last name: ");
                                String lastName=sc.nextLine();
                                System.out.print("Enter contact number: ");
                                String phoneNumber=sc.nextLine();
                                Contact contact=checkIfContactExists(phoneNumber);
                                if(contact!=null)
                                        System.out.println("Contact already exists and cannot be added.");
                                else
                                {
                                        System.out.print("Enter contact address: ");
                                        String address=sc.nextLine();
                                        System.out.print("Enter contact email address: ");
                                        String emailAdd_=sc.nextLine();
                                        contact=new Contact(firstName, lastName, phoneNumber, address, emailAdd_);
                                        contactList.add(contact);
                                        System.out.println("Contact added!");
                                }
                                break;
                        //Remove a contact
                        case 2:
                                System.out.print("Enter contact phone: ");
                                phoneNumber=sc.nextLine();
                                contact=checkIfContactExists(phoneNumber);
                                if(contact==null)
                                        System.out.println("Contact not found");
                                else
                                        contactList.remove(contact);
                                break;
                        //Save a contact
                        case 3:
                                writeToFile();
                                System.out.println("Contacts saved in AddressBook.bin");
                                break;
                        case 4:
                        //Load contacts from file
                                loadContacts();
                                break;
                        //Display contacts
                        case 5:
                                System.out.println("Contact Info:\n------------");
                                for(Contact cont:contactList)
                                {
                                        System.out.println(cont.toString());
                                }
                                break;
                        //Search a contact by search string
                        case 6:
                                System.out.print("Enter a seach string: ");
                                String searchStr=sc.nextLine();
                                boolean contactFound=false;
                                for(Contact cont:contactList)
                                {
                                        if(cont.toString().contains(searchStr))
                                        {
                                                System.out.println(cont.toString());
                                                contactFound=true;
                                        }
                                }
                                if(!contactFound)
                                        System.out.println("No contact found!");
                                break;
                        //Write contacts to file
                        case 7:
                                writeToFile();
                                System.out.println("Program has  ended!");
                                break;
                        default:
                                System.out.println("Invalid choice!");
                        }

                }

                sc.close();
        }
        //Return the contact if its present in the list
       /**
        * 
        * @param phone
        * @return contact
        */
        private static Contact checkIfContactExists(String phone) {

                for(Contact contact:contactList)
                {
                        if(contact.getPhoneNumber().equalsIgnoreCase(phone))
                                return contact;
                }
                return null;
        }
        //Write contacts to file
        private static void writeToFile() {
                FileOutputStream fileoutPS;
                ObjectOutputStream outpuS;

                try {
                        fileoutPS = new FileOutputStream("AddressBook.bin");
                        outpuS = new ObjectOutputStream(fileoutPS);
                        for(Contact contact:contactList)
                        {
                                outpuS.writeObject(contact);
                        }
                        outpuS.close();
                        fileoutPS.close();
                }
                catch (IOException e) {
                        System.out.println("Error writing file");
                }
        }
        //Load contacts from file
        private static void loadContacts() {
                contactList=new ArrayList<Contact>();
                FileInputStream fileIsStr;
                try {
                        fileIsStr = new FileInputStream("AddressBook.bin");
                        boolean cont = true;
                        ObjectInputStream input = new ObjectInputStream(fileIsStr);
                        while (cont) {
                                try {

                                        Contact obj = (Contact) input.readObject();
                                        if (obj != null) {
                                                contactList.add(obj);
                                        } else {
                                                cont = false;
                                        }
                                }
                                catch (EOFException e) {
                                        System.out.println("Contacts loaded!");
                                        break;
                                }catch (IOException e) {
                                        System.out.println("Contacts loaded!");
                                        break;
                                } catch (ClassNotFoundException e) {
                                        System.out.println("Class not found");
                                }
                        }
                } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                } catch (IOException e1) {
                        e1.printStackTrace();
                } 

        }


}