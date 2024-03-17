package backendtest.taskmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {
    
    private int id;

    private String detail;

    private boolean isCompleted;
}
