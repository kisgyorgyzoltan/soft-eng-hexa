package ubb.demo.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSimpleGuitarDTO {
    private Long id;
    private String brand;
    private String model;
    private Integer price;
}
