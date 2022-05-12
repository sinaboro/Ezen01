import java.util.Iterator;
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
}

public class TreeSetEx2 {

	public static void main(String[] args) {
		
		TreeSet<Person> tree = new TreeSet<>();
		
		tree.add(new Person("kim", 20));
		tree.add(new Person("park", 50));
		tree.add(new Person("Lee", 80));
		tree.add(new Person("Lee", 80));
		tree.add(new Person("Lee", 50));
		tree.add(new Person("kim", 29));
		tree.add(new Person("kim", 80));
		
		for(Person n : tree)
			System.out.println(n);
		
		
	}

}
