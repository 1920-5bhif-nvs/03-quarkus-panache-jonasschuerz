package at.htl.firedepartment.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity
@XmlRootElement
@Inheritance(strategy = InheritanceType.JOINED)
public class Member extends PanacheEntity {

    public String name; //Vor- und Zuname
    public String rank;
    public String mail;
    public LocalDate involvedSince;

    public Member(String name, String rank, String mail, LocalDate involvedSince) {
        this();
        this.name = name;
        this.rank = rank;
        this.mail = mail;
        this.involvedSince = involvedSince;
    }

    public Member(){

    }
}
