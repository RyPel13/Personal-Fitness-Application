/**
 * Abstract class representing anaerobic fitness activities.
 * Anaerobic exercise is defined as short duration, high intensity 
 * exercise lasting anywhere from merely seconds up to around two minutes.
 */
public abstract class Anaerobic implements Fitness{


    /**
     * Returns a description of anaerobic exercise.
     *
     * @return the string describing anaerobic exercise
     */
    @Override
    public String description() {
        return "Anaerobic means \"without oxygen.";
    }

    /**
     * Returns the muscles targeted by this anaerobic exercise.
     * Implementation depends on the specific anaerobic activity.
     *
     * @return array of muscles targeted
     */
    @Override
    public abstract Muscle[] muscleTargeted();

    /**
     * Returns the calories lost for this anaerobic exercise.
     * Implementation depends on the specific anaerobic activity.
     *
     * @param intensity the intensity level of the exercise
     * @param weight    the weight of the person in kg
     * @param duration  the duration of the exercise in minutes
     * @return the estimated calories burned
     */
    @Override
    public abstract double calorieLoss(Intensity intensity, double weight, int duration);
}
