import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ProductRepositoryTest {
    ProductRepository Repository = new ProductRepository();

    Product Smartphone = new Smartphone(1, "Телефон 1", 100_000, "Айфон");
    Product Book = new Book(2, "Дорога", 600, "Есенин");
    Product Book2 = new Book(3, "Война и мир", 500, "Толстой");
    Product Smartphone2 = new Smartphone(4, "Телефон 2", 97_000, "Самсунг");

    @BeforeEach
    public void Product() {

        Repository.save(Smartphone);
        Repository.save(Book);
        Repository.save(Book2);
        Repository.save(Smartphone2);
    }
    @Test

    public void shouldSaveProduct() {

        Product[] actual = Repository.getItems();

        Product[] expected = {
                Smartphone,
                Book,
                Book2,
                Smartphone2
        };

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void shouldRemoveById() {


        Repository.removeById(1);

        Product[] actual = Repository.getItems();
        Product[] expected = {
                Book,
                Book2,
                Smartphone2
        };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByTwoId() {


        Repository.removeById(1);
        Repository.removeById(4);

        Product[] actual = Repository.getItems();
        Product[] expected = {
                Book,
                Book2,
        };


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllId() {


        Repository.removeById(1);
        Repository.removeById(4);
        Repository.removeById(2);
        Repository.removeById(3);


        Product[] actual = Repository.getItems();
        Product[] expected = {};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            Repository.removeById(22);
        });
    }
}










