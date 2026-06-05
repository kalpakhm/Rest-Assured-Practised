package utils;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import net.datafaker.Faker;
import pojo.User;

public class UserDataPetStore {

	@Test
	public static List<User> createUsers(int user_count) {
		
		// 👉 Create Faker object
		Faker faker=new Faker();
		
		
		
		// 👉 List to store multiple users
		List<User>	users=new ArrayList<>();
		
		//loop to generate the multiple users
		for(int i=0;i<user_count;i++) {
		
		// 👉 Create User object
				User user=new User();
		
		// 👉 Set User data using Faker
		user.setId(faker.number().numberBetween(1, 1000));
		user.setUsername(faker.name().username());
		user.setFirstName(faker.name().firstName());
		user.setLastName(faker.name().lastName());
		user.setEmail(faker.internet().emailAddress());
		user.setPassword(faker.internet().password());
		user.setPhone(faker.phoneNumber().cellPhone());
		user.setUserStatus(faker.number().numberBetween(0, 1));
		
		//add user to list
		users.add(user);
		
		}
		// 👉 Returns List of users(Array)
		return users;
	}
	
}
