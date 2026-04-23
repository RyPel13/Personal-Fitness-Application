public class Profile {

    private int age;
    private double height;
    private double weight;
    private Gender gender;

    /**
     * Constructs a new Profile with the specified attributes.
     *
     * @param age    the age of the user in years
     * @param height the height of the user in metres
     * @param weight the weight of the user in kilograms
     * @param gender the gender of the user ({@link Gender#MALE} or {@link Gender#FEMALE})
     */
    public Profile(int age, double height, double weight, Gender gender) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    /**
     * Sets the height of the user.
     *
     * @param height the new height in metres
     */
    public void setHeight(double height) { this.height = height; }

    /**
     * Sets the weight of the user.
     *
     * @param weight the new weight in kilograms
     */
    public void setWeight(double weight) { this.weight = weight; }

    /**
     * Sets the age of the user.
     *
     * @param age the new age in years
     */
    public void setAge(int age) { this.age = age; }

    /**
     * Sets the gender of the user.
     *
     * @param gender the new gender ({@link Gender#MALE} or {@link Gender#FEMALE})
     */
    public void setGender(Gender gender) { this.gender = gender; }

    /**
     * Returns the height of the user.
     *
     * @return height in metres
     */
    public double getHeight() { return height; }

    /**
     * Returns the weight of the user.
     *
     * @return weight in kilograms
     */
    public double getWeight() { return weight; }

    /**
     * Returns the age of the user.
     *
     * @return age in years
     */
    public int getAge() { return age; }

    /**
     * Returns the gender of the user.
     *
     * @return {@link Gender#MALE} or {@link Gender#FEMALE}
     */
    public Gender getGender() { return gender; }

    /**
     * Returns a string representation of this profile.
     * 
     * @return formatted string describing the user's profile
     */
    @Override
    public String toString() {
        return String.format("Age %d, Weight %.1fkg, Height %.1fm, Gender %s",
                age, weight, height, gender);
    }

    /**
     * Calculates and returns the Body Mass Index (BMI) of the user.
     *
     * @return the BMI value as a double
     */
    public double calcBMI() {
        return weight / (height * height);
    }

    /**
     * Calculates and returns the Total Daily Energy Expenditure (TDEE).
     *
     * @return the estimated daily calorie intake as a double
     * @throws IllegalStateException if the gender value is unrecognized
     */
    public double dailyCalorieIntake() {
        double heightCm = height * 100;
        switch (gender) {
            case MALE:
                return 66.47 + (13.75 * weight) + (5.003 * heightCm) - (6.755 * age);
            case FEMALE:
                return 655.1 + (9.563 * weight) + (1.85 * heightCm) - (4.676 * age);
            default:
                throw new IllegalStateException("Unknown gender: " + gender);
        }
    }
}