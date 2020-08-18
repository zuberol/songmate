package pl.jzuber.songmate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping({"other", "someOther", "some"})         //TODO delete this random site
    public String index(Model model){ return "somePage"; }

    @RequestMapping("**")   //default route
    public String defaultMapping(Model model){
        return "index";
    }

}
