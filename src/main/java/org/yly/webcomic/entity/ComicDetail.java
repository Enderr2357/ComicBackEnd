package org.yly.webcomic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComicDetail {
    private Long cId;
    private Integer maxPage;
    private Integer currentNo;
    private Integer bId;

    private String currentNoName;

}
