package ccu.model.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Courage on 2015/10/14.
 */


/**
 * 快录明细表
 */

@Entity
@Table(name = "RapidRecordDetail")
public class RapidRecordDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识


//    @ManyToOne(targetEntity = RapidRecordType.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "TypeId",referencedColumnName = "id")
//    private RapidRecordType ripadRecordType;//类型
    @Column(name = "TypeId")
    private String typeId;

    @Column(name = "DetailName")
    private String detailName;//名称
    @Column(name = "IndexCode")
    private String indexCode;//索引代码
    @Column(name = "OrderId")
    private int orderId;//顺序号
    @Column(name = "DetailDescription")
    private String detailDescription;//描述


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public RapidRecordType getRipadRecordType() {
//        return ripadRecordType;
//    }
//
//    public void setRipadRecordType(RapidRecordType ripadRecordType) {
//        this.ripadRecordType = ripadRecordType;
//    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
