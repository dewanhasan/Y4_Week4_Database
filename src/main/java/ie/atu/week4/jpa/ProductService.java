package ie.atu.week4.jpa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> add(Product product)
    {
        productRepository.save(product);
        return productRepository.findAll();
    }

    public List<Product> deleteProduct(Long id){
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    public void updateProduct(Long id, Product product){
        Product updatedProduct = productRepository.getReferenceById(id);
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setProductDescription(product.getProductDescription());
        productRepository.save(updatedProduct);
    }


    /*
    public List<Product> updateProduct(Long id, Product product){
        Product updateproduct = productRepository.getReferenceById(id);
        updateproduct.setProductDescription(updateproduct.getProductDescription());
        updateproduct.setProductName(updateproduct.getProductName());
        return productRepository.findAll();

    }*/





}
