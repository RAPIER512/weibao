package ccu.model.business;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Courage on 2015/10/14.
 */


/**
 * 工程验收表
 */

@Entity
@Table(name = "ProjectCheck")
public class ProjectCheck implements Serializable {


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
//    @ManyToOne(targetEntity = RepairApp.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "AppId",referencedColumnName = "id")
//    private RepairApp repairApp;//所属维修单
//
//
//    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "CheckUserId",referencedColumnName = "id")
//    private User checkUser;//验收人


    @Column(name = "AppCode")
    private String appCode;//申请单号
    @Column(name = "CheckTime")
    private Date checkTime;//验收时间自动生成
    @Column(name = "CheckResult")
    private String checkResult;//验收结果
    @Column(name = "AssessUserName")
    private String assessUserName;//服务评价人姓名
    @Column(name = "ServiceLevel")
    private String serviceLevel;//服务等级
    @Column(name = "ServiceSuggest")
    private String seviceSuggest;//服务评价
    @Column(name = "AssessTime")
    private Date assessTime;//评价时间


//    public RepairPlan getRepairPlan() {
//        return repairPlan;
//    }
//
//    public void setRepairPlan(RepairPlan repairPlan) {
//        this.repairPlan = repairPlan;
//    }

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
//
//    public User getCheckUser() {
//        return checkUser;
//    }
//
//    public void setCheckUser(User checkUser) {
//        this.checkUser = checkUser;
//    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getAssessUserName() {
        return assessUserName;
    }

    public void setAssessUserName(String assessUserName) {
        this.assessUserName = assessUserName;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public String getSeviceSuggest() {
        return seviceSuggest;
    }

    public void setSeviceSuggest(String seviceSuggest) {
        this.seviceSuggest = seviceSuggest;
    }

    public Date getAssessTime() {
        return assessTime;
    }

    public void setAssessTime(Date assessTime) {
        this.assessTime = assessTime;
    }





}
