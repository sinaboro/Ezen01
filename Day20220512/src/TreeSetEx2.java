import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

class Person implements Comparable<Person>{
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + " : " + age;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.age-o.age;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(name,age);
	}
	
	@Override
	public boolean equals(Object obj) {
		Person p = (Person)obj;
		return name.equals(p.name) && age == p.age;
	}
}

class PersonCamp implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return (o1.name+o1.age).compareTo((o2.name+o2.age));
	}
}

public class TreeSetEx2 {

	public static void main(String[] args) {
		
		TreeSet<Person> tree = new TreeSet<>(new PersonCamp());
		
		tree.add(new Person("kim", 20));
		tree.add(new Person("park", 50));
		tree.add(new Person("Lee", 80));
		tree.add(new Person("Lee", 80));
		tree.add(new Person("Lee", 50));
		tree.add(new Person("kim", 29));
		tree.add(new Person("kim", 80));
		tree.add(new Person("park", 80));
		tree.add(new Person("Park", 50));
		
		for(Person n : tree)
			System.out.println(n);
	}

}
