/**
 * Abstract class representing flexibility fitness activities.
 * flexibility exercise is defined as short duration, high intensity 
 * exercise lasting anywhere from merely seconds up to around two minutes.
 */
public abstract class Flexibility implements Fitness{


    /**
     * Returns a description of flexibility exercise.
     *
     * @return the string describing flexibility exercise
     */
    @Override
    public String description() {
        return "Flexibility is uncomfortable and it takes time, so people don't like to do it";
    }

    /**
     * Returns the muscles targeted by this flexibility exercise.
     * Implementation depends on the specific flexibility activity.
     *
     * @return array of muscles targeted
     */
    @Override
    public abstract Muscle[] muscleTargeted();

    /**
     * Returns the calories lost for this flexibility exercise.
     * Implementation depends on the specific flexibility activity.
     *
     * @param intensity the intensity level of the exercise
     * @param weight    the weight of the person in kg
     * @param duration  the duration of the exercise in minutes
     * @return the estimated calories burned
     */
    @Override
    public abstract double calorieLoss(Intensity intensity, double weight, int duration);
}