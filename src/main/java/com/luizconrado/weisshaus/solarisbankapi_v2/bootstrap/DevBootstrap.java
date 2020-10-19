package com.luizconrado.weisshaus.solarisbankapi_v2.bootstrap;

import com.luizconrado.weisshaus.solarisbankapi_v2.model.AuthenticationToken;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.Person;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.PersonTaxId;
import com.luizconrado.weisshaus.solarisbankapi_v2.repositories.PersonRepository;
import com.luizconrado.weisshaus.solarisbankapi_v2.repositories.PersonTaxIdRepository;
import com.luizconrado.weisshaus.solarisbankapi_v2.services.Authentication;
import com.luizconrado.weisshaus.solarisbankapi_v2.services.PersonEndpointQuery;
import com.luizconrado.weisshaus.solarisbankapi_v2.services.PersonMobileNumberEndpointQuery;
import com.luizconrado.weisshaus.solarisbankapi_v2.services.PersonTaxIdEndpointQuery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DevBootstrap implements CommandLineRunner {

    // Value injected from application-{profiles.active}.yaml
    // application-{profiles.active}.yaml is defined in the application.yaml file
    @Value("${solarisbank.environment}")
    String environment;

    private PersonRepository personRepository;
    private PersonTaxIdRepository personTaxIdRepository;


    public DevBootstrap(PersonRepository personRepository, PersonTaxIdRepository personTaxIdRepository) {
        this.personRepository = personRepository;
        this.personTaxIdRepository = personTaxIdRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Instant start = Instant.now();

        Authentication auth = new Authentication();
        AuthenticationToken token = auth.getCredentials(environment);

        System.out.println(token.getAccessToken());

        List<Person> persons = new PersonEndpointQuery().getPersons(token, 1000, 1);
        persons.parallelStream().forEach(p -> new PersonMobileNumberEndpointQuery().getPersonMobileNumbers(token, 1000, 1, p));

        personRepository.saveAll(persons);

        List<PersonTaxId> personTaxIds = persons.parallelStream()
                .map(p -> new PersonTaxIdEndpointQuery().getPersonTaxIDs(token, 1000, 1, p))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(persons);


        personTaxIdRepository.saveAll(personTaxIds);


        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("Elapsed Time During Execution: " + timeElapsed + " milliseconds");
        System.out.println("Elapsed Time During Execution: " + timeElapsed/1000.0 + " seconds");


    }
}
