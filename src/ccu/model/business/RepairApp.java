package ccu.model.business;



import org.hibernate.annotations.GenericGenerator;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Courage on 2015/10/14.
 */

/**
 * 维修申请单
 */
@Entity
@Table(name = "RepairApp")
public class RepairApp implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy =GenerationType.AUTO)
    //@GenericGenerator(name = "GUID", strategy = "guid")
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    //@GenericGenerator(name="paymentableGenerator",strategy = "GUIDGeneratot")
    private String id;//标识

//    @ManyToOne(targetEntity = AreaInfo.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "AreaId",referencedColumnName = "id")
//    private AreaInfo areaInfo;//社区

    @Column(name = "AreaId")
    private String areaId;
    //
//
//    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "AppUserId",referencedColumnName = "id")
//    private User user;//用户
    @Column(name = "AppUserId")
    private String appUserId;


    //
//
//    @ManyToOne(targetEntity = RepairDepartmentInfo.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "RepairDepartmentId",referencedColumnName = "id")
//    private RepairDepartmentInfo repairDepartmentInfo;//维保单位
    @Column(name = "RepairDepartmentId")
    private String repairDepartmentId;
    //
//
//    @ManyToOne(targetEntity = MachineInfo.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "MachineId",referencedColumnName = "id")
//    private MachineInfo machineInfo;//设备
    @Column(name = "MachineId")
    private String machineId;//机器型号ID


    @Column(name = "AppCode")
    private String appCode;//维修单号
    @Column(name = "AppType")
    private String appType;//申请单类型
    @Column(name = "MachineName")
    private String machineName;//设备名称
    @Column(name = "MachineType")
    private String machineType;//设备类型
    @Column(name = "ErrorType")
    private String errorType;//错误类型
    @Column(name = "InfoSource")
    private String infoSource;//信息源
    @Column(name = "Department")
    private String department;//部门
    @Column(name = "AppDescription")
    private String appDescription;//描述
    @Column(name = "IsRapadRepair")
    private Boolean isRapadRepair;//快速维保
    @Column(name = "ReceiveTime")
    private Date receiveTime;//接报时间
    @Column(name = "ArriveTime")
    private Date arriveTime;//到达时间
    @Column(name = "AppTime")
    private Date appTime;//申请时间
    @Column(name = "AppStatus")
    private String appStatus;//申请状态
    @Column(name = "Step")
    private int step;//流转步骤


//    @ManyToOne(targetEntity = RepairPlan.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "PlanId",referencedColumnName = "id")
//    private RepairPlan repairPlan;//最新版方案

    @Column(name = "PlanId")
    private String planId;
//
//
//    @OneToMany(targetEntity = AttachmentInfo.class,fetch = FetchType.LAZY)
//    private Set<AttachmentInfo> attachments = new HashSet<AttachmentInfo>();//附件
//
//    @OneToMany(targetEntity = ProjectCheck.class,fetch = FetchType.LAZY)
//    private Set<ProjectCheck> projectChecks = new HashSet<ProjectCheck>();//验收
//
//
//    @OneToMany(targetEntity = PlanExam.class,fetch = FetchType.LAZY)
//    private Set<PlanExam> planExams = new HashSet<PlanExam>();//审核
//
//
//    @OneToMany(targetEntity = PlanSchedule.class,fetch = FetchType.LAZY)
//    private Set<PlanSchedule> planSchedules = new HashSet<PlanSchedule>();//进度
//
//    @OneToMany(targetEntity = RepairPlan.class,fetch = FetchType.LAZY)
//    private Set<RepairPlan> repairPlans = new HashSet<RepairPlan>();//所有方案


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public AreaInfo getAreaInfo() {
//        return areaInfo;
//    }
//
//    public void setAreaInfo(AreaInfo areaInfo) {
//        this.areaInfo = areaInfo;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public RepairDepartmentInfo getRepairDepartmentInfo() {
//        return repairDepartmentInfo;
//    }
//
//    public void setRepairDepartmentInfo(RepairDepartmentInfo repairDepartmentInfo) {
//        this.repairDepartmentInfo = repairDepartmentInfo;
//    }
//
//    public MachineInfo getMachineInfo() {
//        return machineInfo;
//    }
//
//    public void setMachineInfo(MachineInfo machineInfo) {
//        this.machineInfo = machineInfo;
//    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getInfoSource() {
        return infoSource;
    }

    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    public Boolean getIsRapadRepair() {
        return isRapadRepair;
    }

    public void setIsRapadRepair(Boolean isRapadRepair) {
        this.isRapadRepair = isRapadRepair;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getAppTime() {
        return appTime;
    }

    public void setAppTime(Date appTime) {
        this.appTime = appTime;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

//    public RepairPlan getRepairPlan() {
//        return repairPlan;
//    }
//
//    public void setRepairPlan(RepairPlan repairPlan) {
//        this.repairPlan = repairPlan;
//    }
//
//    public Set<AttachmentInfo> getAttachments() {
//        return attachments;
//    }
//
//    public void setAttachments(Set<AttachmentInfo> attachments) {
//        this.attachments = attachments;
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
//    public Set<RepairPlan> getRepairPlans() {
//        return repairPlans;
//    }
//
//    public void setRepairPlans(Set<RepairPlan> repairPlans) {
//        this.repairPlans = repairPlans;
//    }


    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }


    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }

    public String getRepairDepartmentId() {
        return repairDepartmentId;
    }

    public void setRepairDepartmentId(String repairDepartmentId) {
        this.repairDepartmentId = repairDepartmentId;
    }


    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }
    
}
