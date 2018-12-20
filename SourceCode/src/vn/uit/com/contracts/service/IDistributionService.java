/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.service;

/**
 *
 * @author Admin
 */
public interface IDistributionService {
    void searchTrainee(int id, int flag);
    void searchClass(int id);
    void enrollClass(int courseId, int classId, int traineeId);
    void printReceipt(int courseId, int classId, int traineeId, int staffId);
}
