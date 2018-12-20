/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.uit.data.repository;

import dtos.ClassDto;
import dtos.CourseDto;
import dtos.StaffDto;
import dtos.TraineeDto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.uit.data.DBConnector;
import vn.uit.com.contracts.data.IClassRepository;
import vn.uit.com.contracts.service.IClassListener;

/**
 *
 * @author Admin
 */
public class ClassRepository implements IClassRepository {

    private Connection _connection;
    private IClassListener _listener;

    public ClassRepository(IClassListener listener) {
        _connection = DBConnector.getConnection();
        _listener = listener;
    }

    @Override
    public void getListClass() {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_get_all_class}")) {

            ResultSet rs = cstm.executeQuery();

            ArrayList<ClassDto> list = new ArrayList();
            while (rs.next()) {
                ClassDto _class = new ClassDto();
                _class.setId(rs.getInt("MaLH"));
                _class.setName(rs.getString("TenLH"));
                _class.setCapacity(rs.getInt("SiSo"));
                _class.setCurrentQuantity(rs.getInt("SoHVHienCo"));
                _class.setTime(rs.getString("ThoiGianHoc"));
                _class.setStartedDate(rs.getDate("NgayBatDau"));
                _class.setEndedDate(rs.getDate("NgayKetThuc"));
                _class.setStatus(rs.getBoolean("TrangThai"));
                _class.setRoom(rs.getString("Phong"));
                _class.setCourseId(rs.getInt("MaKH"));
                _class.setTeacherId(rs.getInt("MaNV"));
                list.add(_class);

            }
            _listener.onGetListClassSuccess(list);

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetListClassFail(ex.getMessage());
        }
    }

    @Override
    public void getListTraineeInClass(int classId, int courseId) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_get_list_trainee_in_class(?, ?)}")) {

            cstm.setInt(1, classId);
            cstm.setInt(2, courseId);

            ResultSet rs = cstm.executeQuery();

            ArrayList<TraineeDto> list = new ArrayList();
            while (rs.next()) {
                TraineeDto trainee = new TraineeDto();
                trainee.setId(rs.getInt("MaHV"));
                trainee.setName(rs.getString("TenHV"));
                trainee.setStartedDate(rs.getDate("NgayBatDau"));
                trainee.setCourseMark(rs.getFloat("DiemTotNghiep"));
                list.add(trainee);

            }
            _listener.onGetListTraineeInClassSuccess(list);

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetListTraineeInClassFail(ex.getMessage());
        }
    }

    @Override
    public void updateTraineeMark(int classId, int courseId, int traineeId, float mark) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_update_trainee_mark(?, ?, ?, ?)}")) {
            cstm.setInt(1, classId);
            cstm.setInt(2, courseId);
            cstm.setInt(3, traineeId);
            cstm.setFloat(4, mark);

            int rowEffected = cstm.executeUpdate();

            if (rowEffected > 0) {
                _listener.onUpdateTraineeMarkSuccess();
            } else {
                _listener.onUpdateTraineeMarkFail("No row effected!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onUpdateTraineeMarkFail(ex.getMessage());
        }
    }

    @Override
    public void getListCourseAndListStaff() {
        ArrayList<CourseDto> listCourse = null;
        ArrayList<StaffDto> listStaff = null;

        try (CallableStatement cstm = _connection.prepareCall("{call usp_get_course_available}")) {

            ResultSet rs = cstm.executeQuery();

            listCourse = new ArrayList();
            while (rs.next()) {
                CourseDto course = new CourseDto();
                course.setId(rs.getInt("MaKH"));
                course.setName(rs.getString("TenKH"));
                listCourse.add(course);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetCoursesAndStaffsFail(ex.getMessage());
        }
        
        try (CallableStatement cstm = _connection.prepareCall("{call usp_get_all_staff_available}")) {

            ResultSet rs = cstm.executeQuery();

            listStaff = new ArrayList();
            while (rs.next()) {
                StaffDto staff = new StaffDto();
                staff.setId(rs.getInt("MaNV"));
                staff.setName(rs.getString("TenNV"));
                listStaff.add(staff);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetCoursesAndStaffsFail(ex.getMessage());
        }
        
        _listener.onGetCoursesAndStaffsSuccess(listCourse, listStaff);
    }

    @Override
    public void insertClass(ClassDto classDto) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_new_class(?, ?, ?, ?, ?, ?, ?, ?)}")) {
            cstm.setString(1, classDto.getName());
            cstm.setInt(2, classDto.getCapacity());
            cstm.setString(3, classDto.getTime());
            cstm.setDate(4, classDto.getStartedDate());
            cstm.setDate(5, classDto.getEndedDate());
            cstm.setString(6, classDto.getRoom());
            cstm.setInt(7, classDto.getCourseId());
            cstm.setInt(8, classDto.getTeacherId());
            
            int rowEffected = cstm.executeUpdate();

            if (rowEffected > 0) {
                _listener.onInsertClassSuccess();
            } else {
                _listener.onInsertClassFail("No row effected!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onInsertClassFail(ex.getMessage());
        }
    }

}
