package org.yly.webcomic.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComicListVO {
    @java.io.Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String author;
    private String category;
}
