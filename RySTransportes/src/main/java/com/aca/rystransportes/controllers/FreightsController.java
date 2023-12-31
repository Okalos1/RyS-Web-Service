package com.aca.rystransportes.controllers;

import com.aca.rystransportes.models.dtos.MessageDTO;
import com.aca.rystransportes.models.dtos.PageableDTO;
import com.aca.rystransportes.models.dtos.FreightsDTO;
import com.aca.rystransportes.models.entities.Freights;
import com.aca.rystransportes.services.impls.FreightsServiceImpl;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/freights")
@CrossOrigin
public class FreightsController {
    @Autowired
    FreightsServiceImpl freightsService;

    @GetMapping()
    public List<Freights> showFreights(){
        return freightsService.getAllFreights();
    }
    
    @GetMapping("/pageable")
	public ResponseEntity<?> findAllBooks(@Valid PageableDTO info, BindingResult result) {			
		 if(result.hasErrors()) {
		        return new ResponseEntity<>(
		            null,
		            HttpStatus.BAD_REQUEST
		        );
		    }
		    
		    try {
		        //User userAuth = userService.getUserAuthenticated();
		        //System.out.println(userAuth.getName());
		    	
		        List<Freights> freights = freightsService.getAllFreightsPageable(info);
		        
		        return new ResponseEntity<>(
		            freights,
		            HttpStatus.OK
		        );
		    } catch (Exception e) {
		        return new ResponseEntity<>(
		        		new MessageDTO("Error interno de servidor" + e.getMessage()),
		            HttpStatus.INTERNAL_SERVER_ERROR
		        );
		    }
	}

    @GetMapping("/id")
    public Freights getFreights(@PathVariable Integer id){
        return freightsService.getFreightsById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<MessageDTO> createdFreights(@Valid FreightsDTO freights, BindingResult result) {
        try {
            if(result.hasErrors()) {
                String errors = result.getAllErrors().toString();


                return new ResponseEntity<>(
                        new MessageDTO("Hay errores: " + errors),
                        HttpStatus.BAD_REQUEST
                );
            }
            freightsService.createFreights(freights);

            return new ResponseEntity<>(
                    new MessageDTO("Flete Registrado"),
                    HttpStatus.CREATED
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new MessageDTO("Error interno "+ e.getMessage()+" "+ freights.getUnits()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PutMapping()
    public ResponseEntity<MessageDTO> updateFreights(@Valid FreightsDTO freights, BindingResult result){

        try {
            if(result.hasErrors()) {
                String errors = result.getAllErrors().toString();


                return new ResponseEntity<>(
                        new MessageDTO("Hay errores: " + errors),
                        HttpStatus.BAD_REQUEST
                );
            }
            freightsService.updateFreights(freights);

            return new ResponseEntity<>(
                    new MessageDTO("Flete Actualizado"),
                    HttpStatus.CREATED
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new MessageDTO("Error interno "+ e.getMessage()+" " + freights.getClient()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping(value = {"/id"})
    public @ResponseBody String deleteFreights(@PathVariable("id") Integer id){
        freightsService.deleteFreights(id);
        return null;
    }
}
