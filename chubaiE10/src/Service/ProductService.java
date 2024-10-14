package Service;

import Entity.Product;
import IGeneral.IGeneric;

import java.util.List;

public class ProductService implements IGeneric<Product> {
    private List<Product> products;
    public ProductService(){}
    public ProductService(List<Product> products){
        this.products = products;
    }
    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public List<Product> getByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public Product update(Product product) {
        return null;
    }
}
