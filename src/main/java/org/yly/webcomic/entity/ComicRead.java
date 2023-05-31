package org.yly.webcomic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComicRead {
    private Long rId;
    private Long uId;
    private Long bId;
}
