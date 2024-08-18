package com.feanix.system.service;

import com.feanix.system.dto.request.RequestProductDTO;
import com.feanix.system.dto.response.ResponseProductDto;
import com.feanix.system.dto.response.paginate.ResponseProductPaginateDto;

public interface ProductService {
    public void create(RequestProductDTO dto);
    public void update(RequestProductDTO dto, String productId);
    public void updateStatus(String productId);
    public void delete(String productId);
    public ResponseProductDto findById(String productId);
    public ResponseProductPaginateDto findAll(String searchText, int page, int size);// searchText, page, size
}
