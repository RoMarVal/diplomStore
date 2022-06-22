package com.first.shop2206.repositories;

import com.first.shop2206.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {

}
