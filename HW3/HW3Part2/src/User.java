import java.io.*;
import java.util.ArrayList;

public class User implements Serializable {
    private int credit;
    private String userName;
    private String passaword;
    private static final long serialVersionUID = -1129698854291510207L;
    public User(String userName, String passaword)
    {
        credit = 100;
        this.userName = userName;
        this.passaword = passaword;
    }


    public int getCredit() {
        return credit;
    }

    public boolean decreaseCredit() {
        if(this.credit-20 >= 0)
        {
            this.credit -= 20;
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        return passaword != null ? passaword.equals(user.passaword) : user.passaword == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (passaword != null ? passaword.hashCode() : 0);
        return result;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassaword() {
        return passaword;
    }

    public void setPassaword(String passaword) {
        this.passaword = passaword;
    }

    @Override
    public String toString() {
        return userName + " " + passaword;
    }
}
