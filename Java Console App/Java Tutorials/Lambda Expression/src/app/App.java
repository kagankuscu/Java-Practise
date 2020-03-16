package app;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        RosterTest rosterTest = new RosterTest();

        List<Person> roster = Person.createRoster();

        for (Person p : roster) {
            p.printPerson();
        }
        System.out.println();

        System.out.println("Persons older than 20:");
        rosterTest.printPersonsOlderThan(roster, 20);
        System.out.println();

        System.out.println("Persons between the ages of 14 and 30:");
        rosterTest.printPersonsWithinAgeRange(roster, 14, 30);
        System.out.println();

        System.out.println("Persons who are eligible for Selective Service:");
        rosterTest.printPersons(roster, new CheckPersonEligibleForSelectiveService());
        System.out.println();

        System.out.println("Persons who are eligible for Selective Service " + "(anonymous class):");
        rosterTest.printPersons(roster, new CheckPerson() {

            @Override
            public boolean test(Person p) {
                return p.getAge() >= 18 && p.getAge() <= 25;
            }
        });
        System.out.println();

        System.out.println("Persons who are eligible for Selective Service " + "(lambda expression):");
        rosterTest.printPersons(roster,
                (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
        System.out.println();

        System.out.println("Persons who are eligible for Selective Service " + "(with Predicate parameter):");
        rosterTest.printPersonsWithPredicate(roster,
                p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
        System.out.println();

        System.out.println(
                "Persons who are eligible for Selective Service " + "(with Predicate and Consumer parameters):");
        rosterTest.processPersons(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
                p -> p.printPerson());
        System.out.println();

        System.out.println("Persons who are eligible for Selective Service "
                + "(with Predicate, Function, and Consumer parameters):");
        rosterTest.processPersonsWithFunction(roster,
                p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25, p -> p.getEmailAddress(),
                email -> System.out.println(email));
        System.out.println();

        System.out.println("Persons who are eligible for Selective Service " + "(generic version):");
        rosterTest.processElements(roster,
                p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25, p -> p.getEmailAddress(),
                email -> System.out.println(email));
        System.out.println();

        System.out.println("Persons who are eligible for Selective Service " + "(with bulk data operations):");
        roster.stream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25).map(p -> p.getEmailAddress()).forEach(System.out::println);

    }
}