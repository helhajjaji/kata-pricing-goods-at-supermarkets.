package com.sgcib.superMarketPricing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Discount implements Serializable {

    private Long id;
    private String type;
    private List<Product> products;
}
