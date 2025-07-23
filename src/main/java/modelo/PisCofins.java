package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "pis")
public class PisCofins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pis;
    private String cofins;

    public PisCofins() {
    }

    public PisCofins(int id, String pis, String cofins) {
        this.id = id;
        this.pis = pis;
        this.cofins = cofins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getCofins() {
        return cofins;
    }

    public void setCofins(String cofins) {
        this.cofins = cofins;
    }

}
