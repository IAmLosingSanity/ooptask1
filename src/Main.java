public class Main {
    public static void main(String[] args) {
        myHashSet<String> names = new myHashSet<>();

        // Добавление элементов в myHashSet
        names.add("John");
        names.add("Jane");
        names.add("Alice");
        names.add("Bob");

        // Проверка наличия элемента в myHashSet
        System.out.println(names.contains("John"));  // true
        System.out.println(names.contains("Mary"));  // false

        // Удаление элемента из myHashSet
        names.remove("Alice");

        // Итерация по элементам myHashSet
        for (String name : names) {
            System.out.println(name);
        }

        // Очистка myHashSet
        names.clear();
        System.out.println(names.isEmpty());  // true

        System.out.println("==============================");

        myHashMultiSet<String> set = new myHashMultiSet<>();
        myHashMultiSet<String> set2 = new myHashMultiSet<>();

        // Добавление элементов в мультимножество
        set.add("apple");
        set.add("banana");
        set.add("apple");
        set.add("orange");
        set.add("banana");

        set2.add("orange");
        set2.add("banana");

        // Печать элементов мультимножества
        for (String element : set) {
            System.out.println(element);
        }

        // Удаление одного экземпляра элемента
        set.remove("apple");

        // Печать элементов после удаления
        for (String element : set) {
            System.out.println(element);
        }
    }
}
