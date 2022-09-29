
package com.miPortfolio.PortfolioFMC.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String fechaIE;
    private String fechaFE;
    
    //Constructores 

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String fechaIE, String fechaFE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaIE = fechaIE;
        this.fechaFE = fechaFE;
    }
    
    //Getters and setters 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
