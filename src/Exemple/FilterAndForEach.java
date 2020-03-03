package Exemple;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterAndForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Mimo", "Mizo", "Mimi", "Momo", "papi", "mami");

		for(String name: names) {
			if(!name.equals("Momo")) {
				System.out.println(name);
			}
		}
		
//		names.stream().filter(new Predicate<String>() {
//			public boolean test(String name) {
//				return !name.equals("Momo");
//			}
//		})
//		.forEach(name -> System.out.println(name));
//		
//		names.stream().filter(name -> isNotMomo(name))
//		.forEach(System.out::println);
		
		names.stream().filter(FilterAndForEach::isNotMomo)
		.forEach(System.out::println);
		
//		names.stream().filter(name -> !name.equals("Momo"))
//		.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String name) {
//				// TODO Auto-generated method stub
//				System.out.println(name);
//			}
//		
//		});
	}
	
	private static boolean isNotMomo(String name) {
		return !name.equals("Momo");
	}

}
