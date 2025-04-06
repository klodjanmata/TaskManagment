package Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comments {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "task_id")
        private Task task_id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "employee_id", nullable = false)
        private Employees employee_id;

        @Column(name = "content")
        private String content;

        @Column(name = "created_at")
        private LocalDate created_at;
    }

