package Rajas.in.Frontend.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
// This is to create a database table automatically in your local database.
@Getter // Just adding lombok dependency you can avoid the boilerplate codes for ex. getters and setters.
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users")//Specify the name your want for the table.
public class user {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
   @Column(name = "userid",nullable = false,unique = true)
    private Long user_id;


    @Column(name = "Email",nullable = false)//specify column name and null or no.
    private String email;

    @Column(name = "FirstName",nullable = false)
    private String fName;

    @Column(name = "LastName",nullable = false)
    private String lName;

    @Column(name = "Active",nullable = false)
    private boolean status ;

    @Override
    public String toString() {
        return "user{" +
                "user_id=" + user_id +
                ", email='" + email + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", status=" + status +
                '}';
    }
}


