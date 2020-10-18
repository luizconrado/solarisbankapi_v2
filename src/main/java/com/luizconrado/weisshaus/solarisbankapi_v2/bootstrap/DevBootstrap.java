package com.luizconrado.weisshaus.solarisbankapi_v2.bootstrap;

import com.luizconrado.weisshaus.solarisbankapi_v2.model.AuthenticationToken;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.Person;
import com.luizconrado.weisshaus.solarisbankapi_v2.repositories.PersonRepository;
import com.luizconrado.weisshaus.solarisbankapi_v2.services.Authentication;
import com.luizconrado.weisshaus.solarisbankapi_v2.services.PersonEndpointQuery;
import com.luizconrado.weisshaus.solarisbankapi_v2.services.PersonMobileNumberEndpointQuery;
import com.luizconrado.weisshaus.solarisbankapi_v2.services.PersonTaxIdEndpointQuery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DevBootstrap implements CommandLineRunner {

    // Value injected from application-{profiles.active}.yaml
    // application-{profiles.active}.yaml is defined in the application.yaml file
    @Value("${solarisbank.environment}")
    String environment;

    private PersonRepository personRepository;

    public DevBootstrap(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Authentication auth = new Authentication();
        AuthenticationToken token = auth.getCredentials(environment);

        System.out.println(token.getAccessToken());

        List<Person> persons = new PersonEndpointQuery().getPersons(token, 1000, 1);
        persons.parallelStream().forEach(p -> new PersonMobileNumberEndpointQuery().getPersonMobileNumbers(token, 1000, 1, p));
        persons.parallelStream().forEach(p -> new PersonTaxIdEndpointQuery().getPersonTaxIDs(token, 1000, 1, p));
        System.out.println(persons);

        personRepository.saveAll(persons);

    }
}
