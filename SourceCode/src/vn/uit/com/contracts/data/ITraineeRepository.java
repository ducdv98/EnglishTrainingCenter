/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.data;

import dtos.TraineeDto;

/**
 *
 * @author Admin
 */
public interface ITraineeRepository {
    void getListTrainee();
    void updateTrainee(TraineeDto trainee);
    void insertTrainee(TraineeDto trainee);
}
