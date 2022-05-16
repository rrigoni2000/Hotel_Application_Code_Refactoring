package it.unibz.test;

import it.unibz.src.customer.Customer;
import it.unibz.src.customer.Gender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void reflexiveEqualityTest() {
        Customer _1 = new Customer("Riccardo", "r.r@gmail.com", Gender.Male);
        assertEquals(_1,_1);
    }

    @Test
    public void customersNotEqualTest() {
        Customer _1 = new Customer("Riccardo", "r.r@gmail.com", Gender.Male);
        Customer _2 = new Customer("Andrea", "a@hotmail.com", Gender.Female);

        assertNotEquals(_1, _2);
    }

    @Test
    public void customersEqualTest() {
        Customer _1 = new Customer("Riccardo", "r.r@gmail.com", Gender.Male);
        Customer _2 = new Customer("Riccardo", "a@hotmail.com", Gender.Female);
        Customer _3 = new Customer("Riccardo", "a@hotmail.com", Gender.Male);

        assertNotEquals(_1, _2);
        assertEquals(_1, _3);
    }
}
