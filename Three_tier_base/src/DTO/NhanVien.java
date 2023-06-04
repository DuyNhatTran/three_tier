package DTO;

import java.util.Date;
import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String ho;
	private String ten;
	private Date ngaySinh;
	private Date ngayBatDau;
	
	public NhanVien() {}

	public NhanVien(String maNV, String ho, String ten, Date ngaySinh, Date ngayBatDau) {
		super();
		this.maNV = maNV;
		this.ho = ho;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.ngayBatDau = ngayBatDau;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", ho=" + ho + ", ten=" + ten + ", ngaySinh=" + ngaySinh + ", ngayBatDau="
				+ ngayBatDau + "]";
	}
	
	
}
