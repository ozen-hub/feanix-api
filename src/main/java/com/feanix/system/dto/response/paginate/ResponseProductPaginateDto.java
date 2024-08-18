package com.feanix.system.dto.response.paginate;

import com.feanix.system.dto.response.ResponseProductDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProductPaginateDto {
    private long count;
    private List<ResponseProductDto> dataList;
}
