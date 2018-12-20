/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.service;

import dtos.TraineeDto;

/**
 *
 * @author Admin
 */
public interface ITraineeService {
    void loadListTrainee();
    void editTrainee(TraineeDto trainee);
    void addTrainee(TraineeDto trainee);
}
