/**
 * Represents a pull-up endurance exercise activity.
 * Pull-ups target the Biceps and Arms.
 */
public class PullUp extends Endurance {

    /**
     * Constructs a PullUp exercise.
     */
    public PullUp() {}

    /**
     * Returns the muscles targeted by pull-ups.
     * Pull-ups target: Biceps and Arms.
     *
     * @return an array of muscles targeted by pull-ups
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{ Muscle.Biceps, Muscle.Arms};
    }

    /**
     * Returns the estimated calories burned while doing pull-ups.
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
            case HIGH:   met = 7.5; break;
            case MEDIUM: met = 6.0; break;
            case LOW:
            default:     met = 4.8; break;
        }
        return met * weight * (duration / 60.0);
    }

    /**
     * Returns the name of this fitness activity.
     *
     * @return the string {@code "PullUp"}
     */
    @Override
    public String description() {
        return "PullUp";
    }
}