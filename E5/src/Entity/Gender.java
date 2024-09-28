package Entity;

public enum Gender {
    MALE("Male"), FEMALE("Female"), Other("Other");
    private String GenderLabel;
    public String getGenderLabel() {
        return this.GenderLabel;
    }
    Gender(String GenderLabel) {
        this.GenderLabel = GenderLabel;
    }

}
