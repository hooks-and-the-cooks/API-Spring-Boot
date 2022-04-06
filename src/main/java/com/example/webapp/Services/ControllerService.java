package com.example.webapp.Services;

import com.example.webapp.Model.webModel;

import java.util.List;

public interface ControllerService {
    public List<webModel> getAllValue();
    public webModel getIdValue(int id);
    public webModel addNewModel(webModel WebModel);
    public String updateExistModel(webModel WebModel);
    public String deleteExistModel(int id);
}
