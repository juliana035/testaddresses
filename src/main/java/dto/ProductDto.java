package dto;
import com.Coffeetest.model.ProductModel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String nameProducts;
    private String size;
    private String descriptionProducts;
    private String imageProducts;
    private Double price;

    public ProductDto(ProductModel.Product product) {
        this.id = product.getId();
        this.nameProducts = product.getNameProducts();
        this.size = product.getSize();
        this.descriptionProducts = product.getDescriptionProducts();
        this.imageProducts = product.getImageProducts();
        this.price = product.getPrice();

    }
    public static Page<ProductDto> convert(Page<ProductModel.Product> product) {
        return product.map(ProductDto::new);



    }
}




