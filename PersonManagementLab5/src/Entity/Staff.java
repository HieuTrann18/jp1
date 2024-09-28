package Entity;

public class Staff extends Person {
    private String id;
    private String school;
    private double pay;
    private Gender gender;
    public Staff(){}

    public Staff(String id, String name, String address, Gender gender , String school, double pay) {
        super(name, address);
        this.id = id;
        this.gender = gender;
        this.school = school;
        this.pay = pay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public void setName(String name){
        super.setName(name);
    }
    @Override
    public String getAddress(){
        return super.getAddress();
    }
    @Override
    public void setAddress(String address){
        super.setAddress(address);
    }


    @Override
    public String toString() {
        return "Staff{" +
                " id=" + id + '\'' +
                ", school='" + school +
                ", name=" + this.getName() +
                ", address=" + this.getAddress() +
                ", pay=" + pay +
                ", gender=" + gender +
                '}';
    }


}
