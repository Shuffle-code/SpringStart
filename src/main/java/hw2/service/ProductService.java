package hw2.service;

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


    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }


    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
