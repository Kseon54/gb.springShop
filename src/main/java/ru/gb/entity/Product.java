package ru.gb.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gb.entity.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product extends BaseEntity<Product> {
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

    @Enumerated(EnumType.STRING)
    private Status status;

    @Version
    @Column(name = "VERSION")
    private int version;
    @CreatedBy
    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;
    @CreatedDate
    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;
    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;
    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDate lastModifiedDate;

    public Product(String title, BigDecimal cost, Manufacturer manufacturer) {
        this.title = title;
        this.cost = cost;
        this.manufacturer = manufacturer;
        date = LocalDate.now();
    }

    @Override
    public Product clone() {
        return Product.builder()
                .id(getId())
                .title(getTitle())
                .cost(getCost())
                .date(date)
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
