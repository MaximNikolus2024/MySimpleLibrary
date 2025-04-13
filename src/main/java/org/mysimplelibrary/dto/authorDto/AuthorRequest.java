package org.mysimplelibrary.dto.authorDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    private String authorName;
    private Long authorId;
    private String authorEmail;
}
