/**
 * Represents a yoga flexibility exercise activity.
 * Yoga targets the Triceps and Biceps.
 */
public class Yoga extends Flexibility {

    /**
     * Constructs a Yoga exercise.
     */
    public Yoga() {}

    /**
     * Returns the muscles targeted by yoga.
     * Yoga targets: Triceps and Biceps.
     *
     * @return an array of muscles targeted by yoga
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{ Muscle.Triceps, Muscle.Biceps};
    }

    /**
     * Returns the estimated calories burned while doing yoga.
     * Uses MET (metabolic equivalent) values based on intensity:
     * 
     * @param intensity the intensity level (HIGH, MEDIUM, LOW)
     * @param weight    the weight of the person in kilograms
     * @param duration  the duration of the exercise in minutes
     * @return the estimated calories burned
     */
    @Override
    public double calorieLoss(Intensity intensity, double weight, int duration) {
        double met;
        switch (intensity) {
            case HIGH:   met = 4.0; break;
            case MEDIUM: met = 3.0; break;
            case LOW:
            default:     met = 2.0; break;
        }
        return met * weight * (duration / 60.0);
    }

    /**
     * Returns the name of this fitness activity.
     *
     * @return the string {@code "Yoga"}
     */
    @Override
    public String description() {
        return "Yoga";
    }
}