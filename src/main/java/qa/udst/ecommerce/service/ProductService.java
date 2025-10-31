package qa.udst.ecommerce.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import qa.udst.ecommerce.model.AbstractProduct;
import qa.udst.ecommerce.model.DigitalProduct;
import qa.udst.ecommerce.model.PhysicalProduct;
import qa.udst.ecommerce.repositories.DigitalProductRepository;
import qa.udst.ecommerce.repositories.PhysicalProductRepository;
import qa.udst.ecommerce.repositories.ProductRepository;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final DigitalProductRepository digitalProductRepository;
    private final PhysicalProductRepository physicalProductRepository;

    public ProductService(ProductRepository productRepository,
            DigitalProductRepository digitalProductRepository,
            PhysicalProductRepository physicalProductRepository) {
        this.productRepository = productRepository;
        this.digitalProductRepository = digitalProductRepository;
        this.physicalProductRepository = physicalProductRepository;
    }

    /** Return all products (digital + physical). */
    public List<AbstractProduct> findAll() {
        return productRepository.findAll();
    }

    /** Find a product by its ID. */
    public AbstractProduct findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + id + " not found."));
    }

    /** Create and persist a new digital product. */
    public DigitalProduct createDigital(DigitalProduct product) {
        return digitalProductRepository.save(product);
    }

    /** Create and persist a new physical product. */
    public PhysicalProduct createPhysical(PhysicalProduct product) {
        return physicalProductRepository.save(product);
    }

    /** Update an existing product (any subtype). */
    public AbstractProduct update(Long id, AbstractProduct updatedProduct) {
        AbstractProduct existing = findById(id);
        updatedProduct.setId(existing.getId());
        return productRepository.save(updatedProduct);
    }

    /** Delete a product by ID. */
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Product with ID " + id + " not found.");
        }
        productRepository.deleteById(id);
    }

    /** Find all products containing a name fragment (case-insensitive). */
    public List<AbstractProduct> searchByName(String query) {
        return productRepository.findByNameContainingIgnoreCase(query);
    }

    /** Find all products whose price is within a given range. */
    public List<AbstractProduct> findByPriceRange(double min, double max) {
        return productRepository.findByPriceBetween(min, max);
    }
}
