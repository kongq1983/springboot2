package com.kq.es.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author kq
 * @date 2021-01-19 17:15
 * @since 2020-0630
 */
public class SaleOrder {
    //有些第一行有???，導致取不到SALEORDERID
    // ???"SALEORDERID","ORDERCODE","USERID","ACCOUNT","NAME","ORDERAMOUNT","PAYAMOUNT","ORDERSTATUS","PAYTYPE","DELIVERYMODE","PAYSTATUS","ORGID","OUTSYSTEMORDERCODE","PICKUPCODE","TRADINGPURSE",        "SALEDATE","SALETYPE","SALETYPENAME","ORDERTIME","CREATETIME"

    @CsvBindByName(column = "SALEORDERID")
    private String saleOrderId;
    @CsvBindByName(column = "ORGID")
    private String orgId;
    @CsvBindByName(column = "ORDERCODE")
    private String orderCode;
    @CsvBindByName(column = "USERID")
    private String userId;
    @CsvBindByName(column = "ACCOUNT")
    private String account;
    @CsvBindByName(column = "NAME")
    private String name;
    @CsvBindByName(column = "OUTSYSTEMORDERCODE")
    private String outSystemOrderCode;
    @CsvBindByName(column = "PICKUPCODE")
    private String pickUpCode;
    @CsvBindByName(column = "TRADINGPURSE")
    private String tradingPurse;
    @CsvBindByName(column = "SALETYPENAME")
    private String saleTypeName;
    @CsvBindByName(column = "ORDERAMOUNT")
    private BigDecimal orderAmount;
    @CsvBindByName(column = "PAYAMOUNT")
    private BigDecimal payAmount;
    @CsvBindByName(column = "SALETYPE")
    private Integer saleType = -1;
    @CsvBindByName(column = "ORDERSTATUS")
    private Integer orderStatus;
    @CsvBindByName(column = "PAYTYPE")
    private Integer payType;
    /** 收获方式*/
    @CsvBindByName(column = "DELIVERYMODE")
    private Integer deliveryMode;
    @CsvBindByName(column = "PAYSTATUS")
    private Integer payStatus;

    @CsvBindByName(column = "SALEDATE")
    @CsvDate(value="yyyy-MM-dd")
    private Date saleDate;
    @CsvBindByName(column = "ORDERTIME")
    @CsvDate(value="yyyy-MM-dd HH:mm:ss")
    private Date orderTime;
    @CsvBindByName(column = "CREATETIME")
    @CsvDate(value="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public String getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(String saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutSystemOrderCode() {
        return outSystemOrderCode;
    }

    public void setOutSystemOrderCode(String outSystemOrderCode) {
        this.outSystemOrderCode = outSystemOrderCode;
    }

    public String getPickUpCode() {
        return pickUpCode;
    }

    public void setPickUpCode(String pickUpCode) {
        this.pickUpCode = pickUpCode;
    }

    public String getTradingPurse() {
        return tradingPurse;
    }

    public void setTradingPurse(String tradingPurse) {
        this.tradingPurse = tradingPurse;
    }

    public String getSaleTypeName() {
        return saleTypeName;
    }

    public void setSaleTypeName(String saleTypeName) {
        this.saleTypeName = saleTypeName;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        if(saleType!=null) {
            this.saleType = saleType;
        }
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(Integer deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        if(this.saleDate==null) {
            this.saleDate = createTime;
        }
    }

    @Override
    public String toString() {
        return "SaleOrder{" +
                "saleOrderId='" + saleOrderId + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", userId='" + userId + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", outSystemOrderCode='" + outSystemOrderCode + '\'' +
                ", pickUpCode='" + pickUpCode + '\'' +
                ", tradingPurse='" + tradingPurse + '\'' +
                ", saleTypeName='" + saleTypeName + '\'' +
                ", orderAmount=" + orderAmount +
                ", payAmount=" + payAmount +
                ", saleType=" + saleType +
                ", orderStatus=" + orderStatus +
                ", payType=" + payType +
                ", deliveryMode=" + deliveryMode +
                ", payStatus=" + payStatus +
                ", saleDate=" + saleDate +
                ", orderTime=" + orderTime +
                ", createTime=" + createTime +
                '}';
    }
}
