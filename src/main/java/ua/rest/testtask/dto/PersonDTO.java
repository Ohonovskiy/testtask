package ua.rest.testtask.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    @Column(name = "person_first_name")
    private String firstName;

    @Column(name = "person_second_name")
    private String secondName;

    private int age;
}
