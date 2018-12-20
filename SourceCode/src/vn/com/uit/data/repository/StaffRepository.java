package vn.com.uit.data.repository;

import dtos.StaffDto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.uit.data.DBConnector;
import vn.uit.com.contracts.data.IStaffRepository;
import vn.uit.com.contracts.service.IStaffListener;

/**
 *
 * @author Admin
 */
public class StaffRepository implements IStaffRepository {

    private final IStaffListener _listener;
    private final Connection _connection;

    public StaffRepository(IStaffListener listener) {
        this._listener = listener;
        _connection = DBConnector.getConnection();
    }

    @Override
    public void getListStaff() {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_get_all_staff}")) {

            ResultSet rs = cstm.executeQuery();

            ArrayList<StaffDto> list = new ArrayList();
            while (rs.next()) {
                StaffDto staff = new StaffDto();
                staff.setId(rs.getInt("MaNV"));
                staff.setName(rs.getString("TenNV"));
                staff.setIdentityCardNumber(rs.getString("CMND"));
                staff.setSalary(rs.getBigDecimal("Luong"));
                staff.setPhoneNum(rs.getString("SDT"));
                staff.setStartedDate(rs.getDate("NgayVaoLam"));
                staff.setIdRole(rs.getInt("MaCV"));
                staff.setRole(rs.getString("TenCV"));
                staff.setUsername(rs.getString("Username"));
                staff.setPassword(rs.getString("Password"));
                list.add(staff);

            }
            _listener.onGetListStaffSuccess(list);

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetListStaffFail(ex.getMessage());

        }
    }

    @Override
    public void deactiveStaff(int id) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_deactive_staff(?)}")) {
            cstm.setInt(1, id);

            cstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void updateStaff(StaffDto staff) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_update_staff(?, ?, ?, ?, ?)}")) {
            cstm.setInt(1, staff.getId());
            cstm.setString(2, staff.getIdentityCardNumber());
            cstm.setString(3, staff.getPhoneNum());
            cstm.setInt(4, staff.getIdRole());
            cstm.setBigDecimal(5, staff.getSalary());

            int rowEffected = cstm.executeUpdate();

            if (rowEffected > 0) {
                _listener.onUpdateStaffSuccess();
            } else {
                _listener.onGetListStaffFail("No row effected!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetListStaffFail(ex.getMessage());

        }
    }

    @Override
    public void insertStaff(StaffDto staff) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_check_user_exists(?)}")) {
            cstm.setString(1, staff.getUsername());

            ResultSet rs = cstm.executeQuery();
            boolean empty = true;

            while (rs.next()) {
                empty = false;
            }

            if (!empty) {
                _listener.onCreateStaffFail("Tên tài khoản đã tồn tại!");
                return;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetListStaffFail(ex.getMessage());
            return;
        }

        try (CallableStatement cstm = _connection.prepareCall("{call usp_new_staff(?, ?, ?, ?, ?, ?, ?)}")) {
            cstm.setString(1, staff.getName());
            cstm.setString(2, staff.getIdentityCardNumber());
            cstm.setString(3, staff.getPhoneNum());
            cstm.setInt(4, staff.getIdRole());
            cstm.setBigDecimal(5, staff.getSalary());
            cstm.setString(6, staff.getUsername());
            cstm.setString(7, staff.getPassword());

            int rowEffected = cstm.executeUpdate();

            if (rowEffected > 0) {
                _listener.onCreateStaffSuccess();
            } else {
                _listener.onCreateStaffFail("No row effected!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetListStaffFail(ex.getMessage());
        }
    }

}
