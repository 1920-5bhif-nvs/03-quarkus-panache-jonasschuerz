package at.htl.firedepartment.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity
@XmlRootElement
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle extends PanacheEntity {

    public int mileage; //Kilometerstand
    public LocalDate firstRegistration; //Erstzulassung
    public String brand;


    //region Constructors
    public Vehicle(int mileage, LocalDate firstRegistration, String brand) {
        this();
        this.mileage = mileage;
        this.firstRegistration = firstRegistration;
        this.brand = brand;
    }

    public Vehicle(){

    }
    //endregion





}
