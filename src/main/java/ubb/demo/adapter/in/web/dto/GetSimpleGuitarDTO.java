package ubb.demo.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSimpleGuitarDTO implements Serializable {
    private Long id;
    private String brand;
    private String model;
    private Integer price;
}
