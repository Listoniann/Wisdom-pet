package com.listonian.wisdompet.services;

import com.listonian.wisdompet.data.entities.ProductEntity;
import com.listonian.wisdompet.data.repositories.ProductRepository;
import com.listonian.wisdompet.web.errors.NotFoundException;
import com.listonian.wisdompet.web.models.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        Iterable<ProductEntity> productEntities = this.productRepository.findAll();
        List<Product> products = new ArrayList<>();
        productEntities.forEach(productEntity->{
            products.add(this.translateDbToWeb(productEntity));
        });
        return products;
    }

    public Product getProduct(long id){
        Optional<ProductEntity> optional = this.productRepository.findById(id);
        if(optional.isEmpty()){
            throw new NotFoundException("customer not found with id");
        }
        return this.translateDbToWeb(optional.get());
    }

    public Product createOrUpdate(Product product){
        ProductEntity entity = this.translateWebToDb((product));
        entity = this.productRepository.save(entity);
        return this.translateDbToWeb(entity);
    }

    public void deleteProduct(long id){
        this.productRepository.deleteById(id);
    }

    private ProductEntity translateWebToDb(Product product){
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getProductId());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setVendorId(product.getVendorId());
        return entity;
    }

    private Product translateDbToWeb(ProductEntity entity){
        return new Product(entity.getId(), entity.getName(), entity.getPrice(),
                entity.getVendorId());
    }
}
