/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.uit.data.repository;

import dtos.ClassDto;
import dtos.CourseDto;
import dtos.ParticipationDto;
import dtos.TraineeDto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.uit.common.Constants;
import vn.com.uit.data.DBConnector;
import vn.uit.com.contracts.data.IDistributionRepository;
import vn.uit.com.contracts.service.IDistributionListener;

/**
 *
 * @author Admin
 */
public class DistributionRepository implements IDistributionRepository {

    private Connection _connection;
    private IDistributionListener _listener;

    public DistributionRepository(IDistributionListener listener) {
        this._listener = listener;
        _connection = DBConnector.getConnection();
    }

    @Override
    public void getTraineeInfo(int id, int flag) {

        if (flag == Constants.FLAG_DEFAULT) {
            TraineeDto trainee = null;
            try (CallableStatement cstm = _connection.prepareCall("{call usp_get_newest_trainee}")) {
                ResultSet rs = cstm.executeQuery();

                trainee = new TraineeDto();
                while (rs.next()) {
                    trainee.setId(rs.getInt("MaHV"));
                    trainee.setName(rs.getString("TenHV"));
                    trainee.setAddress(rs.getString("DiaChi"));
                    trainee.setBirthday(rs.getDate("NgaySinh"));
                    trainee.setTestMark(rs.getFloat("DiemDauVao"));
                }
                _listener.onGetTraineeInfoSuccess(trainee, null);

            } catch (SQLException ex) {
                Logger.getLogger(DistributionRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            TraineeDto trainee = null;
            try (CallableStatement cstm = _connection.prepareCall("{call usp_get_trainee_info(?)}")) {
                cstm.setInt(1, id);
                ResultSet rs = cstm.executeQuery();
                boolean isTraineeNotExists = true;

                trainee = new TraineeDto();
                while (rs.next()) {
                    trainee.setId(id);
                    trainee.setName(rs.getString("TenHV"));
                    trainee.setAddress(rs.getString("DiaChi"));
                    trainee.setBirthday(rs.getDate("NgaySinh"));
                    trainee.setTestMark(rs.getFloat("DiemDauVao"));
                    isTraineeNotExists = false;
                }

                if (isTraineeNotExists) {
                    _listener.onGetTraineeInfoSuccess(null, null);
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
                _listener.onGetTraineeFail(ex.getMessage());
            }

            try (CallableStatement cstm = _connection.prepareCall("{call usp_get_all_course_of_trainee(?)}")) {

                cstm.setInt(1, id);

                ResultSet rs = cstm.executeQuery();

                ArrayList<ParticipationDto> list = new ArrayList();
                while (rs.next()) {
                    ParticipationDto participation = new ParticipationDto();
                    participation.setClassId(rs.getInt("MaLH"));
                    participation.setClassName(rs.getString("TenLH"));
                    participation.setCourseId(rs.getInt("MaKH"));
                    participation.setCourseName(rs.getString("TenKH"));
                    participation.setMark(rs.getFloat("DiemTotNghiep"));

                    list.add(participation);

                }
                _listener.onGetTraineeInfoSuccess(trainee, list);

            } catch (SQLException ex) {
                Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
                _listener.onGetTraineeFail(ex.getMessage());
            }
        }
    }

    @Override
    public void getListClassInCourse(int courseId) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_get_list_class_in_course(?)}")) {

            cstm.setInt(1, courseId);

            ResultSet rs = cstm.executeQuery();

            ArrayList<ClassDto> list = new ArrayList();
            CourseDto course = new CourseDto();
            course.setId(courseId);
            while (rs.next()) {
                ClassDto _class = new ClassDto();
                _class.setId(rs.getInt("MaLH"));
                _class.setName(rs.getString("TenLH"));
                _class.setCapacity(rs.getInt("SiSo"));
                _class.setCurrentQuantity(rs.getInt("SoHVHienCo"));
                _class.setTime(rs.getString("ThoiGianHoc"));
                _class.setStartedDate(rs.getDate("NgayBatDau"));
                course.setName(rs.getString("TenKH"));
                course.setFee(rs.getBigDecimal("HocPhi"));
                list.add(_class);

            }
            if (!list.isEmpty()) {
                _listener.onGetListClassSuccess(course, list);
            } else {
                _listener.onGetListClassFail("Không còn lớp hoặc khoá học đã bị đóng!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetListClassFail(ex.getMessage());
        }
    }

    @Override
    public void insertTraineeToClass(int courseId, int classId, int traineeId) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_add_trainee_to_class(?, ?, ?)}")) {
            cstm.setInt(1, courseId);
            cstm.setInt(2, classId);
            cstm.setInt(3, traineeId);
            
            int rowEffected = cstm.executeUpdate();

            if (rowEffected > 0) {
                _listener.onAddTraineeToClassSuccess();
            } else {
                _listener.onAddTraineeToClassFail("Học viên đã hoặc đang học khoá/lớp này!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onAddTraineeToClassFail(ex.getMessage());
        }
    }

}
