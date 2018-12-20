/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.data;

/**
 *
 * @author Admin
 */
public interface IDistributionRepository {
    void getTraineeInfo(int id, int flag);
    void getListClassInCourse(int courseId);
    void insertTraineeToClass(int courseId, int classId, int traineeId);
}
