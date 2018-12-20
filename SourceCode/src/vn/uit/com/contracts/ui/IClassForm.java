/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.ui;

import dtos.ClassDto;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IClassForm extends IChildPanel{
    void displayListClass(ArrayList<ClassDto> list);
}
