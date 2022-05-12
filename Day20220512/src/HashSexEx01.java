import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//중복x .순서x
public class HashSexEx01 {

	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<Integer>();	
		
		set.add(1);
		set.add(5);
		set.add(5);
		set.add(2);
		set.add(3);
		
		System.out.println("cnt : " + set.size());
		
		for( Iterator<Integer> itr =set.iterator(); itr.hasNext();){
			System.out.print(itr.next() + "\t");
		}
		System.out.println();
		
		for(Integer s : set)
			System.out.print(s + "\t");
			
		
	}

}
