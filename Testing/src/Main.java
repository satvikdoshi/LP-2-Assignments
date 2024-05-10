import java.util.Scanner;

public class Main {

    String userName;
    int threshold = 3;
    int age;
    Scanner sc = new Scanner(System.in);

    public void input(){
        System.out.println("Enter Name: ");
        userName = sc.next();
        System.out.println("Enter age: ");
        age = sc.nextInt();
    }

    public void medSymptoms(){
        System.out.println("Tell the symptoms from following: ");
        System.out.println("1. Cough \n 2. Itchiness \n 3. Headache");
        int choice = sc.nextInt();
        System.out.println("Do you have any other symptoms: [yes/no]");
        String other = sc.next();
        if(other.equalsIgnoreCase("no")){
            switch (choice){
                case 1:
                    System.out.println("Take Medicine: " + "cofsils orange Lozenges strip of 10");
                    break;
                case 2:
                    System.out.println("Take Medicine: " + "Aspirin");
                    break;
                case 3:
                    System.out.println("Take Medicine: " + "Acetaminophen");
                    break;
            }
        }else{
            int count = 0;
            System.out.println("Describe the other symptoms from :  ( Fever , Nose running ,  headache ) ");
            other = sc.nextLine();

            if(other.contains("fever")){
                count++;
            }
            if(other.contains("Nose running")){
                count++;
            }
            if(other.contains("headache")){
                count++;
            }
            if(threshold == 3){
                System.out.println("You have Influenza (flu), Take Rest, Take water regularly, hydration maintain");
            }else{
                System.out.println("Take Medicine:  Aspirin");
            }

        }
    }

    public void diabetesCheck(){

    }
}