/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.uit.data.repository;

import dtos.CourseDto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.uit.data.DBConnector;
import vn.uit.com.contracts.data.ICourseRepository;
import vn.uit.com.contracts.service.ICourseListener;

/**
 *
 * @author Admin
 */
public class CourseRepository implements ICourseRepository {

    private ICourseListener _listener;
    private Connection _connection;

    public CourseRepository(ICourseListener listener) {
        this._listener = listener;
        _connection = DBConnector.getConnection();
    }

    @Override
    public void getListCourse() {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_get_all_course}")) {

            ResultSet rs = cstm.executeQuery();

            ArrayList<CourseDto> list = new ArrayList();
            while (rs.next()) {
                CourseDto course = new CourseDto();
                course.setId(rs.getInt("MaKH"));
                course.setName(rs.getString("TenKH"));
                course.setFee(rs.getBigDecimal("HocPhi"));
                course.setDuration(rs.getInt("ThoiGianKD"));
                course.setBenchmark(rs.getFloat("DiemDauVao"));
                course.setStatus(rs.getBoolean("TrangThai"));
                list.add(course);

            }
            _listener.onGetListCourseSuccess(list);

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetListCourseFail(ex.getMessage());
        }
    }

    @Override
    public void updateCourse(CourseDto course) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_update_course(?, ?, ?, ?, ?)}")) {
            cstm.setInt(1, course.getId());
            cstm.setString(2, course.getName());
            cstm.setBigDecimal(3, course.getFee());
            cstm.setInt(4, course.getDuration());
            cstm.setFloat(5, course.getBenchmark());

            int rowEffected = cstm.executeUpdate();

            if (rowEffected > 0) {
                _listener.onUpdateCourseSuccess();
            } else {
                _listener.onGetListCourseFail("No row effected!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onGetListCourseFail(ex.getMessage());

        }
    }

    @Override
    public void deactiveCourse(int id) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_deactive_course(?)}")) {
            cstm.setInt(1, id);

            cstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public void insertCourse(CourseDto course) {
        try (CallableStatement cstm = _connection.prepareCall("{call usp_new_course(?, ?, ?, ?)}")) {
            cstm.setString(1, course.getName());
            cstm.setBigDecimal(2, course.getFee());
            cstm.setInt(3, course.getDuration());
            cstm.setFloat(4, course.getBenchmark());
            
            int rowEffected = cstm.executeUpdate();

            if (rowEffected > 0) {
                _listener.onInsertCourseSuccess();
            } else {
                _listener.onInsertCourseFail("No row effected!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
            _listener.onInsertCourseFail(ex.getMessage());
        }
    }

}
