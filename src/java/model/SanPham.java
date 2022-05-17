package model;

public class SanPham {

    private int maSP;
    private String tenSP;
    private int maTL;

    public SanPham() {
    }

    public SanPham(int maSP, String tenSP, int maTL) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maTL = maTL;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getMaTL() {
        return maTL;
    }

    public void setMaTL(int maTL) {
        this.maTL = maTL;
    }
}
