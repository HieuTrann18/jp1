import Controller.ProductController;
import Entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ExceptionValidations.InvalidProductIdException;
import ExceptionValidations.InvalidProductNameException;
import ExceptionValidations.InvalidQuantityException;
import Service.ProductService;


public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        ProductService productService = new ProductService(products);
        ProductController productController = new ProductController(productService);

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit){
            try{
                Product product = new Product();
                System.out.println(products.size());

                System.out.println("Enter product code: ");
                String pCode = scanner.nextLine();
                product.setId(products.size() + 1);
                product.setCode(pCode);

                System.out.println("Enter product name: ");
                String pName = scanner.nextLine();
                product.setName(pName);

                System.out.println("Enter product quantity: ");
                int pQuantity = scanner.nextInt();
                scanner.nextLine();
                product.setQuantity(pQuantity);


                productController.add(product);

                quit = true;
            }catch(InvalidProductIdException e){
                System.out.println(e.getMessage());
            }catch(InvalidProductNameException e){
                System.out.println(e.getMessage());
            }catch(InvalidQuantityException e){
                System.out.println(e.getMessage());
            }finally{
                System.out.println("Product valid");
            }
        }

    }
}