
/**
 * Abstract class representing endurance fitness activities.
 * Endurance exercises exert maximum force in short intervals of time, 
 * with the goal of increasing power (speed-strength).
 */
public abstract class Endurance implements Fitness {

    /**
     * Returns a description of endurance exercise.
     *
     * @return the string describing endurance exercise
     */
    @Override
    public String description() {
        return "Endurance is all about sweat and patience";
    }

    /**
     * Returns the muscles targeted by this endurance exercise.
     * Implementation depends on the specific endurance activity.
     *
     * @return array of muscles targeted
     */
    @Override
    public abstract Muscle[] muscleTargeted();

    /**
     * Returns the calories lost for this endurance exercise.
     * Implementation depends on the specific endurance activity.
     *
     * @param intensity the intensity level of the exercise
     * @param weight    the weight of the person in kg
     * @param duration  the duration of the exercise in minutes
     * @return the estimated calories burned
     */
    @Override
    public abstract double calorieLoss(Intensity intensity, double weight, int duration);
}

