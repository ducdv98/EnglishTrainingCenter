
package vn.uit.com.business.service;

import dtos.ClassDto;
import dtos.CourseDto;
import dtos.ParticipationDto;
import dtos.TraineeDto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import vn.com.uit.common.Constants;
import vn.com.uit.data.DBConnector;
import vn.com.uit.data.repository.DistributionRepository;
import vn.uit.com.contracts.data.IDistributionRepository;
import vn.uit.com.contracts.service.IDistributionListener;
import vn.uit.com.contracts.service.IDistributionService;
import vn.uit.com.contracts.ui.IDistributionForm;

/**
 *
 * @author Admin
 */
public class DistributionService implements IDistributionService, IDistributionListener {

    private IDistributionForm _diDistributionForm;
    private IDistributionRepository _db;

    public DistributionService(IDistributionForm distributionForm) {
        this._diDistributionForm = distributionForm;
        _db = new DistributionRepository(this);
    }

    @Override
    public void searchTrainee(int id, int flag) {
        _db.getTraineeInfo(id, flag);
    }

    @Override
    public void onGetTraineeInfoSuccess(TraineeDto trainee, ArrayList<ParticipationDto> listParticipations) {
        if (trainee != null) {
            _diDistributionForm.displayTraineeInfo(trainee, listParticipations);
        }
    }

    @Override
    public void onGetTraineeFail(String err) {

    }

    @Override
    public void searchClass(int id) {
        _db.getListClassInCourse(id);
    }

    @Override
    public void onGetListClassSuccess(CourseDto course, ArrayList<ClassDto> list) {
        _diDistributionForm.displayListClassInCourse(course, list);
    }

    @Override
    public void onGetListClassFail(String err) {
        _diDistributionForm.displayMessage(err, Constants.FLAG_DEFAULT);
    }

    @Override
    public void enrollClass(int courseId, int classId, int traineeId) {
        _db.insertTraineeToClass(courseId, classId, traineeId);
    }

    @Override
    public void onAddTraineeToClassSuccess() {
        _diDistributionForm.displayMessage("Ghi danh thành công!", Constants.FLAG_REFRESH);
    }

    @Override
    public void onAddTraineeToClassFail(String err) {
        _diDistributionForm.displayMessage("Ghi danh thất bại! \nLỗi: " + err, Constants.FLAG_DEFAULT);
    }

    @Override
    public void printReceipt(int courseId, int classId, int traineeId, int staffId) {
        HashMap params = new HashMap();
        params.put("classId", new Integer(classId));
        params.put("courseId", new Integer(courseId));
        params.put("traineeId", new Integer(traineeId));
        params.put("staffId", new Integer(staffId));
        
        Connection conn = DBConnector.getConnection();
        try {
            InputStream is = new FileInputStream("src\\report\\schoolFeeReceipt.jasper");
            JasperPrint print = JasperFillManager.fillReport(is, params, conn);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.viewReport(print, false);
        } catch (FileNotFoundException | JRException ex) {
            Logger.getLogger(DistributionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
