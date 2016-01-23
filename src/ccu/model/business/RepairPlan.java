package ccu.model.business;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.GUIDGenerator;

import javax.naming.Name;
import javax.persistence.*;
import javax.persistence.metamodel.Type;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Courage on 2015/10/14.
 */


/**
 * 维保方案表
 */

@Entity
@Table(name = "RepairPlan")
public class RepairPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识


//    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "PlanUserId",referencedColumnName = "id")
//    private User user;//用户
    @Column(name = "PlanUserId")
    private  String planUserId;


//    @ManyToOne(targetEntity = RepairApp.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "AppId",referencedColumnName = "id")
//    private RepairApp repairApp;//属于哪个申请单

    @Column(name = "AppId")
    private String  appId;

    @Column(name = "AppCode")
    private String appCode;//申请单号
    @Column(name = "PlanDescription")
    private String planDescription;//描述
    @Column(name = "PlanMoney")
    private long planMoney;//预算
    @Column(name = "PlanTime")
    private Date planTime;//预计完成时间
    @Column(name = "SubmitTime")
    private Date submitTime;//提交时间
    @Column(name = "PlanType")
    private String planType;//方案类型
    @Column(name = "ExceptionMess")
    private String exceptionMess;//异常


//    @OneToOne(targetEntity = PlanExam.class,fetch = FetchType.LAZY)
//    private PlanExam planExam;//审核
//
//
//    @OneToMany(targetEntity = AttachmentInfo.class,fetch = FetchType.LAZY)
//    private Set<AttachmentInfo> attachmentInfos = new HashSet<AttachmentInfo>();//附件
//
//    @OneToMany(targetEntity = PlanExam.class,fetch = FetchType.LAZY)
//    private Set<PlanExam> planExams = new HashSet<PlanExam>();
//
//    @OneToMany(targetEntity = PlanSchedule.class,fetch = FetchType.LAZY)
//    private Set<PlanSchedule> planSchedules = new HashSet<PlanSchedule>();
//
//    @OneToMany(targetEntity = ProjectCheck.class,fetch = FetchType.LAZY)
//    private Set<ProjectCheck> projectChecks = new HashSet<ProjectCheck>();
//
//    @OneToMany(targetEntity = RepairApp.class,fetch = FetchType.LAZY)
//    private Set<RepairApp> repairApps = new HashSet<RepairApp>();


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public RepairApp getRepairApp() {
//        return repairApp;
//    }
//
//    public void setRepairApp(RepairApp repairApp) {
//        this.repairApp = repairApp;
//    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public long getPlanMoney() {
        return planMoney;
    }

    public void setPlanMoney(long planMoney) {
        this.planMoney = planMoney;
    }

    public Date getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getExceptionMess() {
        return exceptionMess;
    }

    public void setExceptionMess(String exceptionMess) {
        this.exceptionMess = exceptionMess;
    }

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
//    public Set<RepairApp> getRepairApps() {
//        return repairApps;
//    }
//
//    public void setRepairApps(Set<RepairApp> repairApps) {
//        this.repairApps = repairApps;
//    }


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPlanUserId() {
        return planUserId;
    }

    public void setPlanUserId(String planUserId) {
        this.planUserId = planUserId;
    }
}
