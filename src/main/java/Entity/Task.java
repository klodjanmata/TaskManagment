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
    @JoinColumn(name = "assigned_to")
    private Employees assignedTo; // Changed from String to Employees

    @Column(name = "priority")
    private String priority;

    @Column(name = "status")
    private String status;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "depends_on_task_id")
    private Task dependsOnTask;

    @Override
    public String toString() {
        return "Task: " +
                "ID: " + id +
                "Task title: " + title +
                "Description: " + description +
                "Project ID: " + (project != null ? project.getId() : null) +
                "Assigned to: " + (assignedTo != null ? assignedTo.getName() : "none") +
                "Priority: " + priority +
                "Status: " + status +
                "Created at: " + createdAt +
                "Deadline" + deadline +
                "Depends On Task With ID: " + (dependsOnTask != null ? dependsOnTask.getId() : null);
    }
}


