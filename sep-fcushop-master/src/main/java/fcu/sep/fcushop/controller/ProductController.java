package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Product;
import fcu.sep.fcushop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  ProductService productManager;

  @GetMapping("/products")
  public List<Product> getProducts() {
    return productManager.getProducts();

  }

  @GetMapping("/products/{keyword}")
  public List<Product> getProducts(@PathVariable("keyword") String keyword) {
    return productManager.getProducts(keyword);
  }

  @PostMapping("/addProducts")
  @ResponseBody
  public int addProducts(@RequestParam("NAME") String NAME, @RequestParam("IMAGE_URL")String IMAGE_URL, @RequestParam("PRICE")int PRICE, @RequestParam("DESCRIPTION")String DESCRIPTION){
    int result=1;

    productManager.addProducts(NAME, IMAGE_URL, PRICE, DESCRIPTION);

    return  result;
  }
}
