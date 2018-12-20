/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.uit.data.repository;

import dtos.TraineeDto;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.uit.data.DBConnector;
import vn.uit.com.contracts.data.ITraineeRepository;
import vn.uit.com.contracts.service.ITraineeListener;

/**
 *
 * @author Admin
 */
public class TraineeRepository implements ITraineeRepository {

    private final ITraineeListener _listener;
    private final Connection _connection;

    public TraineeRepository(ITraineeListener listener) {
        this._listener = listener;
        _connection = DBConnector.getConnection();
    }

    @Override
    public void getListTrainee() {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_get_all_trainee}")) {

            ResultSet rs = cstm.executeQuery();

            ArrayList<TraineeDto> list = new ArrayList();
            while (rs.next()) {
                TraineeDto trainee = new TraineeDto();
                trainee.setId(rs.getInt("MaHV"));
                trainee.setName(rs.getString("TenHV"));
                trainee.setAddress(rs.getString("DiaChi"));
                trainee.setPhoneNum(rs.getString("SDT"));
                trainee.setBirthday(rs.getDate("NgaySinh"));
                trainee.setFeePaid(rs.getBigDecimal("HocPhiDaDong"));
                trainee.setDateCreated(rs.getDate("NgayThamGia"));
                trainee.setTestMark(rs.getFloat("DiemDauVao"));
                list.add(trainee);

            }
            _listener.onGetListTraineeSuccessful(list);

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetListTraineeFail(ex.getMessage());

        }
    }

    @Override
    public void updateTrainee(TraineeDto trainee) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_update_trainee(?, ?, ?, ?, ?, ?)}")) {
            cstm.setInt(1, trainee.getId());
            cstm.setString(2, trainee.getName());
            cstm.setString(3, trainee.getPhoneNum());
            cstm.setString(4, trainee.getAddress());
            cstm.setDate(5, trainee.getBirthday());
            cstm.setBigDecimal(6, trainee.getFeePaid());
            cstm.setFloat(7, trainee.getTestMark());

            int rowEffected = cstm.executeUpdate();

            if (rowEffected > 0) {
                _listener.onUpdateTraineeSuccess();
            } else {
                _listener.onUpdateTraineeFail("No row effected!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onUpdateTraineeFail(ex.getMessage());
        }
    }

    @Override
    public void insertTrainee(TraineeDto trainee) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_new_trainee(?, ?, ?, ?, ?)}")) {
            cstm.setString(1, trainee.getName());
            cstm.setString(2, trainee.getAddress());
            cstm.setString(3, trainee.getPhoneNum());
            cstm.setDate(4, trainee.getBirthday());
            cstm.setFloat(5, trainee.getTestMark());
            
            int rowEffected = cstm.executeUpdate();

            if (rowEffected > 0) {
                _listener.onInsertTraineeSuccess();
            } else {
                _listener.onInsertTraineeFail("No row effected!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onInsertTraineeFail(ex.getMessage());
        }
    }

}
