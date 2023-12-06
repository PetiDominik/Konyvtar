package konyvtarprogram;

import java.util.Optional;

public class Konyvtar {
    private AbstractTermek[] termekek;
    
    public Konyvtar() {
        //this.termekek = {};
        
        this.termekek();
        this.kolcsonozhetok();
        
        int index = (int)(Math.random() * this.termekek.length);
        String termekId = this.termekek[index].getId().toString();
        Optional<AbstractTermek> kolcsonzott = this.felvesz(termekId);
        
        if (kolcsonzott.isEmpty()) {
            System.out.println("Nem található ilyen id!");
        } else {
            System.out.printf("A kikölcsönzött könyv: %s\n", kolcsonzott.get().toString());
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
            if (termek.getClass().isInstance(AbstractTermek.class)) {
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
            if (termek.getClass().isInstance(Kolcsonozheto.class)) {
                return Optional.of(termek);
            }
        }
        return Optional.empty();
    }
}
