/**
 * Represents a cycling aerobic exercise activity.
 * Cycling is an aerobic exercise that burns calories based on the MET
 * (metabolic equivalent) value, weight, and duration.
 * Cycling targets the Glutes, Cardio, and Legs.
 */
public class Cycling extends Aerobic {

    /**
     * Constructs a Cycling exercise.
     */
    public Cycling() {}

    /**
     * Returns the muscles targeted by cycling.
     * Cycling targets: Glutes, Cardio, and Legs.
     *
     * @return an array of muscles targeted by cycling
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{ Muscle.Glutes, Muscle.Cardio, Muscle.Legs };
    }

    /**
     * Returns the estimated calories burned while cycling.
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
            case HIGH:   met = 14.0; break;
            case MEDIUM: met = 8.5;  break;
            case LOW:    
            default:     met = 4.0;  break;
        }
        return met * weight * (duration / 60.0);
    }

    /**
     * Returns the name of this fitness activity.
     *
     * @return the string {@code "Cycling"}
     */
    @Override
    public String description() {
        return "Cycling";
    }
}