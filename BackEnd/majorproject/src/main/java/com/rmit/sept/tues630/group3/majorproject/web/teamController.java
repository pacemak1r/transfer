package com.rmit.sept.tues630.group3.majorproject.web;

import com.rmit.sept.tues630.group3.majorproject.model.Account;
import com.rmit.sept.tues630.group3.majorproject.model.Team;
import com.rmit.sept.tues630.group3.majorproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/api/team")
public class teamController {

    @Autowired
    private CustomerService customerService;


    @PostMapping(value = "",headers = "accept=application/json")
    public ResponseEntity<?> createNewTeam(@Valid @RequestBody Team team, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error : result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }

        }
        Team account1 = customerService.saveOrUpdateAcount(team);
        return new ResponseEntity<Team>(team, HttpStatus.CREATED);
    }


}