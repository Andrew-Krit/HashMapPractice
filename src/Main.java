import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        var myHashMap = new MyCustomHashMap<String, String>();

        myHashMap.put("A","B");
        myHashMap.put("E","F");
        myHashMap.put("H","P");
        myHashMap.put("1","H");
        myHashMap.put("1","G");
        myHashMap.put("2","G");
        myHashMap.put("1","8");

        System.out.println(myHashMap);

        myHashMap.remove("1");
        System.out.println(myHashMap);

        System.out.println(myHashMap.get("E"));

        myHashMap.put("Z","V");
        System.out.println(myHashMap);
    }
}