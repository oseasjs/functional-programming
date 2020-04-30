package br.com.functional.programming.mock;

import br.com.functional.programming.dto.Person;

import java.util.List;

public interface PersonMock {

    final Person MIKE =  new Person("Mike", 20);
    final Person NANCY =  new Person("Nancy", 25);
    final Person JOHN =  new Person("John", 15);
    final Person JULIE =  new Person("Julie", 35);

    final List<Person> PERSON_LIST_WITH_MIKE = List.of(MIKE, NANCY, JOHN, JULIE);
    final List<Person> PERSON_LIST_WITHOUT_MIKE = List.of(NANCY, JOHN, JULIE);

}
