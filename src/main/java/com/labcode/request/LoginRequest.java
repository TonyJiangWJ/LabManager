package com.labcode.request;

/**
 * Author by TonyJiang on 2017/6/7.
 */
public class LoginRequest extends BaseRequest{
    private String userName;
    private String password;
    private String loginType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
