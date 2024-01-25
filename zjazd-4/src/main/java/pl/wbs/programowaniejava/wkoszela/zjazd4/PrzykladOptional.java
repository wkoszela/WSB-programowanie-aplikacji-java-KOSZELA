package pl.wbs.programowaniejava.wkoszela.zjazd4;


public class PrzykladOptional {

    public static void main(String[] args) {
        String name = "Filemon";
        Cat filemon = findCatByName(name);

        if(filemon.getName() != null){
            filemon.getName();
            System.out.println();
        }
        else {
            System.out.printf("Nie znaleziono Kota");
        }

    }


    private static Cat findCatByName(String name){
        Cat cat = new Cat(name);
        return null;
    }
}
