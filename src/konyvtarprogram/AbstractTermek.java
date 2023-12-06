package konyvtarprogram;

import java.util.Objects;
import java.util.UUID;

public abstract class AbstractTermek {
   private UUID id;
   private String cim;
   
    public AbstractTermek(String cim) {
        this.cim = cim;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getCim() {
        return cim;
    }
   
    public abstract void hasznal();

    @Override
    public String toString() {
        return "AbstractTermek{" + "id=" + id + ", cim=" + cim + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.cim);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractTermek other = (AbstractTermek) obj;
        if (!Objects.equals(this.cim, other.cim)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    
}
