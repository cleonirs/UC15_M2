package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigo;
    private String descricao;
    private String codigoBarras;
    private int categoriaId;
    private int origemId;
    private int ncmId;
    private int cestId;
    private int cstEntradaId;
    private int cstSaidaId;
    private int aliquotaIcmsEntradaId;
    private int aliquotaIcmsSaidaId;
    private int aliquotaPisId;
    private int aliquotaFCPId;

    public Produto() {
    }

    public Produto(int id, String codigo, String descricao, String codigoBarras, int categoriaId, int origemId, int ncmId, int cestId, int cstEntradaId, int cstSaidaId, int aliquotaIcmsEntradaId, int aliquotaIcmsSaidaId, int aliquotaPisId, int aliquotaFCPId) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.codigoBarras = codigoBarras;
        this.categoriaId = categoriaId;
        this.origemId = origemId;
        this.ncmId = ncmId;
        this.cestId = cestId;
        this.cstEntradaId = cstEntradaId;
        this.cstSaidaId = cstSaidaId;
        this.aliquotaIcmsEntradaId = aliquotaIcmsEntradaId;
        this.aliquotaIcmsSaidaId = aliquotaIcmsSaidaId;
        this.aliquotaPisId = aliquotaPisId;
        this.aliquotaFCPId = aliquotaFCPId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getOrigemId() {
        return origemId;
    }

    public void setOrigemId(int origemId) {
        this.origemId = origemId;
    }

    public int getNcmId() {
        return ncmId;
    }

    public void setNcmId(int ncmId) {
        this.ncmId = ncmId;
    }

    public int getCestId() {
        return cestId;
    }

    public void setCestId(int cestId) {
        this.cestId = cestId;
    }

    public int getCstEntradaId() {
        return cstEntradaId;
    }

    public void setCstEntradaId(int cstEntradaId) {
        this.cstEntradaId = cstEntradaId;
    }

    public int getCstSaidaId() {
        return cstSaidaId;
    }

    public void setCstSaidaId(int cstSaidaId) {
        this.cstSaidaId = cstSaidaId;
    }

    public int getAliquotaIcmsEntradaId() {
        return aliquotaIcmsEntradaId;
    }

    public void setAliquotaIcmsEntradaId(int aliquotaIcmsEntradaId) {
        this.aliquotaIcmsEntradaId = aliquotaIcmsEntradaId;
    }

    public int getAliquotaIcmsSaidaId() {
        return aliquotaIcmsSaidaId;
    }

    public void setAliquotaIcmsSaidaId(int aliquotaIcmsSaidaId) {
        this.aliquotaIcmsSaidaId = aliquotaIcmsSaidaId;
    }

    public int getAliquotaPisId() {
        return aliquotaPisId;
    }

    public void setAliquotaPisId(int aliquotaPisId) {
        this.aliquotaPisId = aliquotaPisId;
    }

    public int getAliquotaFCPId() {
        return aliquotaFCPId;
    }

    public void setAliquotaFCPId(int aliquotaFCPId) {
        this.aliquotaFCPId = aliquotaFCPId;
    }

}
