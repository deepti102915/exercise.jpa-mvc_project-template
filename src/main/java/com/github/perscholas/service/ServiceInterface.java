package com.github.perscholas.service;

import com.github.perscholas.dao.RepositoryInterface;
import com.github.perscholas.model.EntityInterface;

import java.io.Serializable;

/**
 * Created by leon on 8/14/2020.
 */
public interface ServiceInterface<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>,
        RepositoryType extends RepositoryInterface<IdType, EntityType>> {
    RepositoryType getRepository();
}
