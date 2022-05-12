import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		Person[] person = new Person[3];
 
		person[0] = new Person("김대",  25);
		person[1] = new Person("김신유",  30);
		person[2] = new Person("남궁신궁",  22);
		
		Arrays.sort(person);
		
		for(Person p : person)
			System.out.println(p);
	}
}


class Person implements Comparable{
	private String name;
	private int age;

	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "name=" + name + ", age=" + age ;
	}
	
	@Override
	public int compareTo(Object o) {
		Person p = (Person)o;
		
		//return this.age - p.age;
		//return p.age - this.age;
		return this.name.length() - p.name.length();
	}
	
}