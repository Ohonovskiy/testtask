package ua.rest.testtask.controllers;

import org.junit.jupiter.api.Test;
import ua.rest.testtask.dto.PersonDTO;
import ua.rest.testtask.models.Person;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeopleControllerTest {
    @Test
    public void testPersonToPersonDTO() {
        Person person = new Person();
        person.setFirstName("John");
        person.setSecondName("Doe");
        person.setDate(Date.valueOf("2000-01-01"));

        PeopleController controller = new PeopleController(null);

        PersonDTO personDTO = controller.personToPersonDTO(person);

        assertEquals("John", personDTO.getFirstName());
        assertEquals("Doe", personDTO.getSecondName());
        assertEquals(23, personDTO.getAge());
    }

    @Test
    public void testPersonToPersonDTOWithNullValues() {
        Person person = new Person(1, null, null, null);
        PersonDTO expectedDTO = new PersonDTO();
        expectedDTO.setFirstName(null);
        expectedDTO.setSecondName(null);
        expectedDTO.setAge(0);

        PeopleController controller = new PeopleController(null);

        PersonDTO actualDTO = controller.personToPersonDTO(person);

        assertEquals(expectedDTO, actualDTO);
    }
}