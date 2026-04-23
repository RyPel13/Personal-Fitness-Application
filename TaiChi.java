/**
 * Represents a Tai Chi flexibility exercise activity.
 * Tai Chi targets the Arms and Legs.
 */
public class TaiChi extends Flexibility {

    /**
     * Constructs a TaiChi exercise.
     */
    public TaiChi() {}

    /**
     * Returns the muscles targeted by Tai Chi.
     * Tai Chi targets: Legs and Arms.
     *
     * @return an array of muscles targeted by Tai Chi
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{ Muscle.Legs, Muscle.Arms};
    }

    /**
     * Returns the estimated calories burned while doing Tai Chi.
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
            case HIGH:   met = 5.0; break;
            case MEDIUM: met = 3.0; break;
            case LOW:
            default:     met = 1.5; break;
        }
        return met * weight * (duration / 60.0);
    }

    /**
     * Returns the name of this fitness activity.
     *
     * @return the string {@code "TaiChi"}
     */
    @Override
    public String description() {
        return "TaiChi";
    }
}