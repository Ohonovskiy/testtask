package ua.rest.testtask.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ua.rest.testtask.dto.PersonDTO;
import ua.rest.testtask.models.Person;
import ua.rest.testtask.repositories.PeopleRepository;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PeopleControllerE2ETest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    PeopleRepository peopleRepository;

    @Test
    public void testGetPerson(){
        Person person = new Person();

        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.APRIL, 17);

        person.setFirstName("John");
        person.setSecondName("Doe");
        person.setDate(cal.getTime());

        peopleRepository.save(person);

        ResponseEntity<PersonDTO> response = restTemplate.getForEntity("/people/{id}", PersonDTO.class, person.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());

        PersonDTO personDTO = response.getBody();
        assertEquals("John", personDTO.getFirstName());
        assertEquals("Doe", personDTO.getSecondName());
        assertEquals(32, personDTO.getAge());
    }
}
