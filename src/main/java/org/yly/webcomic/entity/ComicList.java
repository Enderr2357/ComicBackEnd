package org.yly.webcomic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComicList {
    private Long bId;
    private String bName;
    private Long bMaxno;
    private String bCategory;
    private String bAuthor;
    private String bInfo;
    private String bSrcname;
    public void setbName(String bName) {
        this.bName = bName;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public void setbInfo(String bInfo) {
        this.bInfo = bInfo;
    }

    public void setbSrcname(String bSrcname) {
        this.bSrcname = bSrcname;
    }

    public void setbMaxno(Long bMaxno) {
        this.bMaxno = bMaxno;
    }

    public void setbCategory(String bCategory) {
        this.bCategory = bCategory;
    }
}
