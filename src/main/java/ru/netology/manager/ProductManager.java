package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    public ProductRepository repository;

    public ProductManager() {

    }
public void remById(int id){
        repository.removeById(id);
}
    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void AddPoduct(Product product) {
        repository.save(product);
    }

    public Product[] searcyBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


}
