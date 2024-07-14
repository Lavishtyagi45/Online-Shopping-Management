package online_shopping_management;

import java.util.*;
import java.io.*;

class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String AdminMail="test1@gmail.com";

    // Constructor
    public User(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

	public boolean isAdmin(User user) {
		if(user.getEmail().equals(AdminMail)) {
			return true;
		}
		return false;
	}
}


public class UserManagement {
    private List<User> users = new ArrayList<>();
    private static String FILE_PATH = "users.txt"; // Path to the data file
    
    
    // Method to register a new user
    public boolean registerUser(User user) {
    	if(!users.contains(user)) {
    		users.add(user);
    		saveUsersToFile();
    		return true;
    	}
    	return false;
    }

    // Method to perform user login
    public User login(String username, String password) {
        loadUsersFromFile();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // Method to retrieve all users
    public List<User> getUsers() {
        loadUsersFromFile();
        return users;
    }

    // Load users from file
    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 4) {
                    int id = Integer.parseInt(userData[0]);
                    String username = userData[1];
                    String password = userData[2];
                    String email = userData[3];
                    users.add(new User(id, username, password, email));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users from file: " + e.getMessage());
        }
    }

    // Save users to file
    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users) {
                writer.write(
                        user.getId() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing users to file: " + e.getMessage());
        }
    }

	public int generateUserId() {
		int lastUsedId = users.isEmpty() ? 0 : users.get(users.size() - 1).getId();
        return lastUsedId + 1;
	}

	public User getUserById(int userId) {
		for(User user:users) {
			if(user.getId()==userId) {
				return user;
			}
		}
		return null;
	}
	
}

