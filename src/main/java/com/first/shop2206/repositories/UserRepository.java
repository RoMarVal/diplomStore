package com.first.shop2206.repositories;

import com.first.shop2206.model.Product;
import com.first.shop2206.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
