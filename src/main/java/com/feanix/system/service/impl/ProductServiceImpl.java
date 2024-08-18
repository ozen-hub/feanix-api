package com.feanix.system.service.impl;

import com.feanix.system.dto.request.RequestProductDTO;
import com.feanix.system.dto.response.ResponseProductDto;
import com.feanix.system.dto.response.paginate.ResponseProductPaginateDto;
import com.feanix.system.entity.Product;
import com.feanix.system.exception.EntryNotFoundException;
import com.feanix.system.repository.ProductRepo;
import com.feanix.system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public void create(RequestProductDTO dto) {
        Product product = toProduct(dto);
        productRepo.save(product);
    }

    @Override
    public void update(RequestProductDTO dto, String productId) {
        Optional<Product> selectedProductData = productRepo.findById(productId);
        if (selectedProductData.isEmpty()) {
            throw new EntryNotFoundException("Product not found");
        }
        Product product = selectedProductData.get();
        product.setProductName(dto.getProductName());
        product.setQtyOnHand(dto.getQtyOnHand());
        product.setUnitPrice(dto.getUnitPrice());
        productRepo.save(product);
    }

    @Override
    public void updateStatus(String productId) {
        Optional<Product> selectedProductData = productRepo.findById(productId);
        if (selectedProductData.isEmpty()) {
            throw new EntryNotFoundException("Product not found");
        }

        Product product = selectedProductData.get();
        product.setStatus(!product.isStatus());
        productRepo.save(product);
    }

    @Override
    public void delete(String productId) {
        Optional<Product> selectedProductData = productRepo.findById(productId);
        if (selectedProductData.isEmpty()) {
            throw new EntryNotFoundException("Product not found");
        }
        productRepo.deleteById(productId);
    }

    @Override
    public ResponseProductDto findById(String productId) {
        Optional<Product> selectedProductData = productRepo.findById(productId);
        if (selectedProductData.isEmpty()) {
            throw new EntryNotFoundException("Product not found");
        }
        return toResponseProductDTO(selectedProductData.get());
    }

    @Override
    public ResponseProductPaginateDto findAll(String searchText, int page, int size) {
        return ResponseProductPaginateDto.builder()
                .count(productRepo.countAll(searchText))
                .dataList(
                        productRepo.findAll(searchText, PageRequest.of(page,size))
                                .stream().map(this::toResponseProductDTO).toList()
                )
                .build();
    }

    private Product toProduct(RequestProductDTO dto) {
        if (dto == null) {
            return null;
        }
        return Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName(dto.getProductName())
                .unitPrice(dto.getUnitPrice())
                .fileResource(null)
                .qtyOnHand(dto.getQtyOnHand())
                .status(true)
                .build();
    }

    private ResponseProductDto toResponseProductDTO(Product product) {
        if (product == null) {
            return null;
        }
        return ResponseProductDto.builder()
                .productName(product.getProductName())
                .productId(product.getProductId())
                .unitPrice(product.getUnitPrice())
                .qtyOnHand(product.getQtyOnHand())
                .status(product.isStatus())
                .build();
    }

}
