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
    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getuId() {
        return uId;
    }

    public Long getuRole() {
        return uRole;
    }

    public void setuRole(Long uRole) {

        this.uRole = uRole;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuName() {
        return uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
}
