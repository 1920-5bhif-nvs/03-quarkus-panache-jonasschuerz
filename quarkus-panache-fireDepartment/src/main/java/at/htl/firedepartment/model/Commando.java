package at.htl.firedepartment.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Commando extends Member {

    private String functioning;

    public Commando(String name, String rank, String mail, LocalDate involvedSince, String function) {
        super(name, rank, mail, involvedSince);
        this.functioning = function;
    }

    public Commando(){}

    public String getFunctioning() {
        return functioning;
    }

    public void setFunctioning(String function) {
        this.functioning = function;
    }
}
