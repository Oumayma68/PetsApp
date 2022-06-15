package net.codejava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(nullable=false, unique= true,length=45)
    private String Email;
    @Column(nullable=false, unique= true,length=64)
    private String Password;
    
   
	@Column(nullable=false, unique= true,length=20)
	private String FirstName;
    
    @Column(nullable=false, unique= true,length=20)
	private String LastName;
	
    public User()
    {
    	
    }
    
	public User(Long id, String email, String password, String firstName, String lastName) {
		super();
		this.id = id;
		Email = email;
		Password = password;
		FirstName = firstName;
		LastName = lastName;
	}
	public User(String email, String password, String firstName, String lastName) {
		super();
		Email = email;
		Password = password;
		FirstName = firstName;
		LastName = lastName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	 public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
	
	

}
