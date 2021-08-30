    package com.example.trivianightwebsite.backend.entity;

    import javax.persistence.*;

    @Entity
    @Table(name = "admin")
    public class User {
        private int ID;
        private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String role;
        private String status;

        public User() {
        }

    	public User(int ID, String firstName, String lastName, String username, String password, String role,
    			String status) {
    		super();
    		this.ID = ID;
    		this.firstName = firstName;
    		this.lastName = lastName;
    		this.username = username;
    		this.password = password;
    		this.role = role;
    		this.status = status;
    	}
    	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    	public int getID() {
    		return ID;
    	} 

    	public void setID(int iD) {
    		ID = iD;
    	}

    	public String getFirstName() {
    		return firstName;
    	}

    	public void setFirstName(String firstName) {
    		this.firstName = firstName;
    	}

    	public String getLastName() {
    		return lastName;
    	}

    	public void setLastName(String lastName) {
    		this.lastName = lastName;
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

    	public String getRole() {
    		return role;
    	}

    	public void setRole(String role) {
    		this.role = role;
    	}

    	public String getStatus() {
    		return status;
    	}

    	public void setStatus(String status) {
    		this.status = status;
    	}

        
    	
    	
        
        
    }
