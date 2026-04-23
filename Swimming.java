/**
 * Represents a swimming aerobic exercise activity.
 * Swimming is an aerobic exercise that burns calories based on the MET
 * (metabolic equivalent) value, weight, and duration.
 * Different swimming styles target different muscle groups.
 */
public class Swimming extends Aerobic {

    /** The type of swimming stroke being performed. */
    private SwimmingType type;

    /**
     * Constructs a Swimming exercise with a default stroke of {@link SwimmingType#Freestyle}.
     */
    public Swimming() {
        this.type = SwimmingType.Freestyle;  
    }

    /**
     * Constructs a Swimming exercise with the specified swimming stroke type.
     *
     * @param type the type of swimming stroke
     */
    public Swimming(SwimmingType type) {
        this.type = type;
    }

    /**
     * Sets the swimming stroke type.
     *
     * @param type the new swimming stroke type
     */
    public void setSwimmingType(SwimmingType type) {
        this.type = type;
    }

    /**
     * Returns the current swimming stroke type.
     *
     * @return the swimming stroke type
     */
    public SwimmingType getSwimmingType() {
        return type;
    }

    /**
     * Returns the muscles targeted based on the current swimming stroke type.
     * 
     * @return an array of muscles targeted by the current stroke type
     */
    @Override
    public Muscle[] muscleTargeted() {
        switch (type) {
            case Butterflystroke:
                return new Muscle[]{ Muscle.Abs, Muscle.Back, Muscle.Shoulders,
                                     Muscle.Biceps, Muscle.Triceps };
            case Breaststroke:
                return new Muscle[]{ Muscle.Glutes, Muscle.Cardio };
            case Freestyle:
            default:
                return new Muscle[]{ Muscle.Arms, Muscle.Legs, Muscle.Cardio };
        }
    }

    /**
     * Returns the estimated calories burned while swimming.
     * Uses MET (metabolic equivalent) values per stroke type:
     * 
     * @param intensity the intensity level (HIGH, MEDIUM, LOW) — affects MET value
     * @param weight    the weight of the person in kilograms
     * @param duration  the duration of the exercise in minutes
     * @return the estimated calories burned
     */
    @Override
    public double calorieLoss(Intensity intensity, double weight, int duration) {
        double met;
        switch (intensity) {
            case HIGH: met = 10.0; break;
            case MEDIUM: met = 8.3; break;
            case LOW:
            default: met = 6.0; break;
        }
        return met * weight * (duration / 60.0);
    }

    /**
     * Returns the name of this fitness activity.
     *
     * @return the string {@code "Swimming"}
     */
    @Override
    public String description() {
        return "Swimming";
    }
}