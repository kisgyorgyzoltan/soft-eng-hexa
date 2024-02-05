package ubb.demo.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guitar {
    private Long id;
    private String brand;
    private String model;
    private Integer price;
    private Integer stock;
}
