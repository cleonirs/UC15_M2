package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "fcp")
public class Fcp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String aliquota;
    private String baseLegal;
    private String validoAte;

    public Fcp() {
    }

    public Fcp(int id, String aliquota, String baseLegal, String validoAte) {
        this.id = id;
        this.aliquota = aliquota;
        this.baseLegal = baseLegal;
        this.validoAte = validoAte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAliquota() {
        return aliquota;
    }

    public void setAliquota(String aliquota) {
        this.aliquota = aliquota;
    }

    public String getBaseLegal() {
        return baseLegal;
    }

    public void setBaseLegal(String baseLegal) {
        this.baseLegal = baseLegal;
    }

    public String getValidoAte() {
        return validoAte;
    }

    public void setValidoAte(String validoAte) {
        this.validoAte = validoAte;
    }

}
