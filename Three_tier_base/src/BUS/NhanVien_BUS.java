package BUS;

import java.util.ArrayList;

import DAL.nhanvien_DAO;
import DTO.NhanVien;

public class NhanVien_BUS {
	private nhanvien_DAO nvDAO_init;
	
	public NhanVien_BUS() { 
		nvDAO_init = new nhanvien_DAO();
	}
	
	public int insert(NhanVien obj) {
		if (nvDAO_init.selectById(obj) == null) { 
			return nvDAO_init.insert(obj);
		}
		else { 
			System.out.println("\nNhân Viên đã tồn tại (" + obj.getMaNV() + ") " + obj.getHo() + " " + obj.getTen());
			return 0; 
		}
	}

	public int insertAll(ArrayList<NhanVien> listObj) {
		// TODO Auto-generated method stub
		int count = 0;
		for (NhanVien nv : listObj) {
			count += this.insert(nv);
		}
		return count;
	}
	
	public int delete(NhanVien obj) {
		if (nvDAO_init.selectById(obj) == null) {
			System.out.println("Nhân viên không tồn tại để xóa (" + obj.getMaNV()
				+ ")" + obj.getHo() + " " + obj.getTen());
			return 0;
		} else {
			return nvDAO_init.delete(obj);
		}
	}
	
	public int deleteAll(ArrayList<NhanVien> listObj) {
		// TODO Auto-generated method stub
		int count = 0;
		for (NhanVien nv : listObj) {
			count += delete(nv);
		}
		return count;
	}
	
	public int update(NhanVien obj) {
		if (nvDAO_init.selectById(obj) == null) {
			System.out.println("\nKhông thể cập nhập nhân viên" + "(" +
					obj.getMaNV() + ") " + obj.getHo() + " " + 
					obj.getTen() + "Nhân Viên không tồn tại!");
			return 0;
		} else {
			return nvDAO_init.update(obj);
		}
	}
	
	public NhanVien selectById (NhanVien obj) {
		return nvDAO_init.selectById(obj);
	}
}
