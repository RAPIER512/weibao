package ccu.model.business;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Courage on 2015/10/14.
 */


/**
 * 附件表
 */

@Entity
@Table(name = "")
public class AttachmentInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识


//    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "UploadUserId",referencedColumnName = "id")
//    private User user;//上传的用户


    @Column(name = "AttachmentPath")
    private String attachmentPath;//附件路径
    @Column(name = "AttachmentDescription")
    private String attchmentDescription;//备注
    @Column(name = "FileType")
    private String fileType;//文件类型
    @Column(name = "FileName")
    private String fileName;//文件名
    @Column(name = "IsImage")
    private boolean isImage;//是否图片
    @Column(name = "UploadTime")
    private Date uploadTime;//上传时间


//    @ManyToOne(targetEntity = RepairApp.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "PlanId",referencedColumnName = "id")
//    private RepairApp repairApp;//所属维修单
//
//
//    @ManyToOne(targetEntity = RepairPlan.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "AppId",referencedColumnName = "id")
//    private RepairPlan repairPlan;//所属维保方案


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public String getAttchmentDescription() {
        return attchmentDescription;
    }

    public void setAttchmentDescription(String attchmentDescription) {
        this.attchmentDescription = attchmentDescription;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean isImage) {
        this.isImage = isImage;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

//    public RepairApp getRepairApp() {
//        return repairApp;
//    }
//
//    public void setRepairApp(RepairApp repairApp) {
//        this.repairApp = repairApp;
//    }
//
//    public RepairPlan getRepairPlan() {
//        return repairPlan;
//    }
//
//    public void setRepairPlan(RepairPlan repairPlan) {
//        this.repairPlan = repairPlan;
//    }





}
