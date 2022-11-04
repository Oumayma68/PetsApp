package Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

}
