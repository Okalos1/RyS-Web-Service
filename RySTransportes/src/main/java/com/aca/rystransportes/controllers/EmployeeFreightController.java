package com.aca.rystransportes.controllers;

import com.aca.rystransportes.models.dtos.EmpFreightInfo;
import com.aca.rystransportes.models.dtos.MessageDTO;
import com.aca.rystransportes.models.entities.EmployeeFreight;
import com.aca.rystransportes.models.entities.User;
import com.aca.rystransportes.repositories.UserRepository;
import com.aca.rystransportes.services.UserService;
import com.aca.rystransportes.services.impls.EmployeeFreightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empfreight")
public class EmployeeFreightController {
	
    @Autowired
    UserService userService;
    
    @Autowired
    EmployeeFreightServiceImpl employeeFreightService;

    @GetMapping()
    public List<EmployeeFreight> showEmployeeFreight() {
        return employeeFreightService.getAllEmployeeFreight();
    }

    @GetMapping("/{id}")
    public EmployeeFreight getEmployeeFreight(@PathVariable Integer id) {
        return employeeFreightService.getEmployeeFreightById(id);
    }
    
    @GetMapping("/idFreight/{idFreight}")
    public List<EmployeeFreight> getEmployeeFreightByFreight(@PathVariable Integer idFreight) {
        return employeeFreightService.getAllEmployeeFreightByFreight(idFreight);
    }
    
    @GetMapping("/me")
    public List<EmployeeFreight> getEmployeeFreightByUser() {
    	List<EmployeeFreight> freightsByUser;
        try {
        	freightsByUser = employeeFreightService.getAllEmployeeFreightByUser(userService.getUserAuthenticated());
        	return freightsByUser;
        } catch (Exception e) {
        	freightsByUser = null;
            return freightsByUser;
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<MessageDTO> createEmployeeFreight(EmpFreightInfo empFreightInfo, BindingResult result) {
        try {
            if(result.hasErrors()) {
                String errors = result.getAllErrors().toString();


                return new ResponseEntity<>(
                        new MessageDTO("Hay errores: " + errors),
                        HttpStatus.BAD_REQUEST
                );
            }

            employeeFreightService.createEmployeeFreight(empFreightInfo);

            return new ResponseEntity<>(
                    new MessageDTO("Usuario asignado a flete"),
                    HttpStatus.CREATED
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new MessageDTO("Error interno"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PutMapping()
    public EmployeeFreight updateEmployeeFreight(@RequestBody EmployeeFreight user) {
        return employeeFreightService.updateEmployeeFreight(user);
    }

    @DeleteMapping(value = "{id}")
    public @ResponseBody String deleteEmployeeFreight(@PathVariable("id")  Integer id ) {
        employeeFreightService.deleteEmployeeFreight(id);
        return null;
    }
}
