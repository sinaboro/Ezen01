import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorEx {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("toy", "box", "robot", "box");
		
		System.out.println(list);
		
		list = new ArrayList<String>(list);
		
		ListIterator<String> it = list.listIterator();  //양방향
		
		while(it.hasNext()) {
			String str = it.next();
			System.out.print(str + "\t");
		}

//		while(it.hasNext()) {
//			String str = it.next();
//			System.out.print(str + "\t");
//		}
		
		System.out.println();
		
		while(it.hasPrevious()) {
			String str = it.previous();
			System.out.print(str + "\t");
		}
		
		System.out.println();
		for(Iterator<String> itr = list.iterator(); it.hasNext(); )
			System.out.print(itr.next() + "\t");
		
//		Iterator<String>   it2 = list.iterator();
//		System.out.println("\n--------------------------");
//		while(it2.hasNext()) {
//			String str2 = it2.next();
//			System.out.print(str2 + '\t');
//			
//		}
		
	}

}
