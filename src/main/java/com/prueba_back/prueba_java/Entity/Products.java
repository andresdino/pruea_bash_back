package com.prueba_back.prueba_java.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "IDProducts")
    private Long id;

    @Column(name = "Name", length = 255)
    private String name;

    @Column(name = "Value")
    private Float value;

    @Column(name = "Weight", length = 255)
    private String weight;

    @Column(name = "Quantity")
    private Long quantity;
}
