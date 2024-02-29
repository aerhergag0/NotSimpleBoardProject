package com.rmrdo.notsimpleboardproject.common.mapper;

import java.util.List;

public interface GenericMapper<D, E> {

	D toDto(E entity);

	E toEntity(D dto);

	List<D> toDtoList(List<E> list);

	List<E> toEntityList(List<D> list);
}
