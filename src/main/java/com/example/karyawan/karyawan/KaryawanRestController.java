package com.example.karyawan.karyawan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KaryawanRestController {
    @Autowired
    private KaryawanRepository karyawanRepository;

    @GetMapping("api/users")
    public List<KaryawanModel> getKaryawan(){
        return karyawanRepository.findAll();
    }
    @GetMapping("api/users/{id}")
    public KaryawanModel getKaryawanById(@PathVariable int id){
        return karyawanRepository.findById(id);
    }

    @PostMapping("api/users/add_users")
    public ResponseEntity<String> createKaryawan(@RequestBody KaryawanModel karyawanModel) {
        try {
            karyawanRepository.save(karyawanModel);
            return new ResponseEntity<>("List Karyawan Created", HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("api/users/{id}")
    public ResponseEntity<String> updateKaryawan(@RequestBody KaryawanModel karyawanModel, @PathVariable int id){
        try{
            KaryawanModel _karyawan =  karyawanRepository.findById(id);
            if(_karyawan!=null){
                _karyawan.setId(id);
                _karyawan.setNama(karyawanModel.getNama());
                _karyawan.setTanggal_masuk(karyawanModel.getTanggal_masuk());
                _karyawan.setNo_handphone(karyawanModel.getNo_handphone());
                _karyawan.setUpdatedOn(karyawanModel.getUpdatedOn());
            }
            karyawanRepository.update(_karyawan);
            return new ResponseEntity<>("Karyawan Updated Successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Cannot find id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("api/users/{id}")
    public ResponseEntity<String> deleteKaryawan(@PathVariable int id){
        try {
            karyawanRepository.deleteById(id);
            return new ResponseEntity<>("karyawan deleted!", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("delete error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
