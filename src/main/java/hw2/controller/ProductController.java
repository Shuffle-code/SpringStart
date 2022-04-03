package hw2.controller;

import hw2.model.Product;
import hw2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String fillForm(Product product) {
        service.saveProduct(product);
        return "redirect:/products";
    }

    @RequestMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "list-product";
    }


}
