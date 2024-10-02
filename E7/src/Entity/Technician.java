package Entity;

public class Technician extends Staff{
    private double overtimePay;

    public Technician(){}

    public Technician(String name, double salary, double overtimePay){
        super(name,salary);
        this.overtimePay = overtimePay;
    }

    public double getOvertime() {
        return overtimePay;
    }

    public void setOvertime(double overtimePay) {
        this.overtimePay = overtimePay;
    }

    @Override
    public  double getPaid(){
        return super.getSalary() + overtimePay;
    }


    @Override
    public String toString() {
        return "Technician{" +
                "name=" + this.getName() +
                ", salary=" + this.getSalary() +
                ", overtime=" + this.getOvertime() +
                ", paid=" + this.getPaid() +
                '}';
    }
}
