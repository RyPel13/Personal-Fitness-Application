/**
 * Represents a WeightLifting anaerobic exercise activity.
 * WeightLifting targets the Arms, Triceps, Legs, and Shoulders.
 */
public class WeightLifting extends Anaerobic {

    /**
     * Constructs a WeightLifting exercise.
     */
    public WeightLifting() {}

    /**
     * Returns the muscles targeted by WeightLifting.
     * WeightLifting targets: Arms, Triceps, Legs, and Shoulders.
     *
     * @return an array of muscles targeted by WeightLifting
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{ Muscle.Legs, Muscle.Arms, Muscle.Triceps, Muscle.Shoulders };
    }

    /**
     * Returns the estimated calories burned while WeightLifting.
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
            case HIGH:   met = 6.0; break;
            case MEDIUM: met = 5.0; break;
            case LOW:
            default:     met = 3.5; break;
        }
        return met * weight * (duration / 60.0);
    }

    /**
     * Returns the name of this fitness activity.
     *
     * @return the string {@code "WeightLifting"}
     */
    @Override
    public String description() {
        return "WeightLifting";
    }
}