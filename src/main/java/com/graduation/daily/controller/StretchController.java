package com.graduation.daily.controller;

import com.graduation.daily.model.Stretch;
import com.graduation.daily.repository.StretchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/stretch")
public class StretchController {

    @Autowired
    private StretchRepository stretchRepository;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(required = false, defaultValue = "") String searchText) {
        List<Stretch> stretches;
        //if (searchText.equals("")) {
            stretches = stretchRepository.findAll();
//        } else {
//            stretches = stretchRepository.findBySearch(searchText);
//        }
        for (Stretch stretch : stretches) {
            String url = stretch.getUrl();
            url = url.split("v=")[1];
            String imgSrc = "https://img.youtube.com/vi/" + url + "/0.jpg";
            stretch.setImgSrc(imgSrc);
        }
        model.addAttribute("stretches", stretches);

        return "stretch/index";
    }
}
