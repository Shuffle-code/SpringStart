package hw2.repository;

import hw2.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("productRepository")
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private Long count = Long.valueOf(4);

    @PersistenceContext
    private EntityManager entityManager;

//    @PostConstruct
//    public void init(){
//        products.add(new Product(0L, "apple", 540.00));
//        products.add(new Product(1L, "tomato", 530.00));
//        products.add(new Product(2L, "potatoes", 690.00));
//        products.add(new Product(3L, "orange", 580.00));
//        products.add(new Product(4L, "beet", 566.00));
//    }

    public List<Product> findAll(){
//        return new ArrayList<>(products);
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    public Product findById(Long id) {
//        public Optional<Product> findById(Integer id) {
        TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.findById", Product.class);
        namedQuery.setParameter("id", id);
        return namedQuery.getSingleResult();
//        if (id <(products.size()) && id >= 0) {
//            return Optional.ofNullable(products.get(id));
//        }else return Optional.empty();
    }
    public Product saveProduct(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
        return product;
//        product.setId(++count);
//        products.add(product);
//        return Product.builder()
//                .id(product.getId())
//                .title(product.getTitle())
//                .price(product.getPrice())
//                .build();
    }

    public void deleteById(Integer id) {
//        Product product = new Product();
//        Product mergedProduct = entityManager.merge(product);
//        entityManager.remove(mergedProduct);
        if (id < products.size()) {
            products.remove(id.intValue());
        }
    }

    public void delete(Product product) {
        Product mergedProduct = entityManager.merge(product);
        entityManager.remove(mergedProduct);
    }
}
