package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(
			  value = "SELECT * FROM my_db.USERS u WHERE u.email = ?1", 
			  nativeQuery = true)
	public User findByEmail(String email);
	
}
