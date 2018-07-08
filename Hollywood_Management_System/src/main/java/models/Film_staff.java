package models;

import javax.persistence.*;

@Entity
@Table(name = "filmStaff")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Film_staff {

    private int id;
    private String name;
    private int feeInMillions;

    public Film_staff(){}

    public Film_staff(String name, int fee) {
        this.name = name;
        this.feeInMillions = fee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "fee_in_Millions")
    public int getFeeInMillions() {
        return feeInMillions;
    }
    public void setFeeInMillions(int feeInMillions) {
        this.feeInMillions = feeInMillions;
    }

}
