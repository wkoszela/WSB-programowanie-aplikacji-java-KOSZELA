package pl.wbs.programowaniejava.wkoszela.zjazd4.optional;


import java.util.Optional;

public class PrzykladOptional {

    public static void main(String[] args) {
        String name = "Filemon";
        Optional<Cat> filemon = findSecuredCatByName(name);
        System.out.println(filemon.isPresent());

    }


    private static Cat findCatByName(String name){
        Cat cat = new Cat(name);
        return null;
    }

    private static Optional<Cat> findSecuredCatByName(String name){
        Cat cat = new Cat(name);
        return Optional.of(cat);

    }
}
