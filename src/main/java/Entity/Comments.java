package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comments {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "task_id")
        private Task task_id;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "employee_id", nullable = false)
        private Employees employee_id;

        @Column(name = "content")
        private String content;

        @Column(name = "created_at")
        private LocalDate created_at;

        @Override
        public String toString() {
                return "Comment:\n" +
                        "ID: " + id + "\n" +
                        "Task ID: " + (task_id != null ? task_id.getId() : "null") + "\n" +
                        "Employee ID: " + (employee_id != null ? employee_id.getId() : "null") + "\n" +
                        "Content: \"" + content + "\"\n" +
                        "Created At: " + created_at + "\n";
        }
}



