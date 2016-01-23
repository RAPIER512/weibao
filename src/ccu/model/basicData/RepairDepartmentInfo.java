package ccu.model.basicData;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Courage on 2015/10/14.
 */


/**
 * 维保部门表
 */

@Entity
@Table(name = "RepairDepartmentInfo")
public class RepairDepartmentInfo implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;
    @Column(name = "RepairContectsName")
    private String repairContectsName;
    @Column(name = "RepairContectsTel")
    private String repairContectsTel;
    @Column(name = "RepairContextsAddress")
    private String repairContectsAddress;
    @Column(name = "RepairContectsMail")
    private String repairContectsMail;


//    @OneToMany(targetEntity = AreaInfo.class,fetch = FetchType.LAZY)
//    private Set<AreaInfo> areaInfos = new HashSet<AreaInfo>();

//    @OneToMany(targetEntity = RepairApp.class,cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
//    @JoinColumn(name = "RepairDepartmentId")
//    private Set<RepairApp> repairApps = new HashSet<RepairApp>();


//    @ManyToMany(targetEntity = AreaInfo.class,cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
//    @JoinTable(name = "UserReRepairDepartment",joinColumns = @JoinColumn(name = "RepairDepartmentId",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "UserId",referencedColumnName = "id")
//    )
//    private Set<AreaInfo> areas = new HashSet<AreaInfo>();
//
//
//    @ManyToMany(targetEntity = User.class,cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
//    @JoinTable(name = "",joinColumns = @JoinColumn(name = "RepairDepartmentId",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "UserId",referencedColumnName = "id")
//    )
//    private Set<User> users = new HashSet<User>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepairContectsName() {
        return repairContectsName;
    }

    public void setRepairContectsName(String repairContectsName) {
        this.repairContectsName = repairContectsName;
    }

    public String getRepairContectsTel() {
        return repairContectsTel;
    }

    public void setRepairContectsTel(String repairContectsTel) {
        this.repairContectsTel = repairContectsTel;
    }

    public String getRepairContectsAddress() {
        return repairContectsAddress;
    }

    public void setRepairContectsAddress(String repairContectsAddress) {
        this.repairContectsAddress = repairContectsAddress;
    }

    public String getRepairContectsMail() {
        return repairContectsMail;
    }

    public void setRepairContectsMail(String repairContectsMail) {
        this.repairContectsMail = repairContectsMail;
    }

//    public Set<AreaInfo> getAreaInfos() {
//        return areaInfos;
//    }
//
//    public void setAreaInfos(Set<AreaInfo> areaInfos) {
//        this.areaInfos = areaInfos;
//    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }




}
