
package com.miPortfolio.PortfolioFMC.Service;

import com.miPortfolio.PortfolioFMC.Entity.Persona;
import com.miPortfolio.PortfolioFMC.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona {
    @Autowired 
    IPersonaRepository rPersona;
    
    
    public List<Persona> getPersona() {
        List<Persona> persona = rPersona.findAll();
        return persona;
        }
        
    public List<Persona> list() {
        return rPersona.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return rPersona.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return rPersona.findByNombre(nombre);
    }
    
    public void save(Persona persona){
        rPersona.save(persona);
    }
    
    public void delete(int id){
        rPersona.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPersona.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rPersona.existsByNombre(nombre);
    }
    
     public Persona findPersona(int id) {
           Persona persona = rPersona.findById(id).orElse(null);
           return persona;
        }
}
