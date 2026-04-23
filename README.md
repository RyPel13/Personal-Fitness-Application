# Personal-Fitness-Application
•	Built a full personal fitness planning application in Java featuring a deep, multi-level class hierarchy: a Fitness interface at the top, extended by four abstract classes (Aerobic, Anaerobic, Flexibility, Endurance), each further subclassed by concrete exercise types (Swimming, Cycling, Weightlifting, Plyometrics, Yoga, TaiChi, Squat, PullUp).

•	Leveraged interfaces to define a polymorphic contract — the Fitness interface declared muscleTargeted(), calorieLoss(), and description() as abstract methods, enforcing consistent behavior across all 8+ concrete exercise implementations without coupling to any specific class.

•	Demonstrated polymorphism through abstract class design: intermediate abstract classes provided shared description() logic and deferred muscleTargeted() and calorieLoss() to concrete subclasses, enabling each exercise to define its own MET-based calorie calculation.

•	Defined multiple enum types (Muscle, Intensity, Gender, SwimmingType) to replace error-prone constants with type-safe domain values representing exercise intensity levels, targeted muscle groups, and swim stroke categories.

•	Applied encapsulation throughout the Profile class, storing user attributes (age, weight, height, gender) as private fields and computing derived health metrics (BMI, TDEE/BMR) using gender-specific formulas via encapsulated methods.

•	Used arrays and the Collections framework to manage exercise lists dynamically within DailyExercise and WeeklyExercise classes, supporting add/remove operations and muscle-group filtering to generate personalized workout plans with calculated durations.

