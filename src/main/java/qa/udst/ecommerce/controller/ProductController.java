package qa.udst.ecommerce.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qa.udst.ecommerce.model.AbstractProduct;
import qa.udst.ecommerce.model.DigitalProduct;
import qa.udst.ecommerce.model.PhysicalProduct;
import qa.udst.ecommerce.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /** ✅ Get all products */
    @GetMapping
    public ResponseEntity<List<AbstractProduct>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    /** ✅ Get product by ID */
    @GetMapping("/{id}")
    public ResponseEntity<AbstractProduct> getProductById(@PathVariable Long id) {
        AbstractProduct product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    /** ✅ Create new DIGITAL product */
    @PostMapping("/digital")
    public ResponseEntity<DigitalProduct> createDigitalProduct(@Valid @RequestBody DigitalProduct product) {
        DigitalProduct saved = productService.createDigital(product);
        return ResponseEntity.ok(saved);
    }

    /** ✅ Create new PHYSICAL product */
    @PostMapping("/physical")
    public ResponseEntity<PhysicalProduct> createPhysicalProduct(@Valid @RequestBody PhysicalProduct product) {
        PhysicalProduct saved = productService.createPhysical(product);
        return ResponseEntity.ok(saved);
    }

    /** ✅ Update any product */
    @PutMapping("/{id}")
    public ResponseEntity<AbstractProduct> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody AbstractProduct product) {
        AbstractProduct updated = productService.update(id, product);
        return ResponseEntity.ok(updated);
    }

    /** ✅ Delete product */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
