package pl.wbs.programowaniejava.wkoszela.zjazd4.strumienie.przyklad44;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File(".");
        System.out.println("Absolute path: " + file.getCanonicalFile().getAbsolutePath());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Is directory: " + file.isFile());
        System.out.println("Is directory: " + file.exists());

        Optional.ofNullable(file.listFiles()).stream().flatMap(Arrays::stream)
                .forEach(subFile -> {
                    try {
                        System.out.println("Sub file absolute path: " + subFile.getCanonicalFile().getAbsolutePath());
                    } catch (Exception ex) {
                        System.out.println("Something went wrong: " + ex.getMessage());
                    }
                });

        Path path = file.toPath().toAbsolutePath().normalize();
        System.out.println("Absolute path: " + path.toString());
        System.out.println("Parent absolute path: " + path.getParent().toString());

        // Metoda list przechodzi tylko przez bezpośrednie elementy w danym katalogu, bez zagłębiania się w podkatalogi.
        try (Stream<Path> stream = Files.list(path)) {
            stream.forEach(subPath -> {
                System.out.println("Sub file absolute path: " + subPath.toAbsolutePath().toString());
            });
        }

        // Metoda walk jest bardziej rozbudowana i rekurencyjnie przechodzi przez wszystkie pliki i katalogi, zaczynając od danego katalogu.
        try (Stream<Path> stream = Files.walk(path, 2)) {
            stream.forEach(subPath -> {
                System.out.println("Sub file absolute path: " + subPath.toAbsolutePath().toString());
            });
        }

        // umożliwia dostosowanie zachowania poprzez dostarczenie własnego obiektu implementującego interfejs
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path subPath, BasicFileAttributes attrs) {
                if (!Files.isDirectory(subPath) && subPath.toString().endsWith("java")) {
                    System.out.println("Sub file absolute path: " + subPath.toAbsolutePath().toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
