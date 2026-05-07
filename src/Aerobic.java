/**
 * Abstract class representing aerobic fitness activities.
 * Aerobic means "with oxygen." The purpose of aerobic conditioning is to
 * increase the amount of oxygen that is delivered to your muscles,
 * which allows them to work longer.
 */
public abstract class Aerobic implements Fitness {

    /**
     * Returns a description of aerobic exercise.
     *
     * @return the string describing aerobic exercise
     */
	@Override
	public String description() {
	    return "Aerobic means \"with oxygen.\"";
	}

    /**
     * Returns the muscles targeted by this aerobic exercise.
     * Implementation depends on the specific aerobic activity.
     *
     * @return array of muscles targeted
     */
    @Override
    public abstract Muscle[] muscleTargeted();

    /**
     * Returns the calories lost for this aerobic exercise.
     * Implementation depends on the specific aerobic activity.
     *
     * @param intensity the intensity level of the exercise
     * @param weight    the weight of the person in kg
     * @param duration  the duration of the exercise in minutes
     * @return the estimated calories burned
     */
    @Override
    public abstract double calorieLoss(Intensity intensity, double weight, int duration);
}
