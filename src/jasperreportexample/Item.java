/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jasperreportexample;

/**
 *
 * @author USUARIO
 */
public class Item {
    
    private String name;
    private Double price;
    // New fields
    private String codigo;
    private Integer cant;
    private String unid;
    private String descProducto;
    private Double valUnit;
    private Double dscto;
    private Double valVenta;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getDescProducto() {
        return descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public Double getValUnit() {
        return valUnit;
    }

    public void setValUnit(Double valUnit) {
        this.valUnit = valUnit;
    }

    public Double getDscto() {
        return dscto;
    }

    public void setDscto(Double dscto) {
        this.dscto = dscto;
    }

    public Double getValVenta() {
        return valVenta;
    }

    public void setValVenta(Double valVenta) {
        this.valVenta = valVenta;
    }

}
