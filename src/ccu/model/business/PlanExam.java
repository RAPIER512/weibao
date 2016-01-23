package ccu.model.business;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Courage on 2015/10/14.
 */

/**
 * 方案审核表
 */
@Entity
@Table(name = "PlanExam")
public class PlanExam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识


//    @ManyToOne(targetEntity = RepairPlan.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "PlanId",referencedColumnName = "id")
//    private RepairPlan repairPlan;//所属方案
    @Column(name = "PlanId")
    private String planId;
//
//
//    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)           //?????????????????????????????????????
//    @JoinColumn(name = "ExamUserID",referencedColumnName = "id")
//    private User examUser;//审核人
//
    @Column(name = "ExamUserID")
    private String examUserID;
//
//    @ManyToOne(targetEntity = RepairApp.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "AppId",referencedColumnName = "id")
//    private RepairApp repairApp;//所属申请单
    @Column(name = "AppId")
    private String appId;


    @Column(name = "AppCode")
    private String appCode;//申请单号
    @Column(name = "ExamStatus")
    private String examStatus;//审核状态（通过/未通过）
    @Column(name = "ExamLevel")
    private int examLevel;//审核级别（1，2，3）
    @Column(name = "ExamTime")
    private Date examTime;//产生日期
    @Column(name = "ExamDescription")
    private String examDescription;//描述

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
//    public User getExamUser() {
//        return examUser;
//    }
//
//    public void setExamUser(User examUser) {
//        this.examUser = examUser;
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

    public String getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }

    public int getExamLevel() {
        return examLevel;
    }

    public void setExamLevel(int examLevel) {
        this.examLevel = examLevel;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public String getExamDescription() {
        return examDescription;
    }

    public void setExamDescription(String examDescription) {
        this.examDescription = examDescription;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getExamUserID() {
        return examUserID;
    }

    public void setExamUserID(String examUserID) {
        this.examUserID = examUserID;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
