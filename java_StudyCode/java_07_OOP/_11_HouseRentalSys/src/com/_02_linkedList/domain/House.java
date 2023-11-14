package com._02_linkedList.domain;

public class House {
    private int id;// 房屋编号
    private String name;
    private String phone;
    private String address;
    private double rent;// 租金
    private String state;// 状态 (未出租/已出租)

    public House(int id, String name, String phone, String address, double rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public House() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", rent=" + rent +
                ", state='" + state + '\'' +
                '}';
    }

    public void copyData(House otherHouse) {
        this.id = otherHouse.id;
        this.name = otherHouse.name;
        this.phone = otherHouse.phone;
        this.address = otherHouse.address;
        this.rent = otherHouse.rent;
        this.state = otherHouse.state;
    }
}
