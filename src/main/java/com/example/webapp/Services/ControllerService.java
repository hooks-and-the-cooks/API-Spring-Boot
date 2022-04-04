package com.example.webapp.Services;

import com.example.webapp.Model.webModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ControllerService {
    public List<webModel> getAllValue();
    public webModel getIdValue(int id);
    public webModel addNewModel(webModel WebModel);
    public webModel updateExistModel(webModel WebModel);
    public boolean deleteExistModel(int id);
}
