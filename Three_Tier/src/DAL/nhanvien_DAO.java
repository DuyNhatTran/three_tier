package DAL;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DTO.NhanVien;

public class nhanvien_DAO implements DAOInterface<NhanVien> {
	private ArrayList<NhanVien> ds_nhanvien;
	private SimpleDateFormat fomartDateSql;
	
	public nhanvien_DAO() {
		fomartDateSql = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	@Override
	public ArrayList<NhanVien> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<NhanVien> ds_nv_kq = new ArrayList<>();
		try {
			Connection connect = JDBC_mySQL.getConnection();
			String selectAllQuery = "SELECT * FROM nhanvien";
			PreparedStatement prepareStm = connect.prepareStatement(selectAllQuery);
			ResultSet rs = prepareStm.executeQuery();
			while (rs.next()) {
				String maNv = rs.getString(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				Date ngaySinh = rs.getDate(4);
				Date ngay_BD = rs.getDate(5);
				NhanVien nhanvien = new NhanVien(maNv, ho, ten, ngaySinh, ngay_BD);
				ds_nv_kq.add(nhanvien);
			}
			JDBC_mySQL.closeConnection(connect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds_nv_kq;
	}

	@Override
	public NhanVien selectById(NhanVien obj) {
		// TODO Auto-generated method stub
		NhanVien nhanVien_rs = null;
		try {
			Connection connect = JDBC_mySQL.getConnection();
			String selectById_query = "SELECT * FROM nhanvien WHERE maNV = ?";
			PreparedStatement prepareStm = connect.prepareStatement(selectById_query);
			prepareStm.setString(1, obj.getMaNV());
			ResultSet rs_set = prepareStm.executeQuery();
			while(rs_set.next()) {
				String maNV = rs_set.getString(1);
				String ho = rs_set.getString(2);
				String ten = rs_set.getString(3);
				Date ngaySinh = rs_set.getDate(4);
				Date ngay_BD = rs_set.getDate(5);
				nhanVien_rs = new NhanVien(maNV, ho, ten, ngaySinh, ngay_BD);
			}
			JDBC_mySQL.closeConnection(connect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nhanVien_rs;
	}

	@Override
	public int insert(NhanVien obj) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection connect = JDBC_mySQL.getConnection();
			String insert_query = "INSERT INTO nhanvien VALUES(?, ?, ?, ?, ?)";
			PreparedStatement prepareStm = connect.prepareStatement(insert_query);
			prepareStm.setString(1, obj.getMaNV());
			prepareStm.setString(2, obj.getHo());
			prepareStm.setString(3, obj.getTen());
			prepareStm.setString(4, fomartDateSql.format(obj.getNgaySinh()));
			prepareStm.setString(5, fomartDateSql.format(obj.getNgayBatDau()));
			result = prepareStm.executeUpdate();
			JDBC_mySQL.closeConnection(connect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(NhanVien obj) {
		// TODO Auto-generated method stub
		int rs = 0;
		try {
			Connection connect = JDBC_mySQL.getConnection();
			String deleteQuery = "DELETE FROM nhanvien WHERE maNV = ?";
			PreparedStatement prepareStm = connect.prepareStatement(deleteQuery);
			prepareStm.setString(1, obj.getMaNV());
			rs = prepareStm.executeUpdate();
			JDBC_mySQL.closeConnection(connect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int update(NhanVien obj) {
		// TODO Auto-generated method stub
		int rs = 0;
		try {
			Connection connect = JDBC_mySQL.getConnection();
			String updateNvQuery = "UPDATE nhanvien"
					+ " SET Ho = ?, Ten = ?, NgaySinh = ?, NgayBatDauLam = ? "
					+ " WHERE MaNV = ?;";
			PreparedStatement prepareStm = connect.prepareStatement(updateNvQuery);
			prepareStm.setString(1, obj.getHo());
			prepareStm.setString(2, obj.getTen());
			prepareStm.setString(3, fomartDateSql.format(obj.getNgaySinh()));
			prepareStm.setString(4, fomartDateSql.format(obj.getNgayBatDau()));
			prepareStm.setString(5, obj.getMaNV());
			rs = prepareStm.executeUpdate();
			JDBC_mySQL.closeConnection(connect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
