package com.luizconrado.weisshaus.solarisbankapi_v2.repositories;

import com.luizconrado.weisshaus.solarisbankapi_v2.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
}