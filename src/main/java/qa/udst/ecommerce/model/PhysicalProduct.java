package qa.udst.ecommerce.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@DiscriminatorValue("PHYSICAL")
public class PhysicalProduct extends AbstractProduct {

    @Min(value = 0, message = "Weight must be positive.")
    private double weightKg;

    @NotBlank(message = "Dimensions are required.")
    private String dimensions;

    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price, ProductCategory category,
            double weightKg, String dimensions) {
        super(id, name, price, category);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
