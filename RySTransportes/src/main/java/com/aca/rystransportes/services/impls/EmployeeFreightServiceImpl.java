package com.aca.rystransportes.services.impls;

import com.aca.rystransportes.models.dtos.EmpFreightInfo;
import com.aca.rystransportes.models.dtos.PageableDTO;
import com.aca.rystransportes.models.entities.EmployeeFreight;
import com.aca.rystransportes.models.entities.Freights;
import com.aca.rystransportes.models.entities.User;
import com.aca.rystransportes.repositories.EmployeeFreightRepository;
import com.aca.rystransportes.repositories.EmployeeFreightRepositoryPageable;
import com.aca.rystransportes.repositories.FreightsRepository;
import com.aca.rystransportes.services.EmployeeFreightService;
import com.aca.rystransportes.services.FreightsService;
import com.aca.rystransportes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeFreightServiceImpl implements EmployeeFreightService {

    @Autowired
    EmployeeFreightRepository eFRepository;

    @Autowired
    EmployeeFreightRepositoryPageable eFRepositoryPageable;

    @Autowired
    private UserService userService;
    
    @Autowired
    private FreightsService freightsService;

    @Override
    public List<EmployeeFreight> getAllEmployeeFreight() {
        return eFRepository.findAll();
    }

    @Override
    public EmployeeFreight getEmployeeFreightById(Integer id) {
        return eFRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Entity not found with id :" + id ));
    }

    @Override
    public void createEmployeeFreight(EmpFreightInfo employeeFreightInfo) throws Exception {
        EmployeeFreight empF = new EmployeeFreight();
        User user = userService.findOneById(employeeFreightInfo.getUser());
        Freights freight = freightsService.getFreightsById(employeeFreightInfo.getFreight());

        empF.setFreight(freight);
        empF.setPosition(employeeFreightInfo.getPosition());
        empF.setPayment(employeeFreightInfo.getPayment());
        empF.setViatic(employeeFreightInfo.getViatic());
        empF.setExtraPayment(employeeFreightInfo.getExtraPayment());
        empF.setFreightdate(freight.getDate());
        empF.setUser(user);

        eFRepository.save(empF);
    }

    @Override
    public void deleteEmployeeFreight(Integer id) {
        eFRepository.deleteById(id);
    }

    @Override
    public EmployeeFreight updateEmployeeFreight(EmployeeFreight employeeFreight) {
        eFRepository.findById(employeeFreight.getIdEmployeeFreight()).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found with id : "+employeeFreight.getIdEmployeeFreight()) );
        return eFRepository.save(employeeFreight);
    }

	@Override
	public List<EmployeeFreight> getAllEmployeeFreightByFreight(Integer idFreight) {
		Freights freight = freightsService.getFreightsById(idFreight);
		return eFRepository.findAllByFreight(freight);
	}

	@Override
	public List<EmployeeFreight> getAllEmployeeFreightByUser(User user) {
		return eFRepository.findAllByUser(user);
	}

    @Override
    public List<EmployeeFreight> getAllFreightByUserPageable(PageableDTO info, User user) {
        PageRequest request = PageRequest
                .of(info.getPage(), info.getLimit());
        return eFRepositoryPageable.findAllByUserOrderByFreightdateDescIdEmployeeFreightAsc(request, user);
    }
}
