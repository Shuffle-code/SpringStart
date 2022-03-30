package hw1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProductRepository {
    private List<Product> products;
//    @PostConstruct
//    private List<Product> createProduct() {
//        List<Product> products = List.of(
//                new Product(1, "apple", 540),
//                new Product(2, "tomato", 530),
//                new Product(3, "potatoes", 690),
//                new Product(4, "orange", 580),
//                new Product(5, "beet", 566));
//
//        return products;
//    }
    @PostConstruct
    public void createProduct() {
        products = new ArrayList<>();
        products.add(new Product(1, "apple", 540));
        products.add(new Product(2, "tomato", 530));
        products.add(new Product(3, "potatoes", 690));
        products.add(new Product(4, "orange", 580));
        products.add(new Product(5, "beet", 566));
    }

    void showAllList(){
        for (Product product : products) {
            System.out.println(product);
        }
    }
    private void showProductById(List<Product> products, int id){
        for (Product product : products){
            if (product.getId() == id) System.out.println(product.toString());
        }
    }
    public Product getProductById(int id) {
        for(int i = 0; i < products.size(); i++) {
            if(id == products.get(i).getId()) {
                return products.get(i);
            }
        }
        return null;
    }
    public List<Product> getAllProducts() {
        System.out.println("Products add");
        return products;
    }

    public boolean containsId(int id) {
        for (Product product : products) {
            if (product.getId() == id) return true;
        }return false;
    }
}
