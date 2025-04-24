package org.mysimplelibrary.dto.bookDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mysimplelibrary.dto.authorDto.AuthorResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private String title;
    private String bookDescription;
    private Long id;
    AuthorResponse authorResponse;
}
