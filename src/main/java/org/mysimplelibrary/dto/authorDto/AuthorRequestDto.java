package org.mysimplelibrary.dto.authorDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {
    private String authorName;
    private String authorBook;
}
