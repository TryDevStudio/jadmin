package io.github.tacehex.jadmin.demo.model;

import io.github.tacehex.jadmin.core.annotation.JAdminEntity;
import io.github.tacehex.jadmin.core.annotation.JAdminField;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@JAdminEntity(displayName = "Товары", order = 2)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JAdminField(displayName = "ID", order = 1, showInCreate = false)
    private Long id;

    @JAdminField(displayName = "Название", order = 2)
    private String name;

    @JAdminField(displayName = "Цена", order = 3)
    private BigDecimal price;

    @JAdminField(displayName = "В наличии", order = 4)
    private Boolean inStock = true;

    public Product() {
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }
}