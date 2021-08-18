package com.kq.main;

import com.kq.Animal;

import java.util.ServiceLoader;

/**
 * AnimalTest
 *
 * @author kq
 * @date 2021/8/19 0:10
 * @since 1.0.0
 */
public class AnimalTest {

    public static void main(String[] args) {
        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);

        for(Animal animal : animals) {
            animal.cry();
        }

    }

}
