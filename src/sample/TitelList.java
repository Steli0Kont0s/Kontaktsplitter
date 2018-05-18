package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.stream.Stream;

public class TitelList {
    public static LinkedList<String> titelList;

    private static Path path = Paths.get("Titel.txt");

    public static void load() throws IOException {
        titelList = new LinkedList<>();
        Stream<String> stream = Files.lines(path);
        stream.forEach(s -> titelList.add(s));
    }

    public static void addTitel(String titel) throws IOException {
        titelList.add(titel);
        titel = System.lineSeparator() + titel;
        Files.write(path, titel.getBytes(),  StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
