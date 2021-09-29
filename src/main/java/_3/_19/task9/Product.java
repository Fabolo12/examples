package _3._19.task9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private String category;
    @With private Double price;
}
