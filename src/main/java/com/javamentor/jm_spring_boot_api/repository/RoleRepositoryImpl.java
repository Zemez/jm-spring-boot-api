package com.javamentor.jm_spring_boot_api.repository;

import com.javamentor.jm_spring_boot_api.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository("roleRepository")
public class RoleRepositoryImpl extends AbstractRepository<Role> implements RoleRepository {

    private final EntityManager entityManager;

    public RoleRepositoryImpl(EntityManager entityManager) {
        super(Role.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Role findByName(String name) {
        //noinspection JpaQlInspection
        TypedQuery<Role> query = entityManager.createQuery("from Role where name = :name", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

}
