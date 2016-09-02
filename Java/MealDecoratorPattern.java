public class MealDecoratorPattern {

	public static void main(final String[] args) {
		final Meal meal = new Thali();
		System.out.println(meal.getDescription() + " Rs." + meal.cost());

		Meal meal2 = new Biryani();
		meal2 = new ButterMilk(meal2);
		meal2 = new Salad(meal2);

		System.out.println(meal2.getDescription() + " Rs." + meal2.cost());

		Meal meal3 = new Thali();
		meal3 = new Juice(meal3);
		meal3 = new Salad(meal3);
		System.out.println(meal3.getDescription() + " Rs." + meal3.cost());
	}

}

abstract class Meal {
	String description = "Unknown Meal";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}

abstract class MealDecorator extends Meal {
	@Override
	public abstract String getDescription();
}

class Thali extends Meal {

	public Thali() {
		description = "Thali";
	}

	@Override
	public double cost() {
		return 40;
	}
}

class Biryani extends Meal {

	public Biryani() {
		description = "Biryani";
	}

	@Override
	public double cost() {
		return 30;
	}
}

class ButterMilk extends MealDecorator {
	Meal meal;

	public ButterMilk(final Meal meal) {
		this.meal = meal;
	}

	@Override
	public String getDescription() {
		return meal.getDescription() + ", Butter Milk";
	}

	@Override
	public double cost() {
		return 5 + meal.cost();
	}
}

class Salad extends MealDecorator {
	Meal meal;

	public Salad(final Meal meal) {
		this.meal = meal;
	}

	@Override
	public String getDescription() {
		return meal.getDescription() + ", Salad";
	}

	@Override
	public double cost() {
		return 8 + meal.cost();
	}
}

class Juice extends MealDecorator {
	Meal meal;

	public Juice(final Meal meal) {
		this.meal = meal;
	}

	@Override
	public String getDescription() {
		return meal.getDescription() + ", Juice";
	}

	@Override
	public double cost() {
		return 14 + meal.cost();
	}
}