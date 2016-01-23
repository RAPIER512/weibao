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
 * 社区管理单位表
 */

@Entity
@Table(name = "AreaManageInfo")
public class AreaManageInfo implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识
    @Column(name = "AreaManageName")
    private String areaManageName;//部门名称
    @Column(name = "ManagerContectsName")
    private String managerContectsName;//联系人姓名
    @Column(name = "ManagerContectsTel")
    private String managerContectsTel;//联系人地址
    @Column(name = "ManagerContectsAddress")
    private String managerContectsAddress;//联系人地址
    @Column(name = "ManagerContectsMail")
    private String managerContectsMail;//联系人邮箱
    @Column(name = "ExamLevels")
    private String examLevels;//审核级别

//    @OneToMany(targetEntity = AreaInfo.class,fetch = FetchType.LAZY)
//    private Set<AreaInfo> areaInfos = new HashSet<AreaInfo>();


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaManageName() {
        return areaManageName;
    }

    public void setAreaManageName(String areaManageName) {
        this.areaManageName = areaManageName;
    }

    public String getManagerContectsName() {
        return managerContectsName;
    }

    public void setManagerContectsName(String managerContectsName) {
        this.managerContectsName = managerContectsName;
    }

    public String getManagerContectsTel() {
        return managerContectsTel;
    }

    public void setManagerContectsTel(String managerContectsTel) {
        this.managerContectsTel = managerContectsTel;
    }

    public String getManagerContectsAddress() {
        return managerContectsAddress;
    }

    public void setManagerContectsAddress(String managerContectsAddress) {
        this.managerContectsAddress = managerContectsAddress;
    }

    public String getManagerContectsMail() {
        return managerContectsMail;
    }

    public void setManagerContectsMail(String managerContectsMail) {
        this.managerContectsMail = managerContectsMail;
    }

    public String getExamLevels() {
        return examLevels;
    }

    public void setExamLevels(String examLevels) {
        this.examLevels = examLevels;
    }

//    public Set<AreaInfo> getAreaInfos() {
//        return areaInfos;
//    }
//
//    public void setAreaInfos(Set<AreaInfo> areaInfos) {
//        this.areaInfos = areaInfos;
//    }






}
