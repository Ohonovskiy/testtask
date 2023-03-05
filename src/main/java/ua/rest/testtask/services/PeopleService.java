package ua.rest.testtask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.rest.testtask.models.Person;
import ua.rest.testtask.repositories.PeopleRepository;

@Transactional
@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Person getById(int id){
        return peopleRepository.getReferenceById(id);
    }
}
