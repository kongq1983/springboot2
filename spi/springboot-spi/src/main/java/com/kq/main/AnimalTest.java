package com.kq.main;

import com.kq.Animal;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * AnimalTest
 *
 * @author kq
 * @date 2021/8/19 0:18
 * @since 1.0.0
 */
public class AnimalTest {

    public static void main(String[] args) {
        List<Animal> animals = SpringFactoriesLoader.loadFactories(Animal.class,null);

        for(Animal animal : animals) {
            animal.cry();
        }

    }

}
