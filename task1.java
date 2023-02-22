// Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.
import java.util.Arrays;
import java.util.LinkedList;

public class task1 {
    
    public static LinkedList<String> Reversal(LinkedList<String> list){
        LinkedList<String> newlist = new LinkedList<>();
        for (int i=(list.size()-1);i>=0;i--) {
            newlist.add(list.get(i));
        }
        return  newlist;
    }    
    public static void main(String[] args) {
        String[] arr = new String[]{"Привет", "винегрет", "пока", "еда","вода"}; 
        LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
        System.out.println(list);
        LinkedList<String> reversalist=Reversal(list);
        System.out.println(reversalist);  

    }    
}


