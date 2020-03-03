package Exemple;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Logging In Streams

public class PeekAndSkip {

	public static void main(String[] args) {
		
		List<String> strings = Stream.of("One", "Two", "Three")
				.filter(obj -> !obj.equals("One"))
				.peek(obj -> System.out.println("Peeked " + obj))
				.collect(Collectors.toList());
		
		IntStream.of(11, 1, 2, 3, 4, 12, 10, 9, 7)
					.skip(3) // Skipe the 3 nbres
					.filter(i -> i > 5)
					.forEach(i -> System.out.println(i));

	}

}
//  