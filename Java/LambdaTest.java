import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LambdaTest {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final Addition addition = (x, y) -> x + y;
		System.out.println(addition.add(5, 6));
		
		final Division div = (x, y) -> {
			if(y == 0) {
				return 0;
			}
			return x/y;
		};
		System.out.println(div.divide(15,5));
		System.out.println(div.divide(15,0));
		
		final Shape shape = (s) -> System.out.println("Drawing " + s);
		shape.draw("Circle");
		
		final Hello hello = () -> System.out.println("Hello World!");
		hello.sayHello();
		
		List<Person> people = new ArrayList<>();
		
		Person mike = new Person(5, "Mike", 20);
		Person ravi = new Person(3, "Ravi", 25);
		Person manoj = new Person(14, "Manoj", 23);
		
		people.add(mike);
		people.add(ravi);
		people.add(manoj);
		
		//Sort in ascending order of age using Lambda expression
		Collections.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());
		for(Person person: people) {
			System.out.print(person.getAge() + " ");
		}
		
		System.out.println();
		
		//Sort in ascending order of name using Lambda expression
		Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		for(Person person: people) {
			System.out.print(person.getName() + " ");
		}
		
	}
}

interface Addition {
	int add(int x, int y);
}

interface Division {
	double divide(double x, double y);
}

interface Shape {
	void draw(String shape);
}

interface Hello {
	void sayHello();
}

final class Person {
	
	private int personId;
	private String name;
	private int age;
	
	Person(){}
	
	Person(final int personId, final String name, final int age) {
		this.personId = personId;
		this.name = name;
		this.age = age;
	}
	
	public int getPersonId() {
		return this.personId;
	}
	
	public void setPersonId(final int personId) {
		this.personId = personId;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(final int age) {
		this.age = age;
	}
}