package com.javaquery.spring.repository;

import org.springframework.data.jpa.domain.Specification;

/**
 * @author javaquery
 * @since 2025-11-26
 */
public class CommonSpecification {

    public static <T> Specification<T> hasIdIn(Iterable<?> ids) {
        return (root, query, criteriaBuilder) -> root.get("id").in(ids);
    }
}
