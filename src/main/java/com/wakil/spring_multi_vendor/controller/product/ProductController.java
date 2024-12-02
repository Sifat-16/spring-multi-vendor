package com.wakil.spring_multi_vendor.controller.product;

import com.wakil.spring_multi_vendor.model.Product;
import com.wakil.spring_multi_vendor.requests.product.AddProductRequest;
import com.wakil.spring_multi_vendor.response.ApiResponse;
import com.wakil.spring_multi_vendor.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/product")
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;

    @GetMapping("/all-products")
    public ResponseEntity<ApiResponse> getAllProduct(){
        try {
            List<Product> all_products = productService.getAllProducts();
            return ResponseEntity.ok(new ApiResponse(
                    "all-product",
                    all_products
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("server-error", null));        }

    }


    @GetMapping("/product-by-name/{name}")
    public ResponseEntity<ApiResponse> getProductsByName(@PathVariable String name){
        try {
            List<Product> all_products = productService.getProductByName(name);
            return ResponseEntity.ok(new ApiResponse(
                    "product-by-name",
                    all_products
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("server-error", null));        }

    }

    @GetMapping("/product-by-id/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id){
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(new ApiResponse(
                    "product",
                    product
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("server-error", null));        }

    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody AddProductRequest addProductRequest){
        try {
            Product product = productService.createProduct(addProductRequest);
            return ResponseEntity.ok(new ApiResponse(
                    "new product",
                    product
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("server-error", e.getMessage()));        }

    }

    @GetMapping("/product-by-price/{price}")
    public  ResponseEntity<ApiResponse> getProductByPrice (@PathVariable String price){

        try{
            Product product = productService.getProductByPrice(price);
            return ResponseEntity.ok(new ApiResponse(
                    "product by price fetched",
                    product
            ));
        }catch (Exception e){

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Internal Server Error", null));

    }

}
