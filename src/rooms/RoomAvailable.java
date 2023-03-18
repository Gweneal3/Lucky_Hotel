package rooms;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Wei
 */
public class RoomAvailable {
    private String roomid;
    private String roomtype;
    private int guestAdult;
    private int guestKid;
    private String bed;
    private String description;
    private double price;
    private byte[] image;
    private double rating;
    private String review;
    private int NoOfBed1;
    private int NoOfBed2;
    public RoomAvailable(String roomid,String roomtype,int guestAdult,int guestKid,String bed, String description,double price,byte[] image,double rating,String review){  
        this.roomid = roomid;
        this.roomtype = roomtype;
        this.guestAdult = guestAdult;
        this.guestKid = guestKid;
        this.bed = bed;
        this.description = description;
        this.price = price;
        this.image = image;
        this.rating = rating;
        this.review = review;      
    }

    public RoomAvailable(String roomid, String roomtype, int guestAdult, int guestKid, int NoOfBed1, int NoOfBed2, String description, double price, byte[] image, double rating, String review) {
        this.roomid = roomid;
        this.roomtype = roomtype;
        this.guestAdult = guestAdult;
        this.guestKid = guestKid;
        this.NoOfBed1 = NoOfBed1;
        this.NoOfBed2 = NoOfBed2;
        this.description = description;
        this.price = price;
        this.image = image;
        this.rating = rating;
        this.review = review;
    }

    public void setGuestAdult(int guestAdult) {
        this.guestAdult = guestAdult;
    }

    public void setGuestKid(int guestKid) {
        this.guestKid = guestKid;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
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

    public int getNoOfBed1() {
        return NoOfBed1;
    }

    public void setNoOfBed1(int NoOfBed1) {
        this.NoOfBed1 = NoOfBed1;
    }

    public int getNoOfBed2() {
        return NoOfBed2;
    }

    public void setNoOfBed2(int NoOfBed2) {
        this.NoOfBed2 = NoOfBed2;
    }
    
    public String getRoomID(){
        return roomid;
    }
    
    public String getRoomType(){
        return roomtype;
    }
    
    public int getGuestAdult(){
        return guestAdult;
    }
    
    public int getGuestKid(){
        return guestKid;
    }
    
    public String getBed(){
        return bed;
    }
    
    public String getDescription(){
        return description;
    }
    
    public double getPrice(){
        return price;
    }
    
    public byte[] getImage(){
        return image;
    }
    
    
    public double getRating(){
        return rating;
    }
    
    public String getReview(){
        return review;
    }
}
