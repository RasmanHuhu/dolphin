import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
public class PersonDetail {
    @Id
    private Integer id;
    private String Address;
    private int zip;
    private String City;
    private int age;

    //Relationer 1:1

    @OneToOne
    @MapsId
    private Person person;


    public PersonDetail(String address, int zip, String city, int age) {
        Address = address;
        this.zip = zip;
        City = city;
        this.age = age;
    }
}
