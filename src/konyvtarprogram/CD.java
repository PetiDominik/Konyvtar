package konyvtarprogram;

public class CD extends AbstractTermek{

    private String kiado;

    public CD(String kiado, String cim) {
        super(cim);
        this.kiado = kiado;
    }

    public String getKiado() {
        return kiado;
    }
    
    @Override
    public void hasznal() {
        System.out.printf("Használva a %s id-u CD!\n", super.getId().toString());
    }

    @Override
    public String toString() {
        return super.toString()+"\tCD{" + "kiado=" + kiado + '}';
    }
}
