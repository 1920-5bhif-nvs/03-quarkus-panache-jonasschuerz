package at.htl.firedepartment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity
public class WaterTender extends Vehicle {

    public int tank;
    public String portablePump;
    public String type;

    //region Constructors
    public WaterTender(int mileage, LocalDate firstRegistration, String brand, int tank, String portablePump, String type) {
        super(mileage, firstRegistration, brand);
        this.tank = tank;
        this.portablePump = portablePump;
        this.type = type;
    }

    public WaterTender() {
    }
    //endregion


}
