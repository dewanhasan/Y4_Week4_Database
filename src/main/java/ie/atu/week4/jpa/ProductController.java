package ie.atu.week4.jpa;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private List<Product> productList = new ArrayList<>();
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product) {
        productList = productService.add(product);
        // productList.add(product);
        return ResponseEntity.ok(productList);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<List> deleteProduct(@PathVariable Long id) {
        productList = productService.deleteProduct(id);
        return ResponseEntity.ok(productList);

    }

    private Product findProductById(int id) {
        for (Product product : productList) {
            if (product.getProductCode() == id) {
                return product;
            }
        }
        return null;
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@Valid @PathVariable Long id, @Valid @RequestBody Product product){
        productService.updateProduct(id, product);
        return product;
    }


}
