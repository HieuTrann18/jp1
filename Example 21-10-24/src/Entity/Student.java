package Entity;

import IGeneral.IStudent;

import java.util.Scanner;

public class Student implements IStudent {
    private int id;
    private String name;
    private String email;
    private float mark;

    public Student() {
    }

    public Student(int id, String name, String email, float mark) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id: ");
        this.id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the name: ");
        this.name = scanner.nextLine();

        System.out.println("Enter the email: ");
        this.email = scanner.nextLine();

        System.out.println("Enter the mark: ");
        this.mark = scanner.nextFloat();
    }

    @Override
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Mark: " + mark);
    }
}
