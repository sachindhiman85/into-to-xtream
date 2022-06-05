package com.xtream.repository;

import com.xtream.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    private List<Person> personList = new ArrayList<>();
    public Person getById(int id){
        Optional<Person> optionalPerson =  personList.stream().filter(p -> p.getId()==id).findFirst();
        if(optionalPerson.isPresent())
            return optionalPerson.get();
        else return null;
    }
    public List<Person> getAll(){
        return personList;
    }
    public void deleteById(int id){
        Optional<Person> optionalPerson =  personList.stream().filter(p -> p.getId()==id).findFirst();
        if(optionalPerson.isPresent())
            personList.remove(optionalPerson.get());
    }
    public void Add(Person person){
        personList.add(person);
    }

}
