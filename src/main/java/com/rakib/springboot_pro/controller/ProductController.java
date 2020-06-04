package com.rakib.springboot_pro.controller;

import com.rakib.springboot_pro.entity.Product;
import com.rakib.springboot_pro.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "product";
        }
        product = productService.save(product);
        if (product != null) {
            model.addAttribute("result", "Record Saved Successfully");
        } else {
            model.addAttribute("result", "Record not Saved Successfully");
        }
        model.addAttribute("product", new Product());
        model.addAttribute("productList", productService.findAll());
        return "product";
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
