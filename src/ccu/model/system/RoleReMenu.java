package ccu.model.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Courage on 2015/10/31.
 */

@Entity
@Table(name = "RoleReMenu")

public class RoleReMenu implements Serializable
{

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private  String id;

    @ManyToOne(targetEntity = SysMenu.class)
    @JoinColumn(name = "MenuId",referencedColumnName = "id")
    private SysMenu sysMenu;

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



    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }


    public SysMenu getSysMenu() {
        return sysMenu;
    }

    public void setSysMenu(SysMenu sysMenu) {
        this.sysMenu = sysMenu;
    }
}
