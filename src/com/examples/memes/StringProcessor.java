package com.examples.memes;

public class StringProcessor {
    public static final String INPUT_DATA = "Login;Name;Email" + System.lineSeparator() +
            "peterson;Chris Peterson;peterson@outlook.com" + System.lineSeparator() +
            "james;Derek James;james@gmail.com" + System.lineSeparator() +
            "jackson;Walter Jackson;jackson@gmail.com" + System.lineSeparator() +
            "gregory;Mike Gregory;gregory@yahoo.com";

    public static void main(String[] args) {
        System.out.println("===== Convert 1 demo =====");
        System.out.println(convert1(INPUT_DATA));

        System.out.println("===== Convert 2 demo =====");
        System.out.println(convert2(INPUT_DATA));

    }

    public static String convert1(String input) {
        StringBuilder builder = new StringBuilder();
        String[] lines = input.split(System.lineSeparator());
        for (int i = 1; i < lines.length; i++) {
            String[] words = lines[i].split(";");
            builder.append(words[0]).append("==>").append(words[2]).append(System.lineSeparator());
        }
        return builder.toString();
    }


    public static String convert2(String input) {
        StringBuilder builder = new StringBuilder();
        String[] lines = input.split(System.lineSeparator());
        for (int i = 1; i < lines.length; i++) {
            String[] words = lines[i].split(";");
            builder.append(words[1]).append(" (email: ").append(words[2]).append(")").append(System.lineSeparator());
        }
        return builder.toString();
    }
}
