package Exemple;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapAndOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// "Mimo", "Mizo", "Mimi", "Momo", "papi", "mami"
		List<User> users = Arrays.asList(
				new User("Mimo", 19, Arrays.asList("1", "2")),
				new User("Mizo", 19, Arrays.asList("3", "4", "5")),
				new User("Mimi", 19, Arrays.asList("6")),
				new User("Momo", 19, Arrays.asList("7", "8")),
				new User("Mami", 19, Arrays.asList("9")),
				new User("papi", 19, Arrays.asList("10", "11"))
		);
		
		System.out.println("Functional Style: ");
		
		users.stream()
				.map(new Function<User, Object>() {

					@Override
					public Object apply(User user) {
						// TODO Auto-generated method stub
						return user.getPhoneNumbers();
					}
				});
		
//		users.stream().flatMap(user -> user.getPhoneNumbers().stream()).flatMap(new Function<Stream<String>, Stream<? >>() {
//			public Stream<?> apply(Stream<String> stringStream) {
//				return stringStream.filter(phoneNo -> phoneNo.equals("5"));
//			}
//		}).findAnd();
		
		Optional<String> stringOptional = users
			.stream()
			.map(user -> user.getPhoneNumbers().stream())
			.flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.equals("15")))
		.findAny();
		
		stringOptional.ifPresent(System.out::println);
	}

	private static boolean isNotMizo(String name) {
		return !name.equals("Mizo");
	}
	
	
	static class User {
		private String name;
		private Integer age = 30;
		private List<String> phoneNumbers;
		
		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public User(String name, Integer age, List<String> phoneNumbers) {
			super();
			this.name = name;
			this.age = age;
			this.phoneNumbers = phoneNumbers;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		
		
		public List<String> getPhoneNumbers() {
			return phoneNumbers;
		}

		public void setPhoneNumbers(List<String> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}
		
		
		
		
	}	
}
