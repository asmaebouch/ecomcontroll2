package com.example.gestionticket3.Service;

import com.example.gestionticket3.Dao.IDao;
import com.example.gestionticket3.Entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService {
    private IDao dao;

    @Override
    public List<Article> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(Article article) {
        dao.save(article);

    }



    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Article findById(Long id) {
        return dao.findById(id);
    }
    @Autowired
    @Qualifier("dao1")
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
