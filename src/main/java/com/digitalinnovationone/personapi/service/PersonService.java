package com.digitalinnovationone.personapi.service;


import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = Person.builder()
                .firstName(personDTO.getFirstName())
                .lastName(personDTO.getFirstName())
                .birthData(personDTO.getBirthData())
                .phones(personDTO.getPhones())
                .build();

        Person savePerson = personRepository.save(personDTO);
        return MessageResponseDTO
                .builder()
                .message("Created Person with ID" + savePerson.getId())
                .build();
    }
}
