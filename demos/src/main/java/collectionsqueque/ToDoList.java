package collectionsqueque;

import java.util.*;

public class ToDoList {

    /*Hozz létre egy ToDo osztályt két attribútummal:
      String description és boolean isUrgent!
     Írd felül az osztály toString() metódusát is!
     Majd hozz létre egy ToDoList osztályt,
     melynek legyen egy List<ToDo> todos attribútuma!
     Legyen az osztályban egy Deque<ToDo> getTodosInUrgencyOrder()
     nevű metódus, amely szétválogatja a tennivaló listát úgy,
     hogy a sürgős tennivalókat (ahol az isUrgent attribútum értéke true)
     a visszaadandó ArrayDeque elejére teszi, a nem sürgőseket
     pedig a végére! Az osztály main() metódusában hozz létre néhány
     ToDo-t, hívd meg a getTodosInUrgencyOrder() metódust
      és írd ki a konzolra a visszakapott értéket!
      Majd hívd meg a visszakapott ArrayDeque pop() metódusát
      és írd ki a konzolra, melyik elemet veszi ki először!*/

    private List<ToDo> toDos = new ArrayList<>();

    public ToDoList(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public Deque<ToDo> getTodosInUrgencyOrder(){
        Deque<ToDo> toDosInOrder = new ArrayDeque<>();
        for (ToDo toDo : toDos) {
            if(toDo.isUrgent()){
                toDosInOrder.addFirst(toDo);
            }else{
                toDosInOrder.addLast(toDo);
            }
        }
        return toDosInOrder;
    }

    public static void main(String[] args) {
        List<ToDo> toDos = new ArrayList<>(List.of(
                new ToDo("Hajat mosni", false),
                new ToDo("Bevásárolni", false),
                new ToDo("Ajándékot venni Anyának", true),
                new ToDo("Felhívni Evelint", true),
                new ToDo("Írni egy levelet az orvosnak", false),
                new ToDo("Beszélni Tamásékkal a műtétről", true)
        ));

        ToDoList toDoList = new ToDoList(toDos);

        Deque<ToDo> toDosInOrder = toDoList.getTodosInUrgencyOrder();
        int size = toDosInOrder.size();
        for (int i = 0; i < size; i++) {
            System.out.println(toDosInOrder.pop());
        }
    }
}
