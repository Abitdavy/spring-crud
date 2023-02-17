package com.example.karyawan.karyawan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcRepository implements KaryawanRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(KaryawanModel book) {
        return jdbcTemplate.update("INSERT INTO public.karyawan(id, nama, tanggal_masuk, no_handphone, limit_imbursement, created_at, updated_at) VALUES (DEFAULT, ?, ?, ?, ?, current_timestamp, NULL);",
                new Object[]  {
                book.getNama(), book.getTanggal_masuk(), book.getNo_handphone(), book.getLimit_imbursement()
                });
    }

    @Override
    public int update(KaryawanModel book) {
        return jdbcTemplate.update("UPDATE public.karyawan SET nama=?, tanggal_masuk=?, no_handphone=?, limit_imbursement=? WHERE id=?",
                new Object[] {
                        book.getNama(), book.getTanggal_masuk(), book.getNo_handphone(), book.getLimit_imbursement(), book.getId()
                });
    }

    @Override
    public KaryawanModel findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM karyawan WHERE id=?", new BeanPropertyRowMapper<KaryawanModel>(KaryawanModel.class), id);
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM karyawan WHERE id=?", id);
    }

    @Override
    public List<KaryawanModel> findAll() {
        List<KaryawanModel> karyawanModelList = jdbcTemplate.query("SELECT * FROM karyawan", new BeanPropertyRowMapper<KaryawanModel>(
                KaryawanModel.class
        ));
        return karyawanModelList;
    }

    @Override
    public List<KaryawanModel> searchKaryawan(String query) {
        String sql = "SELECT * FROM public.karyawan WHERE nama LIKE '%?%'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<KaryawanModel>(KaryawanModel.class), query);
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
