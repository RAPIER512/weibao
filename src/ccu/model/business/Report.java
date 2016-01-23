package ccu.model.business;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Courage on 2015/10/14.
 */


/**
 * 投诉表
 */

@Entity
@Table(name = "Report")
public class Report implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识


//    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "RecordUserId",referencedColumnName = "id")
//    private User user;//录入人


    @Column(name = "RecordUserId")
    private  String recordUserId;

    @Column(name = "ReportName")
    private String reportName;//投诉人姓名
    @Column(name = "ReportTime")
    private Date reportTime;//投诉时间
    @Column(name = "ReportDescription")
    private String reportDescription;//备注
    @Column(name = "HandleResult")
    private String handleResult;//处理结果
    @Column(name = "RecordTime")
    private Date recordTime;//录入日期


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


    public String getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(String recordUserId) {
        this.recordUserId = recordUserId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }





}
