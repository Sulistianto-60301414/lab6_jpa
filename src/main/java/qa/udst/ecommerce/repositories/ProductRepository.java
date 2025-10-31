package qa.udst.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import qa.udst.ecommerce.model.AbstractProduct;

public interface ProductRepository extends JpaRepository<AbstractProduct, Long> {
    List<AbstractProduct> findByNameContainingIgnoreCase(String q);

    List<AbstractProduct> findByPriceBetween(double min, double max);
}