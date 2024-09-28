package Entity;

public enum Gender {
    MALE("Male"), FEMALE("Female"), Other("Other");
    private String genderLabel;
    public String getGenderLabel() {
        return this.genderLabel;
    }
    Gender(String genderLabel) {
        this.genderLabel = genderLabel;
    }
}
