package com.example.lab2bai3;

public class Employee {
    protected String maNV;
    protected String tenNV;

    public Employee(String maNV, String tenNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    // Phương thức toString để ghi đè ở các lớp con
    public String toString() {
        return maNV + " - " + tenNV;
    }
}
