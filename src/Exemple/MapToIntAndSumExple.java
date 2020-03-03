package Exemple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapToIntAndSumExple {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Mimo", "Mizo", "Mimi", "Momo", "papi", "mami");
		
		System.out.println("Imperative Style: ");
		
		for(String name: names) {
			if(!name.equals("Momo")) {
				User user = new User(name);
				System.out.println(user);
			}
		}
		
		System.out.println("Functionale Style: ");
		
		names.stream()
				.filter(MapToIntAndSumExple::isNotMomo)
				.map(User::new)
				.forEach(System.out::println);
		
		List<User> userList = names.stream()
		.filter(MapToIntAndSumExple::isNotMomo)
		.map(User::new)
		.collect(Collectors.toList());
		
		int sum = userList.stream().mapToInt(user -> user.getAge()).sum();
		System.out.println(sum);
		
		/*
		 * .map(name -> new User(name))
		 * 
		 .map(new Function<String, User>() {

					@Override
					public User apply(String name) {
						// TODO Auto-generated method stub
						User user = new User(name);
						return user;
					}
					
				})
		 * */

	}
	
	private static boolean isNotMomo(String name) {
		return !name.equals("Momo");
	}
	
	
	static class User {
		private String name;
		private Integer age = 30;
		
		public User(String name) {
			this.name = name;
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
		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}
		
		
	}

}
