import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PrzykladOptional {

    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    // Note that we used the isPresent() method to check if there is a value inside the Optional object. A value is present only if we have created Optional with a non-null value. We’ll look at the isPresent() method in the next section.
    //
    // We can also create an Optional object with the static method of():
    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "WSB";
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }

    // However, the argument passed to the of() method can’t be null. Otherwise, we’ll get a NullPointerException:
    @Test
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        assertThrows(NullPointerException.class, () -> Optional.of(name));
    }

    // But in case we expect some null values, we can use the ofNullable() method:
    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        String name = "WSB";
        Optional<String> opt = Optional.ofNullable(name);
        assertTrue(opt.isPresent());
    }

    @Test
    public void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected() {
        Optional<String> opt = Optional.of("WSB");
        assertFalse(opt.isEmpty());

        opt = Optional.ofNullable(null);
        assertTrue(opt.isEmpty());
    }

    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("WSB");
        opt.ifPresent(name -> System.out.println(name.length()));
    }

    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).
                orElse("Piotr");
        // or ElseGet(() -> "Piotr") || orElseThrow(IllegalArgumentException::new)
        assertEquals("Piotr", name);
    }

    @Test
    public void givenOptional_whenGetsValue_thenCorrect() {
        Optional<String> opt = Optional.of("WSB");
        String name = opt.get();
        assertEquals("WSB", name);
    }

    // Filter
    @Test
    public void whenOptionalFilterWorks_thenCorrect() {
        Integer year = 2024;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2024 = yearOptional.filter(y -> y == 2024).isPresent();
        assertTrue(is2024);
        boolean is2025 = yearOptional.filter(y -> y == 2025).isPresent();
        assertFalse(is2025);
    }

    // Why filter?

    @Test
    public void whenFiltersWithoutOptional_thenCorrect() {
        assertTrue(priceIsInRange1(new Modem(10.0)));
        assertFalse(priceIsInRange1(new Modem(9.9)));
        assertFalse(priceIsInRange1(new Modem(null)));
        assertFalse(priceIsInRange1(new Modem(15.5)));
        assertFalse(priceIsInRange1(null));
    }

    @Test
    public void whenFiltersWithOptional_thenCorrect() {
        assertTrue(priceIsInRange2(new Modem(10.0)));
        assertFalse(priceIsInRange2(new Modem(9.9)));
        assertFalse(priceIsInRange2(new Modem(null)));
        assertFalse(priceIsInRange2(new Modem(15.5)));
        assertFalse(priceIsInRange2(null));
    }

    private boolean priceIsInRange1(Modem modem) {
        boolean isInRange = false;

        if (modem != null && modem.getPrice() != null
                && (modem.getPrice() >= 10
                && modem.getPrice() <= 15)) {

            isInRange = true;
        }
        return isInRange;
    }

    private boolean priceIsInRange2(Modem modem) {

        return Optional.ofNullable(modem).map(m -> m.getPrice()).filter(p -> p >= 10.0).filter(p -> p <= 15.0).isPresent();
    }


    private class Modem {
        private Double price;

        public Modem(Double price) {
            this.price = price;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
}
