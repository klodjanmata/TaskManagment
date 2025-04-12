package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "discription")
    private String discription;

    @Column(name = "dateOfStart")
    private Date dateOfStart;

    @Column(name = "dateOfEnd")
    private Date dateOfEnd;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_employee",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employees> employees;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<Task> tasks;

    @Override
    public String toString() {
        return "Project: " +
                "ID: " + id +
                "Name of the project: " + name +
                "Description: " + discription +
                "Date of start: " + dateOfStart +
                "Date of end: " + dateOfEnd;
    }
}