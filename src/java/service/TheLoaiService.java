package service;

import dao.TheLoaiDao;
import java.util.List;
import model.TheLoai;

public class TheLoaiService {

    TheLoaiDao theLoaiDao = null;

    public TheLoaiService() {
        theLoaiDao = new TheLoaiDao();
    }

    public List<TheLoai> getAllTheLoai() {
        return theLoaiDao.getAllTheLoai();
    }
}
