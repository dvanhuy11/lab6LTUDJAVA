package com.example.lab6.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Column
    private String name;

    @Length(min = 0, max = 50, message = "Tên hình ảnh không được quá 50 ký tự")
    @Column
    private String image;

    @NotNull(message = "Giá sản phẩm không được để trống")
    @Min(value = 1, message = "Giá sản phẩm không được nhỏ hơn 1")
    @Max(value = 999999999, message = "Giá sản phẩm không được lớn hơn 999999999")
    @Column
    private long price;
}
