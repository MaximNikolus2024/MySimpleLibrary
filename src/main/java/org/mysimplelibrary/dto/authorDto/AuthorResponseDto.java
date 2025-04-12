package org.mysimplelibrary.dto.authorDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {
    private String authorName;
    private String authorBook;
    private Integer id;

    public AuthorResponseDto(String name, Long id) {
    }
}
