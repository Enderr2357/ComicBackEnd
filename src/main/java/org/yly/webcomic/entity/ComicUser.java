package org.yly.webcomic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ComicUser {
    private Long uId;
    private String uName;
    private String uPassword;
    private String uAccount;

    private Long uRole;
}
