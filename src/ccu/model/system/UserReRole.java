package ccu.model.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Courage on 2015/10/31.
 */
@Entity
@Table(name = "UserReRole")

public class UserReRole implements Serializable {

    public  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;

    @Column(name = "UserId")
    private String userId;

    @Column(name = "RoleId")
    private String roleId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        roleId = roleId;
    }
}
