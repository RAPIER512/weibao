package ccu.model.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Courage on 2015/10/14.
 */


/**
 * 菜单表
 */
@Entity
@Table(name = "SysMenu")
public class SysMenu implements Serializable {


    private static final long serialVersionUID = 1L;//
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识
    @Column(name = "MenuName")
    private String menuName;//菜单名
    @Column(name = "MenuPath")
    private String menuPath;//路径
    @Column(name = "Icon")
    private String icon;//图标
    //private String menuLevel;//菜单级别
    @Column(name = "MenuPid")
    private Integer menuPid;//父节点id
    @Column(name = "MenuMid")
    private Integer menuMid;//节点id
    @Column(name = "MenuIndex")
    private Integer menuIndex;//序号
    //private String menuTarget;//目标，超链接 target 属性
    @Column(name = "isParent")
    private Boolean isParent;//是否为父节点


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(Integer menuPid) {
        this.menuPid = menuPid;
    }

    public Integer getMenuMid() {
        return menuMid;
    }

    public void setMenuMid(Integer menuMid) {
        this.menuMid = menuMid;
    }

    public Integer getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(Integer menuIndex) {
        this.menuIndex = menuIndex;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }




}
