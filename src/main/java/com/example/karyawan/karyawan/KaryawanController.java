package com.example.karyawan.karyawan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KaryawanController {

    //RestAPI
    @Autowired
    private KaryawanRepository karyawanRepository;

    //Controller
    @GetMapping("/users")
    public String getKaryawan(Model model){
        List<KaryawanModel> karyawanModelList = karyawanRepository.findAll();
        model.addAttribute("karyawan", karyawanModelList);
        System.out.println("Main Controller");
        return "users";
    }

    @GetMapping("/users/search")
    public String searchKaryawan(@RequestParam("query") String query, Model model){
        List<KaryawanModel> searchKaryawan = karyawanRepository.searchKaryawan(query);
        model.addAttribute("karyawan", searchKaryawan);
        model.addAttribute("query", query);
        return "users";
    }

    @GetMapping("/users/add")
    public String showNewForm(Model model){
        model.addAttribute("karyawan", new KaryawanModel());
        return "user_form";
    }

    @PostMapping("/users")
    public String createKaryawanController(@ModelAttribute("karyawan") KaryawanModel karyawanModel){
        karyawanRepository.save(karyawanModel);
        return "redirect:/users";
    }

    @GetMapping("users/edit/{id}")
    public String EditKaryawanForm(Model model,@PathVariable int id){
        model.addAttribute("karyawan", karyawanRepository.findById(id));
        return "user_edit";
    }

    @PostMapping("/users/{id}")
    public String EditKaryawanController(@ModelAttribute("karyawan") KaryawanModel karyawanModel, @PathVariable int id){
        KaryawanModel existingKaryawan = karyawanRepository.findById(id);
        existingKaryawan.setId(id);
        existingKaryawan.setNama(karyawanModel.getNama());
        existingKaryawan.setTanggal_masuk(karyawanModel.getTanggal_masuk());
        existingKaryawan.setNo_handphone(karyawanModel.getNo_handphone());
        existingKaryawan.setLimit_imbursement(karyawanModel.getLimit_imbursement());

        karyawanRepository.update(existingKaryawan);
        return "redirect:/users";
    }

    @GetMapping ("/users/{id}")
    public String deleteKaryawanController(@PathVariable int id){
        karyawanRepository.deleteById(id);
        return "redirect:/users";
    }
}
