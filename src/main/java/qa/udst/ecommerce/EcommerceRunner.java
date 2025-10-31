package qa.udst.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import qa.udst.ecommerce.model.*;
import qa.udst.ecommerce.service.ProductService;

@Component
public class EcommerceRunner implements CommandLineRunner {

    private final ProductService productService;

    public EcommerceRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        System.out.println("🚀 Seeding initial products...");

        // Create a digital product
        DigitalProduct digital = new DigitalProduct(
                null,
                "E-Book Clean Architecture",
                19.90,
                ProductCategory.Digital,
                "https://example.com/clean-arch.pdf");
        productService.createDigital(digital);

        // Create a physical product
        PhysicalProduct physical = new PhysicalProduct(
                null,
                "Mechanical Keyboard",
                129.00,
                ProductCategory.Physical,
                0.85,
                "44x13x3cm");
        productService.createPhysical(physical);

        // Print stored products
        System.out.println("✅ Initial Products in Database:");
        productService.findAll().forEach(p -> System.out.println(p.getId() + " - " + p.getName() +
                " $" + p.getPrice() + " [" + p.getCategory() + "]"));
    }
}
