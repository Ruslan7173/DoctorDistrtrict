package com.example.DoctorDistrtrict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControllerDoctor {
    @Autowired
    DoctorService doctorService;

    public ControllerDoctor() {
        System.out.println("Создали контроллер");
    }

    @GetMapping("/")
    public String getAllDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getDoctors());
        return "index";

    }

    @GetMapping("/doctor/{id}")
    public String getDoctorID(@PathVariable int id, Model model) {
        Doctor doctor = doctorService.getDoctorID(id);
        if (doctor != null) {
            model.addAttribute("doctor", doctor);
            return "doctor";
        }
        return "redirect";

        }
    @GetMapping("/doctInfo")
    public String getOneDoctor( String id, Model model) {
        try {
            int i = Integer.parseInt(id);
            Doctor doctor = doctorService.getDoctorID(i);
            if (doctor != null) {
                model.addAttribute("doctor", doctor);
                return "doctor";                                                   // название HTML-шаблона для деталей товара
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";  // если не найден, вернуться на главную
    }
    @GetMapping("/deleteDoct")
    public String deleteDoctor( String id, Model model) {
        try {
            int i = Integer.parseInt(id);
            doctorService.removeID(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";


    }



}

