package xyzhotel.model;

import javax.persistence.*;

@Entity
@Table(name = "usertype")
public class Usertype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userTypeId;
    private String userType;

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
