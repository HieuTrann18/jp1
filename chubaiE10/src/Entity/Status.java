package Entity;

public enum Status {
    PENDING("Pending"),
    PAID("Paid"),
    COMPLETED("Completed"),
    CANCELED("Cancel");

    private final String labelStatus;

    private Status(String labelStatus){
        this.labelStatus = labelStatus;
    }

    public String getLabelStatus(){
        return labelStatus;
    }

}
