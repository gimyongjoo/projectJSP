package memberController.dto;

import java.util.Date;

public class Member {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private Date regDate;

    public Member(String email, String name, String pwd, String id) {
        this.email = email;
        this.name = name;
        this.pwd = pwd;
        this.id = id;
    }

    public Member() {
    }

    @Override
    public String toString() {
//        return "아이디 : " + id + ", 비밀번호 : " + pwd + ", 이름 : " + name
//                + ", 이메일 : " + email + ", 가입날짜 : " + regDate;
        return String.format("%s\t%s\t%s\t%s\t%s",
                id, pwd, name, email, regDate.toString());
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
