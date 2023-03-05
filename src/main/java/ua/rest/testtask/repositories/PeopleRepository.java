package ua.rest.testtask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.rest.testtask.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
