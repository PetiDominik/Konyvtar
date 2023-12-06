package konyvtarprogram;

import java.util.Optional;

public class Konyvtar {
    private AbstractTermek[] termekek;
    
    public Konyvtar() {
        this.termekek = new AbstractTermek[]{new CD("Kiadó 1", "Cím 1"),
                            new Konyv("Szerző 1", false, "Cím 2"),
                            new Konyv("Szerző 2", true, "Cím 3"),
                            new CD("Kiadó 1", "Cím 4"),
                            new CD("Kiadó 1", "Cím 5"),
                            new Konyv("Szerző 1", true, "Cím 6")};
        
        this.termekek();
        this.kolcsonozhetok();
        
        int index = (int)(Math.random() * this.termekek.length);
        String termekId = this.termekek[index].getId().toString();
        Optional<AbstractTermek> kolcsonzott = this.felvesz(termekId);
        
        if (kolcsonzott.isEmpty()) {
            System.out.println("Nem kölcsönözhető ez a könyv!");
        } else {
            System.out.printf("---------A kikölcsönzött könyv: \n%s\n", kolcsonzott.get().toString());
        }
    }
    
    public void termekek() {
        System.out.println("---------Termékek:");
        for (AbstractTermek termek : this.termekek) {
            System.out.println(termek);
        }
    }
    
    public void kolcsonozhetok() {
        System.out.println("---------Kölcsönözhető termékek:");
        for (AbstractTermek termek : this.termekek) {
            if (termek instanceof Kolcsonozheto) {
                System.out.println(termek);
            }
        }
    }
    
    public Optional<AbstractTermek> felvesz(String termekId) {
        AbstractTermek termek;
        int i = 0;
        while (i < this.termekek.length && !this.termekek[i].getId().toString().equals(termekId)) {
            i++;
        }
        if (i < this.termekek.length) {
            termek = this.termekek[i];
            if (termek instanceof Kolcsonozheto) {
                return Optional.of(termek);
            }
        }
        return Optional.empty();
    }
}
