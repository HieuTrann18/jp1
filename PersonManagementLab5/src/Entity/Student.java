package Entity;

import java.time.LocalDate;

public class Student extends Person {
    private String id;
    private LocalDate dob;
    private double fee;
    private Gender gender;

    public Student(){}
    public Student(String id, String name, LocalDate dob, Gender gender, String address){
        super(name, address);
        this.id = id;
        this.dob = dob;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public void setName(String name){
        super.setName(name);
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

   public int getAge(){
        return Math.abs(LocalDate.now().getYear() - this.getDob().getYear());
   }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name=" + this.getName() +
                ", dob=" + dob +
                ", age=" + this.getAge() +
                ", fee=" + fee +
                ", gender=" + gender +
                ", address=" + this.getAddress() +
                '}';
    }
}
