import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    //Relationer 1:1

    //(mappedBy = "person") peger på person-variablen i personDetail
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PersonDetail persondetail;

    public Person(String name) {
        this.name = name;
    }

    //Relationer 1:m - mange fees der skal kobles op på én person

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Fee> fees = new HashSet<>();

    //Bi-directional update

    //Hvad gør denne egentlig?
    public void addPersonDetail(PersonDetail personDetail) {

        this.persondetail = personDetail;
        if (personDetail != null) {
            personDetail.setPerson(this);
        }
    }

    //De her peger den modsatte vej - tilføjer en fee til personen
    public void addFee(Fee fee) {
        this.fees.add(fee);
        if (fee != null) {
            fee.setPerson(this);
        }

    }
}
