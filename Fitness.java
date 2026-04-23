/**
 * Represents a fitness activity with methods to describe the exercise,
 * identify targeted muscles, and estimate calorie loss.
 */
public interface Fitness {

    /**
     * Returns the muscles targeted by this fitness activity.
     *
     * @return an array of {@link Muscle} areas affected by this exercise
     */
    public Muscle[] muscleTargeted();

    /**
     * Returns the estimated calories burned during this fitness activity.
     *
     * @param intensity the intensity level of the exercise
     * @param weight    the weight of the person in kilograms
     * @param duration  the duration of the exercise in minutes
     * @return the estimated number of calories burned
     */
    public double calorieLoss(Intensity intensity, double weight, int duration);

    /**
     * Returns a description of this fitness activity.
     *
     * @return a string describing the exercise
     */
    public String description();
}