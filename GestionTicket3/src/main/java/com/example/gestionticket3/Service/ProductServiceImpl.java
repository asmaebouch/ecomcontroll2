package com.example.gestionticket3.Service;

import com.example.gestionticket3.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class ProductServiceImpl implements IProductService {
    private static List<Product> productRpo=new ArrayList<>();
    static {
        productRpo.add(new Product(1l,"Pc Portable hp"));
        productRpo.add(new Product(2l,"Pc Portable hp2"));

        productRpo.add(new Product(3l,"Pc Portable hp3"));

        productRpo.add(new Product(4l,"Pc Portable h4"));

        productRpo.add(new Product(5l,"Pc Portable hp5"));

    }
    @Override
    public Product getById(Long id) {
        if(productRpo==null || productRpo.isEmpty())
            return null;
        for(Product product : productRpo){
            if(id.equals(product.getId()))
                return  product;
        }
        return null;
    }


    @Override
    public List<Product> getAll() {
        return productRpo;
    }

    @Override
    public void create(Product product) {

    }


    @Override
    public void update(Long id, Product product) {
        Product productFound = getById(id);
        if (productFound == null)
            return;
        productRpo.remove(productFound);
        product.setId(id);
        productRpo.add(product);
    }
    @Override
    public void delete(Long id) {
        Product productFound = getById(id);
        if (productFound == null)
            return;
        productRpo.remove(productFound);
    }
}
