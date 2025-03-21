public class LinkedStack {
    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) { // если в стеке уже есть элементы
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++; // увеличиваем счётчик элементов
    }

    public int pop() {
        int deletedValue = 0;
        if (getSize() != 0) {
            deletedValue = tail.getValue();
            tail = tail.getPrev();
            size--;
        }
        return deletedValue;
    }
    // ваш код
    // возьмите value из последнего узла
    // назначьте предыдущий к последнему узлу последним узлом

    public int getSize() {
        return size;
        // ваш код
        // верните размер стека
    }

    public boolean isEmpty() {
        return getSize() == 0;
        // ваш код
        // верните ответ на вопрос, не пустой ли стек
    }

    public String toString() {
        if (isEmpty()) {
            return "EMPTY";
        }
        Node current = tail;
        StringBuilder result = new StringBuilder();
        while (current != null) {
            if (current.getPrev() == null) {
                result.append(current.getValue());
                break;
            }
            result.append(current.getValue()).append(" -> ");
            current = current.getPrev();
        }
        return result.toString();
    }
}
// если есть элементы, пройдитесь по связному списку,
// выводя элементы.
// вывод должен быть в точности как в комментариях к main
// при этом этот метод не должен менять стек!