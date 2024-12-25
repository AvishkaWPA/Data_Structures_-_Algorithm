package doubly;

import java.util.LinkedList;
import java.util.ListIterator;

public class TaskManager {

    public static void main(String[] args){
        LinkedList<String> tasks = new LinkedList<>();

        //initialized with initial tasks
        tasks.add("Check emails.");
        tasks.add("Attend a team meeting.");
        tasks.add("Complete project report.");

        //add new task at beginning
        tasks.addFirst("send email to HR department");

        //add task middle of list
        tasks.add(2,"Having dinner");

        //remove last task
        tasks.removeLast();

        //traverse forward
        System.out.println("Forward traverse");
        ListIterator<String> iterator = tasks.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+", ");
        }
        System.out.println(" ");
        //traverse backward
        System.out.println("Backward traverse");
        while(iterator.hasPrevious()){
            System.out.print(iterator.previous()+", ");
        }

    }
}
