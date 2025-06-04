package deliveryController.dto;

import java.time.LocalDate;

public class Delivery {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String product_name;
    private LocalDate request_date;
    private String status;

    public Delivery() {
    }

    public Delivery(String name, String address, String phone, String product_name, LocalDate request_date) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.product_name = product_name;
        this.request_date = request_date;
        this.status = "대기";
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public LocalDate getRequest_date() {
        return request_date;
    }

    public void setRequest_date(LocalDate request_date) {
        this.request_date = request_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + address + " | " + phone + " | "
                + product_name + " | " + request_date + " | " + status;
    }
}
