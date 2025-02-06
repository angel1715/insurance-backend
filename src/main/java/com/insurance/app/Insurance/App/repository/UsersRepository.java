package com.insurance.app.Insurance.App.repository;

import com.insurance.app.Insurance.App.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
