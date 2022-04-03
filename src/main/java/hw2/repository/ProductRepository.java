package hw2.repository;

import hw2.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("productRepository")
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private int count = 4;

    @PostConstruct
    public void init(){
        products.add(new Product(0, "apple", 540.00));
        products.add(new Product(1, "tomato", 530.00));
        products.add(new Product(2, "potatoes", 690.00));
        products.add(new Product(3, "orange", 580.00));
        products.add(new Product(4, "beet", 566.00));
    }

    public List<Product> findAll(){
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(Integer id) {
        if (id <(products.size()) && id >= 0) {
            return Optional.ofNullable(products.get(id));
        }else return Optional.empty();
    }
    public Product saveProduct(Product product) {
        product.setId(++count);
        products.add(product);
        return Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .build();
    }
}
