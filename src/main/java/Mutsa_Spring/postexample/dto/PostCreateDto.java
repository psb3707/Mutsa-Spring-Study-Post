package Mutsa_Spring.postexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class PostCreateDto {
    private String title;
    private String content;
}
