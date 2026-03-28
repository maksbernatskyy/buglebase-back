package org.lessons.java.games.buglebase_back.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "The name is required")
    @NotBlank(message = "The name can't be empty")
    private String name;

    @NotBlank(message = "The description can't be empty")
    private String description;

    @NotNull(message = "The release date is required")
    @NotBlank(message = "The release date can't be empty")
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @NotNull(message = "The price is required")
    @NotBlank(message = "The price can't be empty")
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal price;

    // Getter and Setter

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name != null) {
            this.name = name;
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if(description != null) {
            this.description = description;
        }
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        if(releaseDate != null) {
            this.releaseDate = releaseDate;
        }
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        if(price != null && price.compareTo(BigDecimal.ZERO) > 0) {
            this.price = price;
        }
    }


}
