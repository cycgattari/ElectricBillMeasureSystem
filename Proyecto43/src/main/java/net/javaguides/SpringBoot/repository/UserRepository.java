package net.javaguides.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.SpringBoot.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
