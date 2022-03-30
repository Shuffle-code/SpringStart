package hw1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductConfiguration.class);
        CartControl cartControl = context.getBean(CartControl.class);
    }
}
