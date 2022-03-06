package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
@Entity
public class Customer extends User {

    public Customer(int id, String fullName, String nationalId, int password, String typeUser, float budget, String address) {
        super(id, fullName, nationalId, password, typeUser);
        this.budget = budget;
        this.address = address;
    }

    private float budget;
    private String address;


}
