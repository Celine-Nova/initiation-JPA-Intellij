package fr.m2i.crm.model;

import fr.m2i.crm.state.CustomerState;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11)
    private int id;

    @Column(name= "designation", nullable = false, length = 100)
    private String designation;

    @Column(name = "nd_days", length = 11)
    private int nbDays;

    @Column(name="total_exclude_taxe", scale = 2)
    private Double totalExcludeTaxe;

    @Column(name="total_with_taxe", scale = 2)
    private Double totalWithTaxe;

    @Column(name="type_presta", length = 100)
    private String typePresta;

    @Column(name="unit_price", scale = 2)
    private Double unitPrice;

    @Column(name="state", nullable = false, columnDefinition = "INT(1) DEFAULT '0'") // => Sql type Integer valeur par default 0 == INACTIVE
    // ou @ColumnDefault("0")
    @Enumerated(EnumType.ORDINAL) // => Renvoie Integer
    private CustomerState state;

    
    @JoinColumn(name = "customer_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public Double getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(Double totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Double getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(Double totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public CustomerState getState() {
        return state;
    }

    public void setState(CustomerState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", nbDays=" + nbDays +
                ", totalExcludeTaxe=" + totalExcludeTaxe +
                ", totalWithTaxe=" + totalWithTaxe +
                ", typePresta='" + typePresta + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
