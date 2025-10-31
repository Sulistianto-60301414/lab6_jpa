package qa.udst.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import qa.udst.ecommerce.model.DigitalProduct;

public interface DigitalProductRepository extends JpaRepository<DigitalProduct, Long> {

}