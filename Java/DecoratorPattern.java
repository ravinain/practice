public class DecoratorPattern {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out
				.println(beverage2.getDescription() + " $" + beverage2.cost());

		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Whip(beverage3);
		beverage3 = new Mocha(beverage3);
		System.out
				.println(beverage3.getDescription() + " $" + beverage3.cost());
	}
}

abstract class Beverage {
	String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}

abstract class CondimentDecorator extends Beverage {
	@Override
	public abstract String getDescription();
}

class Espresso extends Beverage {
	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}
}

class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "HouseBlend";
	}

	@Override
	public double cost() {
		return 1.50;
	}
}

class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "DarkRoast";
	}

	@Override
	public double cost() {
		return 1.80;
	}
}

class Mocha extends CondimentDecorator {

	Beverage beverage;

	public Mocha(final Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}
}

class Whip extends CondimentDecorator {

	Beverage beverage;

	public Whip(final Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		return .25 + beverage.cost();
	}
}

class Soy extends CondimentDecorator {

	Beverage beverage;

	public Soy(final Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		return .15 + beverage.cost();
	}
}