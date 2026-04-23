/**
 * Represents a daily exercise plan for a user, containing a list of fitness exercises,
 * a workout duration, a calorie burn target, and the user's profile.
 */
public class DailyExercise {

    private Fitness[] exerciseList;
    private int duration;
    private double calorieTarget;
    private Profile profile;

    /**
     * Constructs a new DailyExercise with the specified attributes.
     *
     * @param exerciseList  the array of Fitness exercises for the day
     * @param duration      the number of minutes to workout
     * @param calorieTarget the amount of calories to be burned
     * @param profile       the profile of the user
     */
    public DailyExercise(Fitness[] exerciseList, int duration, double calorieTarget, Profile profile) {
        this.exerciseList = exerciseList;
        this.duration = duration;
        this.calorieTarget = calorieTarget;
        this.profile = profile;
    }

    /**
     * Constructs a new DailyExercise with a default duration of 1 hour and
     * a default calorie target of 500.
     *
     * @param exerciseList the array of Fitness exercises for the day
     * @param profile      the profile of the user
     */
    public DailyExercise(Fitness[] exerciseList, Profile profile) {
        this(exerciseList, 1, 500, profile);
    }

    /**
     * Returns the number of exercises in the exerciseList.
     *
     * @return the number of exercises as an int
     */
    public int getSize() {
        return exerciseList.length;
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
     * Sets the exerciseList of the DailyExercise.
     *
     * @param list the new array of Fitness exercises
     */
    public void setExerciseList(Fitness[] list) { this.exerciseList = list; }

    /**
     * Sets the duration of the DailyExercise.
     *
     * @param duration the new duration in minutes
     */
    public void setDuration(int duration) { this.duration = duration; }

    /**
     * Sets the calorie burn target of the DailyExercise.
     *
     * @param target the new calorie target
     */
    public void setCalorieTarget(double target) { this.calorieTarget = target; }

    /**
     * Sets the profile of the user.
     *
     * @param profile the new Profile of the user
     */
    public void setProfile(Profile profile) { this.profile = profile; }

    /**
     * Returns the exerciseList of the DailyExercise.
     *
     * @return the array of Fitness exercises
     */
    public Fitness[] getExerciseList() { return exerciseList; }

    /**
     * Returns the duration of the DailyExercise.
     *
     * @return the duration in minutes
     */
    public int getDuration() { return duration; }

    /**
     * Returns the calorie burn target of the DailyExercise.
     *
     * @return the calorie target as a double
     */
    public double getCalorieTarget() { return calorieTarget; }

    /**
     * Returns the profile of the user.
     *
     * @return the user's {@link Profile}
     */
    public Profile getProfile() { return profile; }

    /**
     * Returns an array of Fitness exercises from the exerciseList that fulfill
     * all of the target muscle groups the user wants to work on for that specific day.
     * Returns null if no exercise targets all the muscle groups.
     *
     * @param targetMuscle the array of target muscle groups
     * @return an array of matching Fitness exercises, or null if none found
     */
    public Fitness[] getExercises(Muscle[] targetMuscle) {
        int count = 0;
        for (Fitness exercise : exerciseList) {
            if (exercise != null && containsAllMuscles(exercise, targetMuscle)) count++;
        }

        if (count == 0) return null;

        Fitness[] newExercises = new Fitness[count];
        int index = 0;
        for (Fitness exercise : exerciseList) {
            if (exercise != null && containsAllMuscles(exercise, targetMuscle)) {
                newExercises[index] = exercise;
                index++;
            }
        }
        return newExercises;
    }

    /**
     * Helper method that checks if a Fitness exercise targets all the muscles in targetMuscle.
     *
     * @param exercise     the Fitness exercise to check
     * @param targetMuscle the array of muscles to check against
     * @return true if the exercise targets all muscles, false otherwise
     */
    private boolean containsAllMuscles(Fitness exercise, Muscle[] targetMuscle) {
        for (Muscle target : targetMuscle) {
            boolean muscleFound = false;
            for (Muscle muscle : exercise.muscleTargeted()) {
                if (muscle.equals(target)) {
                    muscleFound = true;
                    break;
                }
            }
            if (!muscleFound) return false;
        }
        return true;
    }

    /**
     * Searches the exerciseList and returns any exercises that work on at least
     * one of the specified muscle groups. Unlike {@link #getExercises(Fitness.Muscle[])},
     * a partial match is sufficient — the exercise does not need to target every
     * muscle in the list.
     *
     * @param targetMuscle the array of target muscle groups to search for
     * @return an array of Fitness exercises that match at least one target muscle,
     *         or null if no matches are found
     */
    public Fitness[] getAllExercises(Muscle[] targetMuscle) {
        int count = 0;
        for (Fitness exercise : exerciseList) {
            if (exercise != null && containsAnyMuscles(exercise, targetMuscle)) count++;
        }

        if (count == 0) return null;

        Fitness[] newExercises = new Fitness[count];
        int index = 0;
        for (Fitness exercise : exerciseList) {
            if (exercise != null && containsAnyMuscles(exercise, targetMuscle)) {
                newExercises[index] = exercise;
                index+=1;
            }
        }
        return newExercises;
    }

    /**
     * Helper method that checks if a Fitness exercise targets any of the muscles in targetMuscle.
     *
     * @param exercise     the Fitness exercise to check
     * @param targetMuscle the array of muscles to check against
     * @return true if the exercise targets at least one muscle, false otherwise
     */
    private boolean containsAnyMuscles(Fitness exercise, Muscle[] targetMuscle) {
        for (Muscle target : targetMuscle) {
            for (Muscle muscle : exercise.muscleTargeted()) {
                if (muscle.equals(target)) {
                    return true;
                }
            }
        }
        return false;
    }
}