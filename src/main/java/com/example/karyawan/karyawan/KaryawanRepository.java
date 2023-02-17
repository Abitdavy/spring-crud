package com.example.karyawan.karyawan;

import java.util.List;

public interface KaryawanRepository {
    int save(KaryawanModel book);

    int update(KaryawanModel book);

    KaryawanModel findById(int id);

    int deleteById(int id);

    List<KaryawanModel> findAll();

    List<KaryawanModel> searchKaryawan(String query);
    int deleteAll();

}
