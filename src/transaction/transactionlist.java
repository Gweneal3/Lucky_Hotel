/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaction;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


public class transactionlist {
    private String roomid;
    private String roomtype;
    private double total_pay;
    private int noOfDay;
    private Date checkindate;
    private Date checkoutdate;
    private Timestamp datetimeTransaction;

    public transactionlist(String roomid, String roomtype, double total_pay, int noOfDay, Date checkindate, Date checkoutdate, Timestamp datetimeTransaction) {
        this.roomid = roomid;
        this.roomtype = roomtype;
        this.total_pay = total_pay;
        this.noOfDay = noOfDay;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.datetimeTransaction = datetimeTransaction;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public double getTotal_pay() {
        return total_pay;
    }

    public void setTotal_pay(double total_pay) {
        this.total_pay = total_pay;
    }

    public int getNoOfDay() {
        return noOfDay;
    }

    public void setNoOfDay(int noOfDay) {
        this.noOfDay = noOfDay;
    }

    public Date getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(Date checkindate) {
        this.checkindate = checkindate;
    }

    public Date getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(Date checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public Timestamp getDatetimeTransaction() {
        return datetimeTransaction;
    }

    public void setDatetimeTransaction(Timestamp datetimeTransaction) {
        this.datetimeTransaction = datetimeTransaction;
    }
}
