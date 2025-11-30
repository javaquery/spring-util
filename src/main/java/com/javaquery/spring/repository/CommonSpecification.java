package com.javaquery.spring.repository;

import org.springframework.data.jpa.domain.Specification;

/**
 * @author javaquery
 * @since 1.0.0
 */
public class CommonSpecification {

    /**
     * Creates a specification for checking equality of a field to a given value.
     *
     * @param field the field name
     * @param value the value to compare
     * @param <T>   the entity type
     * @return the specification
     */
    public static <T> Specification<T> equal(String field, Object value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(field), value);
    }

    /**
     * Creates a specification for checking inequality of a field to a given value.
     *
     * @param field the field name
     * @param value the value to compare
     * @param <T>   the entity type
     * @return the specification
     */
    public static <T> Specification<T> notEqual(String field, Object value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.notEqual(root.get(field), value);
    }

    /**
     * Creates a specification for checking if a field's value is in a given collection of values.
     *
     * @param field the field name
     * @param ids   the collection of values
     * @param <T>   the entity type
     * @return the specification
     */
    public static <T> Specification<T> in(String field, Iterable<?> ids) {
        return (root, query, criteriaBuilder) -> root.get(field).in(ids);
    }

    /**
     * Creates a specification for checking if a field's value is not in a given collection of values.
     *
     * @param field the field name
     * @param ids   the collection of values
     * @param <T>   the entity type
     * @return the specification
     */
    public static <T> Specification<T> notIn(String field, Iterable<?> ids) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.not(root.get(field).in(ids));
    }

    /**
     * Creates a specification for checking if a field's value matches a given pattern using LIKE.
     *
     * @param field   the field name
     * @param pattern the pattern to match
     * @param <T>     the entity type
     * @return the specification
     */
    public static <T> Specification<T> like(String field, String pattern) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(field), pattern);
    }

    /**
     * Creates a specification for checking if a field's value starts with a given prefix.
     *
     * @param field  the field name
     * @param prefix the prefix to match
     * @param <T>    the entity type
     * @return the specification
     */
    public static <T> Specification<T> startsWith(String field, String prefix) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(field), prefix + "%");
    }

    /**
     * Creates a specification for checking if a field's value ends with a given suffix.
     *
     * @param field  the field name
     * @param suffix the suffix to match
     * @param <T>    the entity type
     * @return the specification
     */
    public static <T> Specification<T> endsWith(String field, String suffix) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(field), "%" + suffix);
    }

    /**
     * Creates a specification for checking if a field's value contains a given infix.
     *
     * @param field the field name
     * @param infix the infix to match
     * @param <T>   the entity type
     * @return the specification
     */
    public static <T> Specification<T> contains(String field, String infix) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(field), "%" + infix + "%");
    }
}
