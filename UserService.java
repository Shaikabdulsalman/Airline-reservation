package airline_reservation_system;

import java.util.*;

public class UserService {
    private List<User> registeredUsers = new ArrayList<>();

    public boolean registerUser(String username, String password) {
        for (User user : registeredUsers) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists!");
                return false;
            }
        }
        registeredUsers.add(new User(username, password));
        System.out.println("User registered successfully!");
        return true;
    }

    public User loginUser(String username, String password) {
        for (User user : registeredUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return user;
            }
        }
        System.out.println("Invalid username or password.");
        return null;
    }
}

