package com.rakib.springboot_pro.controller;

import com.rakib.springboot_pro.entity.Product;
import com.rakib.springboot_pro.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String greetingSms(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productList", productService.findAll());
        return "product";
    }

    @PostMapping(value = "/saveProduct")
    public String saveProduct(@ModelAttribute Product product, Model model) {
        productService.save(product);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deletedById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateProduct(@PathVariable("id") Long id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("productList", productService.findAll());
        return "product";
    }

}
