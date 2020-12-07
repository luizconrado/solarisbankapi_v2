package com.luizconrado.weisshaus.solarisbankapi_v2.bootstrap;

import com.luizconrado.weisshaus.solarisbankapi_v2.model.*;
import com.luizconrado.weisshaus.solarisbankapi_v2.repositories.PersonIdentificationAttemptRepository;
import com.luizconrado.weisshaus.solarisbankapi_v2.repositories.PersonIdentificationRepository;
import com.luizconrado.weisshaus.solarisbankapi_v2.repositories.PersonRepository;
import com.luizconrado.weisshaus.solarisbankapi_v2.repositories.PersonTaxIdRepository;
import com.luizconrado.weisshaus.solarisbankapi_v2.services.*;
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
    String solarisbankEnvironment;

    private PersonRepository personRepository;
    private PersonTaxIdRepository personTaxIdRepository;
    private PersonIdentificationRepository personIdentificationRepository;
    private PersonIdentificationAttemptRepository personIdentificationAttemptRepository;


    public DevBootstrap(PersonRepository personRepository, PersonTaxIdRepository personTaxIdRepository, PersonIdentificationRepository personIdentificationRepository, PersonIdentificationAttemptRepository personIdentificationAttemptRepository) {
        this.personRepository = personRepository;
        this.personTaxIdRepository = personTaxIdRepository;
        this.personIdentificationRepository = personIdentificationRepository;
        this.personIdentificationAttemptRepository = personIdentificationAttemptRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Instant start = Instant.now();

        SolarisbankAuthentication auth = new SolarisbankAuthentication();
        AuthenticationToken token = auth.getCredentials(solarisbankEnvironment);

        System.out.println(token.getAccessToken());

        List<Person> persons = new PersonEndpointQuery().getPersons(token, 1000, 1);
        persons.parallelStream().forEach(p -> new PersonMobileNumberEndpointQuery().getPersonMobileNumbers(token, 1000, 1, p));
//        System.out.println(persons);


        List<PersonTaxId> personTaxIds = persons.parallelStream()
                .map(p -> new PersonTaxIdEndpointQuery().getPersonTaxIDs(token, 1000, 1, p))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());


        List<PersonIdentification> personIdentifications = persons.parallelStream()
                .map(p -> new PersonIdentificationEndpointQuery().getPersonIdentifications(token, 1000, 1, p))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());


        List<PersonIdentificationAttempt> personIdentificationAttempts = personIdentifications.parallelStream()
                .map(pia -> new PersonIdentificationAttemptEndpointQuery().getPersonIdentificationAttempts(token, 1000, 1, pia))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());


        personRepository.saveAll(persons);
        personTaxIdRepository.saveAll(personTaxIds);
        personIdentificationRepository.saveAll(personIdentifications);
        personIdentificationAttemptRepository.saveAll(personIdentificationAttempts);


        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("Elapsed Time During Execution: " + timeElapsed + " milliseconds");
        System.out.println("Elapsed Time During Execution: " + timeElapsed/1000.0 + " seconds");


    }
}
