package com.javaquery.spring.data;

import java.util.List;

/**
 * @author javaquery
 * @since 2025-11-26
 */
public record PageData<T>(long totalElements, int totalPages, int currentPage, int pageSize, List<T> data) {
}
