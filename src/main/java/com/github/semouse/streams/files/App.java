package com.github.semouse.streams.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        String path = "C:\\Users\\lbarok\\IdeaProjects\\Jat\\oop\\src\\com\\examples\\streams\\files\\names.txt";
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            List<String> names = lines.toList();
            names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
