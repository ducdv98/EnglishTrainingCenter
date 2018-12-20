package vn.com.uit.data.repository;

import dtos.StaffDto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.uit.data.DBConnector;
import vn.uit.com.contracts.data.ILoginRepository;
import vn.uit.com.contracts.service.ILoginListener;

/**
 *
 * @author Admin
 */
public class LoginRepository implements ILoginRepository {

    private final ILoginListener _listener;
    private final Connection _connection;

    public LoginRepository(ILoginListener listener) {
        this._listener = listener;
        _connection = DBConnector.getConnection();
    }

    @Override
    public void checkCredential(String username, String passwordHash) {
        int idAccount = 0;
        try (CallableStatement cstm = _connection.prepareCall("{call usp_check_credential(?, ?)}")) {
            cstm.setString(1, username);
            cstm.setString(2, passwordHash);

            ResultSet rs = cstm.executeQuery();
            boolean empty = true;

            while (rs.next()) {
                idAccount = rs.getInt("MaTK");
                empty = false;
            }

            if (empty) {
                _listener.onCredentialIsNotValid("Tên tài khoản hoặc mật khẩu không đúng!");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onCredentialIsNotValid(ex.getMessage());
            return;
        }

        try (CallableStatement cstm = _connection.prepareCall("{call usp_get_user_info(?)}")) {
            cstm.setInt(1, idAccount);

            ResultSet rs = cstm.executeQuery();
            StaffDto employee = new StaffDto();
            employee.setUsername(username);
            while (rs.next()) {
                employee.setId(rs.getInt("MaNV"));
                employee.setName(rs.getString("TenNV"));
                employee.setIdentityCardNumber(rs.getString("CMND"));
                employee.setPhoneNum(rs.getString("SDT"));
                employee.setSalary(rs.getBigDecimal("Luong"));
                employee.setStartedDate(rs.getDate("NgayVaoLam"));
                employee.setRole(rs.getString("TenCV"));
                employee.setClaim(rs.getInt("Quyen"));
            }
            _listener.onGetCredentialSuccessful(employee);

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onCredentialIsNotValid(ex.getMessage());
        }
    }

}
