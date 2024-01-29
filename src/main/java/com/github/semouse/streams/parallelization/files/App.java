package com.github.semouse.streams.parallelization.files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static final String DIRECTORY = System.getProperty("user.dir") + "/test/";

    public static void main(String[] args) throws IOException {
        Files.createDirectory(Paths.get(DIRECTORY));

        App app = new App();
        List<Person> people = app.generatePeople(100000);
        long start = System.currentTimeMillis();
        people.stream().forEach(App::save);
        System.out.println("Time taken sequential: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        people.parallelStream().forEach(App::save);
        System.out.println("Time taken parallel: " + (System.currentTimeMillis() - start));
    }

    private static void save(Person person) {
        try (FileOutputStream output = new FileOutputStream(DIRECTORY + person.getPersonId() + ".txt")) {

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private List<Person> generatePeople(int n) {
        return Stream.iterate(0, i -> i + 1).limit(n).map(Person::new).collect(Collectors.toList());
    }
}
