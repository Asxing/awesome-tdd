package com.holddie.order;

import java.util.Comparator;

import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;

public class ParameterCountOrder implements MethodOrderer {

    private Comparator<MethodDescriptor> comparator =
            Comparator.comparingInt(md1 -> md1.getMethod().getParameterCount());

    @Override
    public void orderMethods(MethodOrdererContext context) {

        context.getMethodDescriptors().sort(comparator.reversed());
        //context.getMethodDescriptors().sort(comparator);
    }

}
