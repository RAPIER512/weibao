package ccu.model.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Courage on 2015/10/14.
 */

/**
 * 快录类型
 */

@Entity
@Table(name = "RapidRecordType")
public class RapidRecordType implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "guid")
    private String id;//标识
    @Column(name = "TypeName")
    private String typeName;//类型名称

//    @OneToMany(targetEntity = RapidRecordDetail.class,fetch = FetchType.EAGER)
//    @JoinColumn(name = "TypeId",referencedColumnName = "id")
//    private Set<RapidRecordDetail> rapidRecordDetails = new HashSet<RapidRecordDetail>( );//快录明细


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

//    public Set<RapidRecordDetail> getRapidRecordDetails() {
//        return rapidRecordDetails;
//    }
//
//    public void setRapidRecordDetails(Set<RapidRecordDetail> rapidRecordDetails) {
//        this.rapidRecordDetails = rapidRecordDetails;
//    }





}
