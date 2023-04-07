import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*         Задача
        1. Необходимо реализовать следующий метод:
        1. На вход получаем список названий книг
        2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
        3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
        4. Количество полок константное - 5 штук
        5. Вернуть книги распределенные по полкам
*/
public class Main {
    public static void main(String[] args) {
        List<String> books = new ArrayList<>();
        books.add("BookX");
        books.add("BookT");
        books.add("BookA");
        books.add("BookW");
        books.add("BookQ");
        books.add("BookO");
        books.add("BookP");
        books.add("BookK");
        books.add("BookC");
        books.add("BookC");

        List<List<String>> shelves = distributeBooksOnShelves(books);
        System.out.println(shelves);
    }

    public static List<List<String>> distributeBooksOnShelves(List<String> books) {
        Collections.sort(books);
        int numShelves = 5;
        int booksOnShelf = books.size() / numShelves;
        int remainsBook = books.size() % numShelves;
        List<List<String>> shelves = new ArrayList<>();
        int currentBook = 0;
        int shelfSize;
        for (int i = 0; i < numShelves; i++) {
            if (i < remainsBook) {
                shelfSize = booksOnShelf + 1;
            } else {
                shelfSize = booksOnShelf;
            }
            List<String> shelf = new ArrayList<>(books.subList(currentBook, currentBook + shelfSize));
            shelves.add(shelf);
            currentBook += shelfSize;
        }
        return shelves;
    }
}