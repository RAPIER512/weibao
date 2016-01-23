package ccu.model.system;


import ccu.model.basicData.AreaInfo;
import ccu.model.basicData.AreaManageInfo;
import ccu.model.basicData.RepairDepartmentInfo;
import ccu.model.business.*;
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
 * 用户表
 */


/**
 * 对于用户的多向关联我没有设计双向关联，其他所有的我都设计了双向管理
 */

@Entity
@Table(name = "UserInfo")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识


//    @ManyToOne(targetEntity = User.class,fetch =FetchType.EAGER)
//    @JoinColumn(name = "UpdateUserId",referencedColumnName = "id")
//    private User updateUser;//更新用户
    @Column(name = "UpdateUserId")
    private String updateUserId;

//
//    @ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
//    @JoinColumn(name = "CreateUserId",referencedColumnName = "id")
//    private User createUser;//创建用户
    @Column(name = "CreateUserId")
    private String createUserId;

    @Column(name = "Account")
    private String account;//账户
    @Column(name = "Password")
    private String password;//密码
    @Column(name = "UserName")
    private String userName;//用户姓名
    @Column(name = "UserTel")
    private String userTel;//电话
    @Column(name = "UserMail")
    private String userMail;//邮箱
    @Column(name = "CreateTime")
    private Date createTime;//创建时间
    @Column(name = "UpdateTime")
    private Date updateTime;//更新时间
    @Column(name = "IsManager")
    private boolean isManager;//是否管理员
    @Column(name = "ExamLevel")
    private String examLevel;//审核级别


//    @ManyToOne(targetEntity = Role.class,fetch = FetchType.EAGER)
//    @JoinTable(name = "UserReRole",joinColumns = @JoinColumn(name = "UserId",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "RoleId",referencedColumnName = "id")
//    )
//    private Role role;//角色


//
//
//    @ManyToOne(targetEntity = AreaInfo.class,fetch = FetchType.EAGER)
//    @JoinColumn(name = "AreaId",referencedColumnName = "id")
//    private AreaInfo area;//社区

    @Column(name = "AreaId")
    private String areaId;
//
//    @ManyToOne(targetEntity = AreaManageInfo.class,fetch = FetchType.EAGER)
//    @JoinColumn(name = "AreaManageId",referencedColumnName = "id")
//    private AreaManageInfo areaManage;//管理部门
//
    @Column(name = "AreaManageId")
    private  String areaManageId;
//
//    @ManyToOne(targetEntity = RepairDepartmentInfo.class,fetch = FetchType.EAGER)
//    @JoinColumn(name = "RepairDepartmentId",referencedColumnName = "id")
//    private RepairDepartmentInfo repairDepartment;//维保单位

    @Column(name = "RepairDepartmentId")
    private String repairDepartmentId;


//    @OneToMany(targetEntity = AttachmentInfo.class,fetch = FetchType.EAGER)
//    private Set<AttachmentInfo> attachmentInfos = new HashSet<AttachmentInfo>();
//
//    @OneToMany(targetEntity = PlanExam.class,fetch = FetchType.EAGER)
//    private Set<PlanExam> planExams = new HashSet<PlanExam>();
//
//    @OneToMany(targetEntity = PlanSchedule.class,fetch = FetchType.EAGER)
//    private Set<PlanSchedule> planSchedules = new HashSet<PlanSchedule>();
//
//    @OneToMany(targetEntity = ProjectCheck.class,fetch = FetchType.EAGER)
//    private Set<ProjectCheck> projectChecks = new HashSet<ProjectCheck>();
//
//    @OneToMany(targetEntity = Report.class,fetch = FetchType.EAGER)
//    private Set<Report> reports = new HashSet<Report>();
//
//    @OneToMany(targetEntity = LogInfo.class,fetch = FetchType.EAGER)
//    private Set<LogInfo> logInfos = new HashSet<LogInfo>();
//
//    @OneToMany(targetEntity = Role.class,fetch = FetchType.EAGER)
//    private Set<Role> roles = new HashSet<Role>();


    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

//    public User getUpdateUser() {
//        return updateUser;
//    }
//
//    public void setUpdateUser(User updateUser) {
//        this.updateUser = updateUser;
//    }
//
//    public User getCreateUser() {
//        return createUser;
//    }
//
//    public void setCreateUser(User createUser) {
//        this.createUser = createUser;
//    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean isManager) {
        this.isManager = isManager;
    }

    public String getExamLevel() {
        return examLevel;
    }

    public void setExamLevel(String examLevel) {
        this.examLevel = examLevel;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public AreaInfo getArea() {
//        return area;
//    }
//
//    public void setArea(AreaInfo area) {
//        this.area = area;
//    }
//
//    public AreaManageInfo getAreaManage() {
//        return areaManage;
//    }
//
//    public void setAreaManage(AreaManageInfo areaManage) {
//        this.areaManage = areaManage;
//    }
//
//    public RepairDepartmentInfo getRepairDepartment() {
//        return repairDepartment;
//    }
//
//    public void setRepairDepartment(RepairDepartmentInfo repairDepartment) {
//        this.repairDepartment = repairDepartment;
//    }

//    public Set<AttachmentInfo> getAttachmentInfos() {
//        return attachmentInfos;
//    }
//
//    public void setAttachmentInfos(Set<AttachmentInfo> attachmentInfos) {
//        this.attachmentInfos = attachmentInfos;
//    }
//
//    public Set<PlanExam> getPlanExams() {
//        return planExams;
//    }
//
//    public void setPlanExams(Set<PlanExam> planExams) {
//        this.planExams = planExams;
//    }
//
//    public Set<PlanSchedule> getPlanSchedules() {
//        return planSchedules;
//    }
//
//    public void setPlanSchedules(Set<PlanSchedule> planSchedules) {
//        this.planSchedules = planSchedules;
//    }
//
//    public Set<ProjectCheck> getProjectChecks() {
//        return projectChecks;
//    }
//
//    public void setProjectChecks(Set<ProjectCheck> projectChecks) {
//        this.projectChecks = projectChecks;
//    }
//
//    public Set<Report> getReports() {
//        return reports;
//    }
//
//    public void setReports(Set<Report> reports) {
//        this.reports = reports;
//    }
//
//    public Set<LogInfo> getLogInfos() {
//        return logInfos;
//    }
//
//    public void setLogInfos(Set<LogInfo> logInfos) {
//        this.logInfos = logInfos;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }


//    public String getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(String roleId) {
//        this.roleId = roleId;
//    }


    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaManageId() {
        return areaManageId;
    }

    public void setAreaManageId(String areaManageId) {
        this.areaManageId = areaManageId;
    }

    public String getRepairDepartmentId() {
        return repairDepartmentId;
    }

    public void setRepairDepartmentId(String repairDepartmentId) {
        this.repairDepartmentId = repairDepartmentId;
    }



}
