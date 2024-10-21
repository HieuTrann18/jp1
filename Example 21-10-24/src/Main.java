import Controller.StudentManagement;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentManagement stm = new StudentManagement();

        Scanner sc = new Scanner(System.in);

        int choose;
        do{
            System.out.println("====Menu====");
            System.out.println("1. Add new student");
            System.out.println("2. Display all student");
            System.out.println("3. Sort student by mark");
            System.out.println("4. Exit");
            System.out.println("Your choose: ");
            choose = sc.nextInt();


            switch(choose){
                case 1:
                    stm.addStudent();
                    break;
                case 2:
                    stm.showStudent();
                    break;
                case 3:
                    stm.sortByMark();
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choose!");
                    break;
            }
        }while(choose != 4);
    }
}