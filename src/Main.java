
public class Main {

	public static void main(String[] args) {
		
		Profile p = new Profile(25, 1.85, 88, Gender.MALE);
		
		System.out.println(p);
		
		System.out.println(p.calcBMI());
		System.out.println(p.dailyCalorieIntake());
		
		Fitness[] exercises = { new Swimming(), new Yoga(), new WeightLifting()};
		for (Fitness exercise : exercises) {
		    System.out.println(exercise.description());
		}
		
		WeeklyExercise w = new WeeklyExercise(exercises, 3, 1000, p);
		w.targetedCalorieLoss(85.0, 30);

		System.out.println(w);
		
		w.targetedCalorieLoss(85.0, 90);
		
		System.out.println(w);
		
		DailyExercise [] exArray = w.getWeeklyExercises(Intensity.MEDIUM); 
		Muscle[] m = {Muscle.Glutes,Muscle.Cardio,Muscle.Legs};
		Intensity i[] = {Intensity.MEDIUM,Intensity.LOW,Intensity.HIGH};
		
		System.out.println(exArray[0].getExerciseList()[0].description());
		System.out.println(exArray[0].getCalorieTarget());
		System.out.println(exArray[0].getDuration());

		System.out.println(exArray[1].getExerciseList()[1].description());
		System.out.println(exArray[1].getCalorieTarget());
		System.out.println(exArray[1].getDuration());

		System.out.println(exArray[2].getExerciseList()[2].description());
		System.out.println(exArray[2].getCalorieTarget());
		System.out.println(exArray[2].getDuration());
	}

}
