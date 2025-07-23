package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "icms")
public class Icms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String aliquota;
    private String reducao;
    private String baseLegal;

    public Icms() {
    }

    public Icms(int id, String aliquota, String reducao, String baseLegal) {
        this.id = id;
        this.aliquota = aliquota;
        this.reducao = reducao;
        this.baseLegal = baseLegal;
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

    public String getReducao() {
        return reducao;
    }

    public void setReducao(String reducao) {
        this.reducao = reducao;
    }

    public String getBaseLegal() {
        return baseLegal;
    }

    public void setBaseLegal(String baseLegal) {
        this.baseLegal = baseLegal;
    }

}
