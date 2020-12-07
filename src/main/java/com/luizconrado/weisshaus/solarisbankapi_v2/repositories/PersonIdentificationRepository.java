package com.luizconrado.weisshaus.solarisbankapi_v2.repositories;

import com.luizconrado.weisshaus.solarisbankapi_v2.model.PersonIdentification;
import org.springframework.data.repository.CrudRepository;

public interface PersonIdentificationRepository extends CrudRepository<PersonIdentification, String> {
}
