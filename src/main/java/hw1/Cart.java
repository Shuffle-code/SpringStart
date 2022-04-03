package hw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class Cart {
    private Map<Product, Integer> cart;

    @Autowired
    private ProductRepository productRepository;


    public Cart(ProductRepository productRepository) {
        cart = new HashMap<>();
        this.productRepository = productRepository;
    }
    public void addProduct(int id) {
        if(containsId(id) == false && productRepository.containsId(id) == true) {
            cart.put(productRepository.getProductById(id), 1);
        } else {
            System.out.println("Entered incorrect id");
        }
    }

    public void addAllProducts() {
        List<Product> products = productRepository.getAllProducts();
        for(int i = 0; i < products.size(); i++) {
            addProduct(products.get(i).getId());
        }

    }

    public void deleteProduct(int id) {
        if(containsId(id) == true) {
            cart.remove(productRepository.getProductById(id));
        } else {
            System.out.println("Entered incorrect id");
        }
    }


    public void showRepositoryProducts() {
        productRepository.showAllList();
    }

    public void showProductsInCart() {
        if(cart.size() > 0) {
            for (Product product : cart.keySet()) {
                System.out.println(product.toString() + " - " + cart.get(product));
            }

        } else {
            System.out.println("Cart is empty");
        }
        System.out.println();
    }

    public boolean containsId(int id) {
        for(Product product : cart.keySet()) {
            if(id == product.getId()) {
                return true;
            }
        }
        return false;
    }

}
