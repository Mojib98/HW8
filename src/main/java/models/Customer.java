package models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Entity
public class Customer extends User {
    private String address;
    private float budget;

    public Customer(int id, String fullName, String nationalId, int password, String typeUser, String address, float budget) {
        super(id, fullName, nationalId, password, typeUser);
        this.address = address;
        this.budget = budget;
    }




}
