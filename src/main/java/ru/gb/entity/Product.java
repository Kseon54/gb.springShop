package ru.gb.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table

@NamedQueries({
        @NamedQuery(name = "Product.findById",
                query = "select m from Product m where m.id = :id"),
        @NamedQuery(name = "Product.findNameById",
                query = "select m.title from Product m where m.id = :id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal cost;
    @Column(name = "manufacture_date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    public Product(String title, BigDecimal cost) {
        this.title = title;
        this.cost = cost;
    }

    public String getInfo() {
        return String.format("id: %d\t%s\tcost: %.2f", id, title, cost);
    }

    public Product copy() {
        return Product.builder()
                .id(getId())
                .title(getTitle())
                .cost(getCost())
                .build();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                ", manufacturer=" + manufacturer.getName() +
                '}';
    }
}
