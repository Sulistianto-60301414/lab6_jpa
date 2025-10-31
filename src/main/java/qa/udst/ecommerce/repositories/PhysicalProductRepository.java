package qa.udst.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import qa.udst.ecommerce.model.PhysicalProduct;

public interface PhysicalProductRepository extends JpaRepository<PhysicalProduct, Long> {

}