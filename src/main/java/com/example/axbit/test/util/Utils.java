package com.example.axbit.test.util;

import com.google.common.collect.Sets;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;

import static java.util.Objects.isNull;

public class Utils {
    public static void copyNonNullProperties(Object src, Object target, String... ignoredFields) {
        keepNullPropertyNames(src, target, ignoredFields);
    }

    private static void keepNullPropertyNames(Object source, Object target, String... ignoredFields) {
        final var src = new BeanWrapperImpl(source);
        var pds = src.getPropertyDescriptors();
        var emptyNames = Sets.newHashSet(ignoredFields);
        for (PropertyDescriptor pd : pds) {
            var srcValue = src.getPropertyValue(pd.getName());
            if (isNull(srcValue))
                emptyNames.add(pd.getName());
        }
        var result = new String[emptyNames.size()];
        BeanUtils.copyProperties(src, target, emptyNames.toArray(result));
    }
}