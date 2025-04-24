package org.mysimplelibrary.dto.bookDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String title;
    private Long id;
    private String description;
    private String authorEmail;
}
