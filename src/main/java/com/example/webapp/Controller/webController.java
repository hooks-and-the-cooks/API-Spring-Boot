package com.example.webapp.Controller;

import com.example.webapp.Dao.webDao;
import com.example.webapp.Model.webModel;
import com.example.webapp.Services.ControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/control")
public class webController {
    @Autowired
    public ControllerService controllerService;
    @GetMapping
    public List<webModel> display(){
        return this.controllerService.getAllValue();
    }
    @GetMapping("{id}")
    public webModel diplayNew(@PathVariable int id){
        return this.controllerService.getIdValue(id);
    }
    @PostMapping
    public webModel addModel(@RequestBody webModel Webmodel){
        return this.controllerService.addNewModel(Webmodel);
    }
    @PutMapping
    public String editModel(@RequestBody webModel WebModel){
        webModel wm = this.controllerService.updateExistModel(WebModel);
        if(wm == null){
            return "Not Found!";
        }else{
            return "The update was successful at id = " + WebModel.getId();
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deleteModel(@PathVariable int id){
        boolean del = this.controllerService.deleteExistModel(id);
        if(del)
            return "Successfully deleted id = " + id;
        else
            return "Not Found!";
    }
}
