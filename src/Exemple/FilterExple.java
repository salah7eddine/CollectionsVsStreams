package Exemple;

import java.util.Arrays;
import java.util.List;

public class FilterExple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Mimo", "Mizo", "Mimi", "Momo", "papi", "mami");
		
		for (String name: names) {
			if(!name.equals("Mizo")) {
				System.out.println(name);
			}
		}
		
		System.out.println("Functional Style");
		
		names.stream().filter(FilterExple::isNotMizo).forEach(System.out::println);
	}

	private static boolean isNotMizo(String name) {
		return !name.equals("Mizo");
	}
}
