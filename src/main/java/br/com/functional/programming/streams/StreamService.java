package br.com.functional.programming.streams;

import br.com.functional.programming.dto.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamService {

    public Person getNewestPerson(List<Person> list) {

        return list
                .stream()
                .min(Comparator.comparingInt(Person::getAge))
                .get();

    }

    public Person getOlderPerson(List<Person> list) {

        return list
                .stream()
                .max(Comparator.comparingInt(Person::getAge))
                .get();

    }

    public Integer getLowestAge(List<Person> list) {

        return list
                .stream()
                .mapToInt(p -> p.getAge())
                .min()
                .getAsInt();

    }

    public Integer getHighestAge(List<Person> list) {

        return list
                .stream()
                .mapToInt(Person::getAge)
                .max()
                .orElseThrow(() -> new RuntimeException());

    }

    public List<Person> getPeopleAgeHigherThan(List<Person> list, Integer age) {

        return list
                .stream()
                .filter(p -> p.getAge().compareTo(age) > 0)
                .collect(Collectors.toList());

    }

    public List<Person> diffBetween(List<Person> listA, List<Person> listB) {

        return listA.stream()
                .filter(personA -> listB
                    .stream()
                    .filter(personB -> personA.getName().equals(personB.getName()))
                    .findAny()
                    .isEmpty()
                )
                .collect(Collectors.toList());

    }

    public List<Person> interceptionBetween(List<Person> listA, List<Person> listB) {

        return listA.stream()
                .filter(personA -> listB
                        .stream()
                        .filter(personB -> personA.getName().equals(personB.getName()))
                        .findAny()
                        .isPresent()
                )
                .collect(Collectors.toList());

    }

    public List<Person> findByNameStartingWith(List<Person> list, String name) {

        return list.stream()
                .filter(p -> p.getName().startsWith(name))
                .collect(Collectors.toList());

    }

    public List<String> getNames(List<Person> list) {

        return list.stream()
                .flatMap(p -> Stream.of(p.getName()))
                .collect(Collectors.toList());

    }

}
