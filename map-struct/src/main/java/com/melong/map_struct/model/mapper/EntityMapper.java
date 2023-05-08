package com.melong.map_struct.model.mapper;

import java.util.List;

public interface EntityMapper <D, E> {

    E toEntity(D model);

    D toModel(E entity);

    List<D> toModelList(List<E> entityList);

    List<E> toEntityList(List<D> modelList);
}