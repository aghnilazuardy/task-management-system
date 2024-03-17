package backendtest.taskmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTaskRequest {
    
    @NotBlank
    private String detail;

    private boolean isCompleted;

    @JsonProperty("isCompleted")
    public boolean getIsCompleted() {
        return this.isCompleted;
    }
}
