/**
 * Represents a weekly exercise plan for a user, containing a list of fitness exercises,
 * the number of workout days per week, a weekly calorie burn target, and the user's profile.
 */
public class WeeklyExercise {

    private Fitness[] exerciseList;
    private int days;
    private double weeklyCalorieTarget;
    private Profile profile;

    /**
     * Constructs a new WeeklyExercise with the specified attributes.
     *
     * @param exerciseList        the array of Fitness exercises for the week
     * @param days                the number of days the user plans to workout per week
     * @param weeklyCalorieTarget the total amount of calories to be burned per week
     * @param profile             the profile of the user
     */
    public WeeklyExercise(Fitness[] exerciseList, int days, double weeklyCalorieTarget, Profile profile) {
        this.exerciseList = exerciseList;
        this.days = days;
        this.weeklyCalorieTarget = weeklyCalorieTarget;
        this.profile = profile;
    }

    /**
     * Constructs a new WeeklyExercise with a default of 7 workout days
     * and a default weekly calorie target of 3500.
     *
     * @param exerciseList the array of Fitness exercises for the week
     * @param profile      the profile of the user
     */
    public WeeklyExercise(Fitness[] exerciseList, Profile profile) {
        this(exerciseList, 7, 3500, profile);
    }

    /**
     * Adds a new Fitness exercise to the first available null slot in the exerciseList.
     * If no null slot is found, the exerciseList remains unchanged.
     *
     * @param ex the Fitness exercise to add
     */
    public void addExercise(Fitness ex) {
        for (int i = 0; i < exerciseList.length; i++) {
            if (exerciseList[i] == null) {
                exerciseList[i] = ex;
                break;
            }
        }
    }

    /**
     * Removes a Fitness exercise from the exerciseList by setting its slot to null.
     * If the exercise does not exist, the exerciseList remains unchanged.
     *
     * @param ex the Fitness exercise to remove
     */
    public void removeExercise(Fitness ex) {
        for (int i = 0; i < exerciseList.length; i++) {
            if (exerciseList[i] == ex) {
                exerciseList[i] = null;
                break;
            }
        }
    }

    /**
     * Sets the exerciseList of the WeeklyExercise.
     *
     * @param list the new array of Fitness exercises
     */
    public void setExerciseList(Fitness[] list) { this.exerciseList = list; }

    /**
     * Sets the number of days the user plans to workout per week.
     *
     * @param days the new number of workout days
     */
    public void setDays(int days) { this.days = days; }

    /**
     * Sets the weekly calorie burn target.
     *
     * @param target the new weekly calorie target
     */
    public void setWeeklyCalorieTarget(double target) { this.weeklyCalorieTarget = target; }

    /**
     * Sets the profile of the user.
     *
     * @param profile the new {@link Profile} of the user
     */
    public void setProfile(Profile profile) { this.profile = profile; }

    /**
     * Returns the exerciseList of the WeeklyExercise.
     *
     * @return the array of Fitness exercises
     */
    public Fitness[] getExerciseList() { return exerciseList; }

    /**
     * Returns the number of exercises in the exerciseList.
     *
     * @return the number of exercises as an int
     */
    public int getSize() { return exerciseList.length; }

    /**
     * Returns the number of days the user plans to workout per week.
     *
     * @return the number of workout days
     */
    public int getDays() { return days; }

    /**
     * Returns the profile of the user.
     *
     * @return the user's {@link Profile}
     */
    public Profile getProfile() { return profile; }

    /**
     * Returns the weekly calorie burn target.
     *
     * @return the weekly calorie target as a double
     */
    public double getWeeklyCalorieTarget() { return weeklyCalorieTarget; }

    /**
     * Builds a personalised weekly workout plan designed to hit the targeted
     * calorie loss at the specified intensity level.
     * 
     * The weekly calorie target is split equally across each workout day, with
     * one exercise assigned per day. The duration for each session is calculated
     * by determining how many minutes of that exercise are needed to burn the
     * daily calorie share at the given intensity.
     *
     * @param intensity the effort level at which the exercises will be performed
     *                  ({@link Fitness.Intensity#HIGH}, {@link Fitness.Intensity#MEDIUM},
     *                  or {@link Fitness.Intensity#LOW})
     * @return an array of {@link DailyExercise} objects representing the suggested
     *         workout for each day, sized to match the number of workout days
     */
    public DailyExercise[] getWeeklyExercises(Intensity intensity) {
        double dailyCalorie = weeklyCalorieTarget / days;
        DailyExercise[] result = new DailyExercise[days];
        for (int i = 0; i < days; i++) {
            double caloriesPerMinute = exerciseList[i].calorieLoss(intensity, profile.getWeight(), 1);
            double duration = dailyCalorie / caloriesPerMinute;
            Fitness[] dailyList = new Fitness[exerciseList.length];
            dailyList[i] = exerciseList[i];
            result[i] = new DailyExercise(dailyList, (int) duration, dailyCalorie, profile);
        }
        return result;
    }

    /**
     * Returns an array of {@link DailyExercise}s using a default intensity of
     * {@link Fitness.Intensity#LOW}.
     * Delegates to {@link #getWeeklyExercises(Fitness.Intensity)} with LOW intensity.
     *
     * @return an array of {@link DailyExercise} objects, one per workout day
     */
    public DailyExercise[] getWeeklyExercises() {
        return getWeeklyExercises(Intensity.LOW);
    }

    /**
     * Returns a suggestion on how to lose the targeted weight within the specified number of days.
     * Assumes that 7000 calories must be burned to lose 1kg of weight. The suggestion
     * includes the daily calorie loss required and the adjusted daily intake needed
     * to achieve the target weight loss.
     *
     * @param targetWeight the amount of weight in kg the user wants to lose
     * @param withInDays   the number of days within which to achieve the weight loss
     * @return a formatted string suggesting the daily calorie loss and adjusted intake,
     *         or {@code "Only works to lose weight"} if the target weight exceeds the user's actual weight
     */
    public String targetedCalorieLoss(double targetWeight, int withInDays) {
        double totalCaloriesToBurn = targetWeight * 7000;
        double caloriesToBurnPerDay = totalCaloriesToBurn / withInDays;
        double dailyIntake = profile.dailyCalorieIntake();
        double newIntake = dailyIntake - caloriesToBurnPerDay;
        return targetWeight > profile.getWeight() ? "Only works to lose weight" :
            String.format("You need to lose %.2f calories per day or decrease your intake "
                + "from %.2f to %.2f inorder to lose %.2f kg of weight",
                caloriesToBurnPerDay, dailyIntake, newIntake, targetWeight);
    }
}