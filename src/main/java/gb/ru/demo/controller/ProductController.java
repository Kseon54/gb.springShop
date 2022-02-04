package gb.ru.demo.controller;

import gb.ru.demo.model.Product;
import gb.ru.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getAllProduct(Model model) {
        ArrayList<Product> list = productService.findAll();
        model.addAttribute("products", list);
        return "product/product";
    }

    @GetMapping("/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        ArrayList<Product> list = new ArrayList<>();
        list.add(productService.findById(id));
        model.addAttribute("products", list);
        return "product/product";
    }

    @GetMapping("/add")
    public String openFormAddProduct(Model model) {
        return "product/addProduct";
    }

    @GetMapping("/addProduct")
    public String addProduct(@RequestParam(name = "title") String title,
                             @RequestParam(name = "cost") double cost) {
        Product product = new Product(title, cost);
        productService.save(product);
        return "redirect:" + "/product";
    }

}
