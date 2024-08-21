package com.feanix.system.api;

import com.feanix.system.dto.request.RequestProductDTO;
import com.feanix.system.service.ProductService;
import com.feanix.system.util.StandardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @PostMapping("/business/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponseDto> create(
            @RequestBody RequestProductDTO dto
    ) {
        productService.create(dto);
        return new ResponseEntity<>(
                new StandardResponseDto(201, "product saved", dto),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/business/update/{productId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponseDto> update(
            @RequestBody RequestProductDTO dto,
            @PathVariable String productId
    ) {
        productService.update(dto, productId);
        return new ResponseEntity<>(
                new StandardResponseDto(201, "product updated", dto),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/business/update-status/{productId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponseDto> updateStatus(
            @PathVariable String productId
    ) {
        productService.updateStatus(productId);
        return new ResponseEntity<>(
                new StandardResponseDto(201, "product Status updated", null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/business/delete/{productId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponseDto> delete(
            @PathVariable String productId
    ) {
        productService.delete(productId);
        return new ResponseEntity<>(
                new StandardResponseDto(204, "product Status delete", null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/user/find-by-id/{productId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<StandardResponseDto> findById(
            @PathVariable String productId
    ) {

        return new ResponseEntity<>(
                new StandardResponseDto(200, "product data",
                        productService.findById(productId)),
                HttpStatus.OK
        );
    }

    @GetMapping("/visitor/find-all")
    public ResponseEntity<StandardResponseDto> findById(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ) {

        return new ResponseEntity<>(
                new StandardResponseDto(200, "product data",
                        productService.findAll(searchText, page, size)),
                HttpStatus.OK
        );
    }

}
