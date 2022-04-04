package com.example.webapp.Services;

import com.example.webapp.Model.webModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Component
public class ControllerServiceImplent implements ControllerService{
    List<webModel> web;
    public ControllerServiceImplent(){
        web = new ArrayList<>();
        web.add(new webModel(1, "Anshuman","anshumandixit7@gmail.com"));
        web.add(new webModel(2, "Satyam", "satyamguptagkp@gmail.com"));
        web.add(new webModel(3, "nimit", "nimitshreshtha09@gmail.com"));
    }
    @Override
    public List<webModel> getAllValue(){
        return web;
    }
    @Override
    public webModel getIdValue(int id){
        for(webModel W : web){
            if(W.getId() == id)
                return W;
        }
        return null;
    }
    @Override
    public webModel addNewModel(webModel WebModel){
        web.add(WebModel);
        return WebModel;
    }
    @Override
    public webModel updateExistModel(webModel WebModel){
        for (webModel W: web){
            if(W.getId() == WebModel.getId()){
                W.setName(WebModel.getName());
                W.setEmail(WebModel.getEmail());
                return WebModel;
            }
        }
        return null;
    }

    @Override
    public boolean deleteExistModel(int id) {
        for (webModel W : web){
            if(W.getId() == id){
                web.remove(W);
                return true;
            }
        }
        return false;
    }
}
