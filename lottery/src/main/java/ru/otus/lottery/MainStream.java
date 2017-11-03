package ru.otus.lottery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;

/*
https://github.com/vitaly-chibrikov/otus_java_2017_11
*/

public class MainStream {
    public static void main(String[] args) throws IOException {
        String salt = "Speak, friend, and enter.";

        Files.lines(Paths.get("sql-54.csv"))
                .map(line -> line.replace("\"", ""))
                .map(line -> line.substring(0, line.indexOf("@")))
                .map(line -> line + "\t" + salt)
                .sorted(Comparator.comparingLong(String::hashCode))
                .map(line -> line.hashCode() + "\t" + line.replace(salt,""))
                .forEach(System.out::println);
    }
}
