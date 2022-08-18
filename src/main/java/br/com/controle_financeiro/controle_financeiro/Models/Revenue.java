package br.com.controle_financeiro.controle_financeiro.Models;


import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Revenue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value;
    @NotNull(message = "value blank or void") @NotBlank(message = "value blank or void")   
    private String name;
    @NotNull(message = "value blank or void") @NotBlank(message = "value blank or void")
    private String description; 
    private LocalDate date;
    

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    

    
}
