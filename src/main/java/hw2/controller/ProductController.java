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

    //localhost:8080/spring/message/{id}?random=true
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getProductById(Model model, @PathVariable Long id) {
        Product product;
        product = service.getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

//    @RequestMapping(path = "/all", method = RequestMethod.GET)
//    public String getAllMessages(Model model) {
//        model.addAttribute("messages", service.getAllProducts());
//        return "message-list";
//    }


    // localhost:8080/spring/message/delete?id=1
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam Integer id) {
//        log.info("deleted: {}", id);
        service.deleteById(id);
//        return "redirect:list-product";
        return "redirect:/products";
    }

//    @RequestMapping(path = "/edit", method = RequestMethod.GET)
//    public String editById(Model model, @RequestParam Integer id) {
//        model.addAttribute("message", service.getProductById(id));
//        return "create-message";
//    }


}
