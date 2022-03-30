package hw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@Scope("prototype")
public class CartControl {
    private String command;

    @Autowired
    private Cart cart;

    public void commandList() {
        System.out.println("To work with the cart, enter one of the commands:");
        System.out.println("Show products in cart: show cart");
        System.out.println("Show all products: show all");
        System.out.println("Add product to cart: add id (example: add 1)");
        System.out.println("Add all products to cart: add all");
        System.out.println("Remove product from cart: del id (example: del 3)");
        System.out.println("To finish work: exit");
        System.out.println();
    }
    public CartControl (Cart cart) {
        this.cart = cart;
        new Thread( () -> {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Welcome to Console Cart Control");
                commandList();
                System.out.println("Products available:");
                cart.showRepositoryProducts();
                System.out.println("Enter command:");
                while (!(command = reader.readLine()).equals("exit")) {
                    if(command.equals("show cart")) {
                        cart.showProductsInCart();
                    } else if (command.equals("show all")) {
                        cart.showRepositoryProducts();
                    } else if (command.startsWith("add")) {
                        if(command.equals("add all")) {
                            cart.addAllProducts();
                        } else {
                            if(command.split(" ").length == 2) {
                                String possibleId = command.split(" ")[1];
                                if (isDigit(possibleId) == true) {
                                    int id = Integer.parseInt(possibleId);
                                    cart.addProduct(id);
                                } else {
                                    System.out.println("Entered incorrect id");
                                }
                            } else {
                                System.out.println("Entered incorrect command");
                            }
                        }
                    } else if(command.startsWith("del")) {
                        if(command.split(" ").length == 2) {
                            String possibleId = command.split(" ")[1];
                            if (isDigit(possibleId) == true) {
                                int id = Integer.parseInt(possibleId);
                                cart.deleteProduct(id);
                            } else {
                                System.out.println("Entered incorrect id");
                            }
                        } else {
                            System.out.println("Entered incorrect command");
                        }
                    } else {
                        System.out.println("Entered incorrect command");
                    }
                    System.out.println();
                    System.out.println("Enter command:");
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    private boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}








