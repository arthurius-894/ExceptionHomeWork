package ru.netology.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldDeleteAnExistingElement() {
        Product product1 = new Product(1, "телефон", 75000);
        Product product2 = new Product(2, "наушники", 25000);
        Product product3 = new Product(3, "блок питания", 2500);

        ShopRepository repository = new ShopRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        repository.remove(2);

        Product[] expected = {product1, product3};
        Product[] actual = repository.findAll();
    }

    @Test
    public void shouldDeleteNonExistentElement() {
        Product product1 = new Product(1, "телефон", 75000);
        Product product2 = new Product(2, "наушники", 25000);
        Product product3 = new Product(3, "блок питания", 2500);

        ShopRepository repository = new ShopRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {repository.remove(-100);});
    }
}
