package konyvtarprogram;

public class Konyv extends AbstractTermek implements Kolcsonozheto{

    private String szerzo;
    private boolean kolcsonzottE;

    public Konyv(String szerzo, boolean kolcsonzottE, String cim) {
        super(cim);
        this.szerzo = szerzo;
        this.kolcsonzottE = kolcsonzottE;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public boolean isKolcsonzottE() {
        return kolcsonzottE;
    }

    @Override
    public void hasznal() {
        String s = kolcsonzottE ? "kölcsönözve" : "nincs kölcsönözve";
        System.out.printf("Használva a %s id-u könyv! És %s.\n", super.getId().toString(),s);
    }

    @Override
    public void kolcsonoz() {
        if (kolcsonzottE) {
            this.kolcsonzottE = false;
        }
    }

    @Override
    public String toString() {
        return super.toString()+"\tKonyv{" + "szerzo=" + szerzo + 
                ", kolcsonzottE=" + kolcsonzottE + '}';
    }
    
}
