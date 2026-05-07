/**
 * Represents a plyometrics anaerobic exercise activity.
 * Plyometrics targets the Legs, Glutes, and Glutes.
 */
public class Plyometrics extends Anaerobic {

    /**
     * Constructs a Plyometrics exercise.
     */
    public Plyometrics() {}

    /**
     * Returns the muscles targeted by plyometrics.
     * Plyometrics targets: Legs, Glutes, and Abs.
     *
     * @return an array of muscles targeted by plyometrics
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{ Muscle.Legs, Muscle.Glutes, Muscle.Abs };
    }

    /**
     * Returns the estimated calories burned while doing plyometrics.
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
            case HIGH:   met = 7.4; break;
            case MEDIUM: met = 4.8; break;
            case LOW:
            default:     met = 2.5; break;
        }
        return met * weight * (duration / 60.0);
    }

    /**
     * Returns the name of this fitness activity.
     *
     * @return the string {@code "Plyometrics"}
     */
    @Override
    public String description() {
        return "Plyometrics";
    }
}