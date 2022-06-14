package fr.m2i.crm.model;

import fr.m2i.crm.state.CustomerState;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "company_name", length = 100)
    private String companyName;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "email",  length = 100)
    private String email;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "zip_code", length = 12)
    private String zipCode;

    // attribut state de l'enum CustomerState
    @Column(name="state", nullable = false, columnDefinition = "INT(1) DEFAULT '0'") // => Sql type Integer valeur par default 0 == INACTIVE
    // ou @ColumnDefault("0")
    @Enumerated(EnumType.ORDINAL) // => Renvoie Integer
    private CustomerState state;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public CustomerState getState() {
        return state;
    }

    public void setState(CustomerState state) {
        this.state = state;
    }
    public void setCustomerState(CustomerState state) {
        this.state = state;
    }

    public void setNotNullData(Customer newCustomer) {
        if (newCustomer.getAddress() != null) {
            this.setAddress(newCustomer.getAddress());
        }

        if (newCustomer.getCompanyName() != null) {
            this.setCompanyName(newCustomer.getCompanyName());
        }

        if (newCustomer.getCity() != null) {
            this.setCity(newCustomer.getCity());
        }

        if (newCustomer.getZipCode() != null) {
            this.setZipCode(newCustomer.getZipCode());
        }

        // l'avoir pour tous les champs qu'on veut modifier

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", state=" + state +
                '}';
    }
}
