package pl.wbs.programowaniejava.wkoszela.zjazd4;


import java.util.Optional;

public class PrzykladOptional {

    public static void main(String[] args) {
        String name = "Filemon";
        Cat filemon = findCatByName(name);

        if(filemon != null){
            filemon.getName();
            System.out.println();
        }
        else {
            System.out.println("Nie znaleziono Kota");
        }

    }


    private static Cat findCatByName(String name){
        Cat cat = new Cat(name);
        return null;
    }
}
