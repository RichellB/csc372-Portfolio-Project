import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Driver class
public class Main implements Serializable {

    // Custom selection sort method
    private static <T> void selectionSortNew(List<T> list, Comparator<T> comparator) {
        int listSize = list.size();

        for (int i = 0; i < listSize - 1; i++) {
            int min = i;
            for (int j = i + 1; j < listSize; j++) {
                if (comparator.compare(list.get(j), list.get(min)) < 0) {
                    min = j;
                }
            }

            if (min != i) {
                T temp = list.get(i);
                list.set(i, list.get(min));
                list.set(min, temp);
            }
        }
    }

    public static void main(String[] args) {

        // Declaring variables
        Scanner NameInput = new Scanner(System.in);
        Scanner AddressInput = new Scanner(System.in);
        Scanner GPAInput = new Scanner(System.in);
        double stdGPAInput = 0.0;


        // Creating LinkedList to store Student objects
        List<StudentData> studentList = new LinkedList<>();

        // Accepting student data from user
        System.out.println("\nWelcome to StudentData! You can enter data for 5 students.\n");

        for (int i=1; i<=5; i++) {
            System.out.println("\n\nPlease enter the new student's information below: \n");


            System.out.println("Name: ");
            String stdNameInput = NameInput.nextLine();

            System.out.println("Address: ");
            String stdAddressInput = AddressInput.nextLine();

            try {
                System.out.println("GPA: ");
                stdGPAInput = GPAInput.nextDouble(); 
            } catch (InputMismatchException e) {
                // Validating grade entries
                System.out.println("Enter only numbers for grades. Please try again!");
                break;
            }
            
            // Creating student instance and adding it to the linked list
            StudentData std = new StudentData(stdNameInput, stdAddressInput, stdGPAInput);
            studentList.add(std);
        }

        // Calling the selectionSort method with the list and student name comparator
        selectionSortNew(studentList, StudentDataNameComparator.StuDataNameComparator);


        // Writing student data to file
        try {
            FileOutputStream fos = new FileOutputStream ("StudentData.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList.toString());
            fos.close();

            System.out.println("\nThank You!\nThe student data has been sorted and saved to a file!"); 
        } 
        catch (IOException e) {
            // Handling exception
            System.out.println("File creation failed. Please try again!"); 
        }

    }

}
