package Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employees {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "first_name")
    private String name;
    @Column (name = "last_name")
    private String surname;
    @Column (name = "position")
    private String position;
    @Column (name = "email")
    private String email;

    @Override
    public String toString() {
        return "Employee: " +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", surname: '" + surname + '\'' +
                ", position: '" + position + '\'' +
                ", email:'" + email + '\'';
    }
}
