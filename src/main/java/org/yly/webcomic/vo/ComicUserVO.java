package org.yly.webcomic.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComicUserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    private String account;
}
