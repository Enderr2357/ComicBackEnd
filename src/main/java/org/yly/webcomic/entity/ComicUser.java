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
    public void setuId(Long uId) {
        this.uId = uId;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
}
