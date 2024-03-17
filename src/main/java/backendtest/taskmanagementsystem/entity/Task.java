package backendtest.taskmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "detail")
    private String detail;

    @Column(name = "is_completed")
    private boolean isCompleted;

    @JsonProperty("isCompleted")
    public boolean getIsCompleted() {
        return this.isCompleted;
    }
}
