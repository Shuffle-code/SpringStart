package hw2.service;

//import hw2.dao.EntityManagerProductDao;
import hw2.model.Product;
import hw2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
//    private final EntityManagerProductDao entityManagerProductDao;


    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id);
//                .orElseThrow(NoSuchElementException::new);
    }

    public List<Product> getAllProducts() {
//        return entityManagerProductDao.findAll();
        return productRepository.findAll();
    }


    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

}
