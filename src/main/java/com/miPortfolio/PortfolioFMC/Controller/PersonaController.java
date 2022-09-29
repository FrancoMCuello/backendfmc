
package com.miPortfolio.PortfolioFMC.Controller;

import com.miPortfolio.PortfolioFMC.Dto.dtoPersona;
import com.miPortfolio.PortfolioFMC.Entity.Persona;
import com.miPortfolio.PortfolioFMC.Security.Controller.Mensaje;
/*import com.miPortfolio.PortfolioFMC.Interface.IPersonaService;*/
import com.miPortfolio.PortfolioFMC.Service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontendfmc.web.app")
public class PersonaController {
    
    @Autowired SPersona sPersona;
    
    
    @GetMapping("/traer")
    public List<Persona> getPersona (){
        return sPersona.getPersona();
    }
    
    @GetMapping ("/personas/traer/perfil")
    @ResponseBody
    public Persona findPersona(int id){
        return sPersona.findPersona((int)1);
    }
    
    @GetMapping("/lista")
public ResponseEntity<List<Persona>> list(){
    List <Persona> list = sPersona.list();
    return new ResponseEntity(list, HttpStatus.OK);        
}    

@GetMapping("/detail/{id}")
public ResponseEntity<Persona> getById(@PathVariable("id") int id){
    if(!sPersona.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.BAD_REQUEST);
    }
    
    Persona persona = sPersona.getOne(id).get();
    return new ResponseEntity(persona,HttpStatus.OK);
}

@PreAuthorize("hasRole('ADMIN')")
@DeleteMapping("/delete/{id}")
public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!sPersona.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
    }
    sPersona.delete(id);   
    return new ResponseEntity(new Mensaje("Perfil eliminada correctamente"), HttpStatus.OK);
}

@PreAuthorize("hasRole('ADMIN')")
@PostMapping("/create")
public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
    if(StringUtils.isBlank(dtopersona.getNombre())){
        return new ResponseEntity(new Mensaje("El nombre es Obligatorio"),HttpStatus.BAD_REQUEST);
    }
    if(sPersona.existsByNombre(dtopersona.getNombre())){
        return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
    }
    
    Persona persona = new Persona (dtopersona.getNombre(), dtopersona.getApellido(), dtopersona.getProfesion(), dtopersona.getDescripcion(), dtopersona.getImg());
    
    sPersona.save(persona);
    return new ResponseEntity(new Mensaje("Se cargo la eduacacion correctamente"),HttpStatus.OK);
}

@PreAuthorize("hasRole('ADMIN')")
@PutMapping("/update/{id}")
public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
    if(!sPersona.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe este ID"),HttpStatus.NOT_FOUND);}
    if(sPersona.existsByNombre(dtopersona.getNombre()) && sPersona.getByNombre(dtopersona.getNombre()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
    }
    
    if(StringUtils.isBlank(dtopersona.getNombre())){
        return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
    }
    
    Persona persona = sPersona.getOne(id).get();
    
    persona.setNombre(dtopersona.getNombre());
    persona.setApellido(dtopersona.getApellido());
    persona.setProfesion(dtopersona.getProfesion());
    persona.setDescripcion(dtopersona.getDescripcion());
    
    sPersona.save(persona);
    
    return new ResponseEntity(new Mensaje("Perfil editado"),HttpStatus.OK);
}

}


    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
/*
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaService.savePersona(persona);
        return persona; 
    }
    
    @GetMapping ("/personas/traer/perfil")
    @ResponseBody
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
} */
