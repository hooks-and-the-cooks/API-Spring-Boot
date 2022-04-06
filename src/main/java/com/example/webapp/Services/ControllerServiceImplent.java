package com.example.webapp.Services;

import com.example.webapp.Dao.webDao;
import com.example.webapp.Model.webModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ControllerServiceImplent implements ControllerService{
    @Autowired
    public webDao WebDao;
    @Override
    public List<webModel> getAllValue(){
        return this.WebDao.fetchAll();
    }
    @Override
    public webModel getIdValue(int id){
        return this.WebDao.fetchFromDatabaseOnId(id);
    }
    @Override
    public webModel addNewModel(webModel WebModel){
        this.WebDao.addToDatabase(WebModel);
        return this.WebDao.fetchFromDatabaseOnId(WebModel.getId());
    }
    @Override
    public String updateExistModel(webModel WebModel){
        this.WebDao.updateExistingInDatabase(WebModel);
        return "Updated Successfully";
    }

    @Override
    public String deleteExistModel(int id) {
        this.WebDao.deleteFromDatabase(id);
        return "Deletion was Successful!";
    }
}
