package hw2.dao;

import hw2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long>{
//    Iterable<Product> findAll();
//
//    Product findById(Long id);
//
//    Product save(Product product);
//
//    void delete(Product product);
}
