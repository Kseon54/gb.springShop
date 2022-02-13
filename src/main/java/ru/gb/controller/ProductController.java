package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;
import ru.gb.entity.enums.Status;
import ru.gb.service.ManufacturerService;
import ru.gb.service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ManufacturerService manufacturerService;

    @GetMapping
    public String getAllProduct(Model model,
                                @RequestParam(name = "sort", defaultValue = "ASC") Sort.Direction direction,
                                @RequestParam(name = "column", defaultValue = "cost") String column
                                ) {
        Iterable<Product> list = productService.findAllActiveSortedBy(direction, column);
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
        Iterable<Manufacturer> list = manufacturerService.findAll();
        model.addAttribute("manufacturers", list);
        return "product/addProduct";
    }

    @GetMapping("/addProduct")
    public String addProduct(@RequestParam(name = "title") String title,
                             @RequestParam(name = "cost") BigDecimal cost,
                             @RequestParam(name = "manufacturerId") Long manufacturerId) {
        Product product = new Product(title, cost, manufacturerService.findById(manufacturerId));
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/disable")
    public String disableProduct(Model model, @PathVariable long id) {
        productService.disableById(id);
        return "redirect:/product";
    }

    @GetMapping("/{id}/active")
    public String activeProduct(Model model, @PathVariable long id) {
        productService.activeById(id);
        return "redirect:/product";
    }

    @GetMapping("/{id}/updateForm")
    public String openUpdateForm(Model model, @PathVariable long id) {
        Iterable<Manufacturer> list = manufacturerService.findAll();
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("manufacturers", list);
        model.addAttribute("statuses", Status.values());
        return "/product/updateProduct";
    }

    @GetMapping("/{id}/update")
    public String updateProduct(Model model, @PathVariable long id,
                                @RequestParam(name = "title") String title,
                                @RequestParam(name = "cost") BigDecimal cost,
                                @RequestParam(name = "manufacturerId") Long manufacturerId,
                                @RequestParam(name = "status") Status status
                                ) {
        Product product = productService.findById(id);
        product.setTitle(title);
        product.setCost(cost);
        product.setManufacturer(manufacturerService.findById(manufacturerId));
        product.setStatus(status);
        productService.save(product);
        return "redirect:/product";
    }

}
