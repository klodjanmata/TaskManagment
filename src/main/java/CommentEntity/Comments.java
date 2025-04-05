package CommentEntity;

import EmployeesEntity.Employees;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Comments {
    @Entity
    @Table(name = "comments")
    public class Comment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "task_id", nullable = false)
        private Task task;

        @ManyToOne
        @JoinColumn(name = "author_id", nullable = false)
        private Employees employees;

        @Column(name = "content")
        private String content;

        @Column(name = "created_at")
        private LocalDateTime createdAt;
    }
}
