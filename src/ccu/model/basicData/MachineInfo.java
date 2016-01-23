package ccu.model.basicData;

import ccu.model.business.RepairApp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Courage on 2015/10/14.
 */


/**
 * 设备表
 */
@Entity
@Table(name = "MachineInfo")
public class MachineInfo implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识
//    @Column(name = "AreaInfo")
//    private AreaInfo areaInfo;//所属社区
    @Column(name = "AreaId")
    private String areaId;


    @Column(name = "MachineCode")
    private String machineCode;//设备编码
    @Column(name = "MachineName")
    private String machineName;//设备名称
    @Column(name = "TestCircle")
    private String testCircle;//巡检周期
    @Column(name = "CircleUnit")
    private String circleUnit;//单位
    @Column(name = "TestDescription")
    private String testDescription;//描述


//    @OneToMany(targetEntity = RepairApp.class,fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "MachineId",referencedColumnName = "id")
//    private Set<RepairApp> repairApps = new HashSet<RepairApp>();//对应的申请单（1对多，1方）


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


    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getTestCircle() {
        return testCircle;
    }

    public void setTestCircle(String testCircle) {
        this.testCircle = testCircle;
    }

    public String getCircleUnit() {
        return circleUnit;
    }

    public void setCircleUnit(String circleUnit) {
        this.circleUnit = circleUnit;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

//    public Set<RepairApp> getRepairApps() {
//        return repairApps;
//    }
//
//    public void setRepairApps(Set<RepairApp> repairApps) {
//        this.repairApps = repairApps;
//    }




}
