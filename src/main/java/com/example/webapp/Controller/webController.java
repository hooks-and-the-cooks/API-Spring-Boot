package com.example.webapp.Controller;

import com.example.webapp.Dao.webDao;
import com.example.webapp.Model.webModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/control")
public class webController {
    webDao wd;
    @Autowired
    public webController(webDao w){
        this.wd = w;
    }
    @GetMapping
    public List<webModel> display(){
        return wd.findall();
    }
    @GetMapping("{id}")
    public webModel diplayNew(@PathVariable int id){
        return wd.findSpecific(id);
    }
}
