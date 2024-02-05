package ubb.demo.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDetailedGuitarDTO {
    private Long id;
    private String brand;
    private String model;
    private Integer price;
    private Integer stock;
}
