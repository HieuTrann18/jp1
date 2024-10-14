package Controller;

import Entity.Product;
import Service.ProductService;
import Validation.Validation;
import ExceptionValidations.InvalidProductIdException;
import ExceptionValidations.InvalidProductNameException;
import ExceptionValidations.InvalidQuantityException;

public class ProductController {
    private ProductService ps;
    public ProductController(){}
    public ProductController(ProductService ps){
        this.ps = ps;
    }

    public void add(Product product){
        if(Validation.isProductCode(product.getCode())){
            ps.add(product);
        }else{
            throw new InvalidProductIdException("Product code is not valid");
        }

        if(Validation.isProductName(product.getName())){
            ps.add(product);
        }else{
            throw new InvalidProductNameException("Product name is not valid");
        }

        if(Validation.isNumberInteger(String.valueOf(product.getQuantity()))){
            ps.add(product);
        }else{
            throw new InvalidQuantityException("Product quantity is not valid");
        }

    }
}
