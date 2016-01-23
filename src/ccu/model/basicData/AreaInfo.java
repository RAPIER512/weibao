package ccu.model.basicData;

/**
 * Created by Courage on 2015/10/14.
 */


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 社区表
 */

@Entity
@Table(name = "AreaInfo")
public class AreaInfo implements Serializable{
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;       //标识
    @Column(name = "AreaCode")
    private String areaCode; //社区编码
    @Column(name = "AreaName")
    private String areaName; //社区名称
    @Column(name = "AreaAddress")
    private String areaAddress;//社区地址
    @Column(name = "AreaType")
    private String areaType;//社区类型
    @Column(name = "AreaContactsName")
    private String areaContactsName;//联系人姓名
    @Column(name = "AreaTel")
    private String areaTel;//联系人电话
    @Column(name = "AreaMail")
    private String areaMail;//联系人邮箱
    @Column(name = "AreaSite")
    private String areaSite;//地理位置
    @Column(name = "UpdateUserId")
    private String updateUserId;//更新人标识
    @Column(name = "UpateTime")
    private Date upateTime;//更新时间

//    @ManyToOne(targetEntity = AreaManageInfo.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
//    @JoinColumn(name = "AreaManageId")
//    private AreaManageInfo areaMangage;//管理单位
    @Column(name = "AreaManageId")
    private String areaManageId;
//
//    @ManyToOne(targetEntity = RepairDepartmentInfo.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name = "RepairDepartmentId")
//    private RepairDepartmentInfo repairDepartment;//维保单位
    @Column(name = "RepairDepartmentId")
    private String repairDepartmentId;


//    @ManyToMany(targetEntity = User.class,fetch = FetchType.LAZY)
//    private Set<User> users = new HashSet<User>();//用户（一对多）
//    @OneToMany(targetEntity = User.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private Set<User> users = new HashSet<User>(); //用户（一对多）
//
//    @OneToMany(targetEntity = MachineInfo.class)
//    private Set<MachineInfo> machineInfos = new HashSet<MachineInfo>();//设备（一对多）
//
//
//    @OneToMany(targetEntity = RepairApp.class,fetch = FetchType.EAGER)
//    private Set<RepairApp> repairApps = new HashSet<RepairApp>();//维修单（1对多）

    public AreaInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getAreaContactsName() {
        return areaContactsName;
    }

    public void setAreaContactsName(String areaContactsName) {
        this.areaContactsName = areaContactsName;
    }

    public String getAreaTel() {
        return areaTel;
    }

    public void setAreaTel(String areaTel) {
        this.areaTel = areaTel;
    }

    public String getAreaMail() {
        return areaMail;
    }

    public void setAreaMail(String areaMail) {
        this.areaMail = areaMail;
    }

    public String getAreaSite() {
        return areaSite;
    }

    public void setAreaSite(String areaSite) {
        this.areaSite = areaSite;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpateTime() {
        return upateTime;
    }

    public void setUpateTime(Date upateTime) {
        this.upateTime = upateTime;
    }

//    public AreaManageInfo getAreaMangage() {
//        return areaMangage;
//    }
//
//    public void setAreaMangage(AreaManageInfo areaMangage) {
//        this.areaMangage = areaMangage;
//    }
//
//    public RepairDepartmentInfo getRepairDepartment() {
//        return repairDepartment;
//    }
//
//    public void setRepairDepartment(RepairDepartmentInfo repairDepartment) {
//        this.repairDepartment = repairDepartment;
//    }
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//    public Set<MachineInfo> getMachineInfos() {
//        return machineInfos;
//    }
//
//    public void setMachineInfos(Set<MachineInfo> machineInfos) {
//        this.machineInfos = machineInfos;
//    }
//
//    public Set<RepairApp> getRepairApps() {
//        return repairApps;
//    }
//
//    public void setRepairApps(Set<RepairApp> repairApps) {
//        this.repairApps = repairApps;
//    }


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
