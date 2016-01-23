package ccu.model.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Courage on 2015/10/14.
 */

/**
 *日志表
 */
@Entity
@Table(name = "LogInfo")
public class LogInfo implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识


//    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "UserId",referencedColumnName = "id")
//    private User user;//登录用户


    @Column(name = "LoginTime")
    private Date loginTime;//登陆时间
    @Column(name = "MenuName")
    private String menuName;//菜单名
    @Column(name = "OperateTime")
    private Date operateTime;//操作时间
    @Column(name = "ExceptionMess")
    private String exceptionMess;//异常信息
    @Column(name = "UserIp")
    private String userIp;//用户Ip


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getExceptionMess() {
        return exceptionMess;
    }

    public void setExceptionMess(String exceptionMess) {
        this.exceptionMess = exceptionMess;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }




}
