package ubb.demo.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGuitarDTO implements Serializable {
    private String brand;
    private String model;
    private Integer price;
    private Integer stock;
}
