package ccu.model.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Courage on 2015/10/14.
 */


/**
 * 角色表
 */
@Entity
@Table(name = "Role")
public class Role implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识


//    @ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
//    @JoinColumn(name = "CreateUserId",referencedColumnName = "id")
//    private User createUser;//创建的用户


    @Column(name = "RoleName")
    private String roleName;//角色名
    @Column(name = "RoleDescription")
    private String roleDescription;//描述
    @Column(name = "RoleCreateTime")
    private Date roleCreateTime;//创建时间

//    @ManyToMany(targetEntity = SysMenu.class,fetch = FetchType.EAGER)
//    @JoinTable(name = "RoleReMenu",joinColumns = @JoinColumn(name = "RoleId",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "MenuId",referencedColumnName = "id")
//    )
//    private Set<SysMenu> sysMenus = new HashSet<SysMenu>();//菜单


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public User getCreateUser() {
//        return createUser;
//    }
//
//    public void setCreateUser(User createUser) {
//        this.createUser = createUser;
//    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Date getRoleCreateTime() {
        return roleCreateTime;
    }

    public void setRoleCreateTime(Date roleCreateTime) {
        this.roleCreateTime = roleCreateTime;
    }

//    public Set<SysMenu> getSysMenus() {
//        return sysMenus;
//    }
//
//    public void setSysMenus(Set<SysMenu> sysMenus) {
//        this.sysMenus = sysMenus;
//    }




}
