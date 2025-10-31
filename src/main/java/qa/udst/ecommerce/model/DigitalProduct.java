package qa.udst.ecommerce.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import jakarta.validation.constraints.NotBlank;

@Entity
@DiscriminatorValue("DIGITAL")
public class DigitalProduct extends AbstractProduct {

    @NotBlank(message = "Download URL is required.")
    private String downloadUrl;

    public DigitalProduct() {
    }

    public DigitalProduct(Long id, String name, double price, ProductCategory category, String downloadUrl) {
        super(id, name, price, category);
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
