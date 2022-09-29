
package com.miPortfolio.PortfolioFMC.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String fechaIE;
    @NotBlank
    private String fechaFE;


    //Constructor
    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String fechaIE, String fechaFE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaIE = fechaIE;
        this.fechaFE = fechaFE;
    }
 //Getters and Setters 
    
    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getFechaIE() {
        return fechaIE;
    }

    public void setFechaIE(String fechaIE) {
        this.fechaIE = fechaIE;
    }

    public String getFechaFE() {
        return fechaFE;
    }

    public void setFechaFE(String fechaFE) {
        this.fechaFE = fechaFE;
    }
    
       
    
}
