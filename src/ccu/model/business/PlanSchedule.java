package ccu.model.business;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Courage on 2015/10/14.
 */


/**
 * 进度管理表
 */
@Entity
@Table(name = "PlanSchedule")
public class PlanSchedule implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识


//    @ManyToOne(targetEntity = RepairPlan.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "PlanId",referencedColumnName = "id")
//    private RepairPlan repairPlan;//所属方案
//
//
//    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "RecordUserId",referencedColumnName = "id")
//    private User user;//录入人
//
//
//    @ManyToOne(targetEntity = RepairApp.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "AppId",referencedColumnName = "id")
//    private RepairApp repairApp;//所属维修单


    @Column(name = "AppCode")
    private String appCode;//维修单号
    @Column(name = "ScheduleDescription")
    private String scheduleDescription;//描述
    @Column(name = "RecordTime")
    private Date recordTime;//记录时间


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public RepairPlan getRepairPlan() {
//        return repairPlan;
//    }
//
//    public void setRepairPlan(RepairPlan repairPlan) {
//        this.repairPlan = repairPlan;
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

    public String getScheduleDescription() {
        return scheduleDescription;
    }

    public void setScheduleDescription(String scheduleDescription) {
        this.scheduleDescription = scheduleDescription;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }





}
