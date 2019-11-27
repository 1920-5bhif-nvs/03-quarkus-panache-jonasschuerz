package at.htl.firedepartment.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@XmlRootElement
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation extends PanacheEntity {

    public String typeOfMission; //Einsatzart
    public String alarmText;
    public Integer alert; //Alarmstufe
    public String position;
    public LocalDate time;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name="PARTICIPATE_VEHICLE",
            joinColumns = @JoinColumn(name = "OPERATIONID"),
            inverseJoinColumns = @JoinColumn(name = "VEHICLEID")
    )
    public List<Vehicle> vehicles;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name="PARTICIPATE_MEMBER",
            joinColumns = @JoinColumn(name = "OPERATIONID"),
            inverseJoinColumns = @JoinColumn(name = "MEMBERID")
    )
    public List<Member> members;

    public Operation(){
    }

    public Operation(String typeOfMission, String alarmText, Integer alert, String position, LocalDate time) {
        this();
        members = new LinkedList<>();
        vehicles = new LinkedList<>();
        this.typeOfMission = typeOfMission;
        this.alarmText = alarmText;
        this.alert = alert;
        this.position = position;
        this.time = time;
    }

    public void addVehicle(Vehicle vehicle) {
        if(!vehicles.contains(vehicle))
            vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        if(!vehicles.contains(vehicle))
            vehicles.remove(vehicle);
    }

    public void addMember(Member member) {
        if(!members.contains(member))
            members.add(member);
    }

    public void removeMember(Member member){
        if(!members.contains(member))
            members.remove(member);
    }

}
