package ua.rest.testtask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.rest.testtask.dto.PersonDTO;
import ua.rest.testtask.models.Person;
import ua.rest.testtask.services.PeopleService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable int id){
        return personToPersonDTO(peopleService.getById(id));
    }

    public PersonDTO personToPersonDTO(Person person){
        PersonDTO personDTO = new PersonDTO();

        if(person.getDate() != null) {
            Date personDate = person.getDate();
            LocalDate localDate = LocalDate.now();

            Instant instant = Instant.ofEpochMilli(personDate.getTime());
            Date date = Date.from(instant);

            LocalDate personLocalDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            personDTO.setAge(Period.between(personLocalDate, localDate).getYears());
        }
        personDTO.setFirstName(person.getFirstName());
        personDTO.setSecondName(person.getSecondName());

        return personDTO;
    }
}
