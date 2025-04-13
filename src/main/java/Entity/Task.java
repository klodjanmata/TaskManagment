package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name="assigned_to")
    private Employees assignedTo;

    @Column(name = "priority")
    private String priority;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "deadline")
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "depends_on_task_id")
    private Task dependsOnTask;

    @Override
    public String toString() {
        return "Task: " +
                "ID: " + id +
                ", Title: '" + title + '\'' +
                ", Description: '" + description + '\'' +
                ", Project ID: " + (project != null ? project.getId() : null) +
                ", Assigned To Employee: '" + assignedTo + '\'' +
                ", Priority='" + priority + '\'' +
                ", Status='" + status + '\'' +
                ", Created At=" + createdAt +
                ", Dead Line=" + deadline +
                ", Depends On Task With ID=" + (dependsOnTask != null ? dependsOnTask.getId() : null);
    }
}

