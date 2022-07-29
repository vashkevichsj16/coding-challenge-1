package com.test.challenge.mapper;

import com.test.challenge.dto.FilterDto;
import com.test.challenge.filter.Filter;
import org.mapstruct.Mapper;

@Mapper
public interface FilterDtoMapper {
    Filter toDto(FilterDto source);

    Filter toEntity(FilterDto destination);
}
