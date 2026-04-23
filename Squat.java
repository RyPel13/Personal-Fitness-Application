/**
 * Represents a squat endurance exercise activity.
 * Squats target the Glutes, Back, and Abs.
 */
public class Squat extends Endurance {

    /**
     * Constructs a Squat exercise.
     */
    public Squat() {}

    /**
     * Returns the muscles targeted by squats.
     * Squats target: Glutes, Back, and Abs.
     *
     * @return an array of muscles targeted by squats
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{ Muscle.Glutes, Muscle.Back, Muscle.Abs };
    }

    /**
     * Returns the estimated calories burned while doing squats.
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
            case HIGH:   met = 7.0; break;
            case MEDIUM: met = 5.0; break;
            case LOW:
            default:     met = 2.5; break;
        }
        return met * weight * (duration / 60.0);
    }

    /**
     * Returns the name of this fitness activity.
     *
     * @return the string {@code "Squat"}
     */
    @Override
    public String description() {
        return "Squat";
    }
}