package org.lessons.java.games.buglebase_back.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "studios")
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "The name of studio is required")
    @NotBlank(message = "The name of can't be empty")
    private String name;

    @NotNull(message = "The headquarters of studio is required")
    @NotBlank(message = "The headquarters of studio can't be empty")
    private String headquarters;

    @NotNull(message = "The year of foundation of studio is required")
    @Column(name = "year_of_foundation", nullable = false)
    @Min(value = 1900)
    @Max(value = 2026)
    private int yearFoundation;

    @OneToMany(mappedBy = "studio")
    private List<Game> games;

    // Getter and Setter

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        if (id != null) {
            this.id = id;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getHeadquarters() {
        return this.headquarters;
    }

    public void setHeadquarters(String headquarters) {
        if (headquarters != null) {
            this.headquarters = headquarters;
        }
    }

    public int getYearFoundation() {
        return this.yearFoundation;
    }

    public void setYearFoundation(int yearFoundation) {
        this.yearFoundation = yearFoundation;
    }

}
