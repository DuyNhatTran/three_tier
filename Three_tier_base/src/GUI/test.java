package GUI;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import BUS.NhanVien_BUS;

import java.util.ArrayList;

import DTO.NhanVien;

public class test {
	public static void main(String[] args) {
		SimpleDateFormat formartDate = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<NhanVien> list_nv = new ArrayList<>();
		NhanVien nhanvien = null;
		NhanVien nhanvien2 = null;
		NhanVien nhanvien3 = null;
		try {
			nhanvien = new NhanVien("NV4", "Lê", "Thành", formartDate.parse("2003-02-22"), formartDate.parse("2023-03-02"));
			nhanvien2 = new NhanVien("NV2", "Lê", "Đạt", formartDate.parse("2003-09-07"), formartDate.parse("2023-03-02"));
			nhanvien3 = new NhanVien("NV10", "Nhược", "Phi", formartDate.parse("2003-12-18"), formartDate.parse("2023-04-02"));
			list_nv.add(nhanvien); list_nv.add(nhanvien2); list_nv.add(nhanvien3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NhanVien_BUS nvBUS_init = new NhanVien_BUS();
		//_____Thêm 1 Nhân Viên_____
//		int rs = nvBUS_init.insert(nhanvien);
//		if (rs > 0) {
//			System.out.println("Có " + rs + " dòng được thêm vào");
//		}
		
		//_____Thêm Nhiều Nhân Viên_____
//		int rs = nvBUS_init.insertAll(list_nv);
//		if (rs > 0) {
//			System.out.println("Có " + rs + " dòng được thêm vào");
//		}
		
		//_____Xóa Nhiều Nhân Viên_____
//		int rs = nvBUS_init.deleteAll(list_nv);
//		if (rs > 0) {
//			System.out.println("Có " + rs + " dòng được Xóa!");
//		}
		
		//_____Xóa 1 Nhân Viên_____
//		int rs = nvBUS_init.delete(nhanvien);
//		if (rs > 0) {
//			System.out.println("Có " + rs + " dòng được thêm vào");
//		}
		
		//_____Cập Nhập 1 Nhân Viên_____
		int rs = nvBUS_init.update(nhanvien3);
		if (rs > 0) {
			System.out.println("Có " + rs + " dòng được thay đổi!");
		}
	}
}
