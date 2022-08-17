package br.com.controle_financeiro.controle_financeiro.Dtos;

import java.time.LocalDate;

public class RevenueDetalDto {
    
    private Long id;
    private double value;   
    private String name;  
    private String description;
    private LocalDate date;     
    
    
    
    public RevenueDetalDto(Long id, double value, String name, String description, LocalDate date) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.description = description;
        this.date = date;
    }
    
    public RevenueDetalDto() {
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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
