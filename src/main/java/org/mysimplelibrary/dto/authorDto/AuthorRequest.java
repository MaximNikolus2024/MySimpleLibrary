package org.mysimplelibrary.dto.authorDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    @NotBlank(message = "Author name must be not blank")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Author name can contain latin characters or digital only")
    private String authorName;
    private Long authorId;
    @NotBlank(message = "Email must be not blank")
    @Email(message = "Incorrect email format")
    private String authorEmail;
}
