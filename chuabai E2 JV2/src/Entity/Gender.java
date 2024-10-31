package Entity;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    Other("Other");

    private String gender;
    Gender(String gender){
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
