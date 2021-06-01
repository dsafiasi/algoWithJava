import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Test {

  public void extend() { }
  public void testF() {
    System.out.println("abstract");
    extend();
  }


  public static void main(String[] args) {
    // accessOrder = true, 类似于get的访问操作会改变node的顺序
    // accessOrder = false, 顺序只与插入顺序相关

    LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(
        16, 0.75f, false){
      @Override
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>3;
      }
    };

    linkedHashMap.put("1", "1");
    linkedHashMap.put("2", "2");
    linkedHashMap.put("3", "3");

    linkedHashMap.get("1");
    linkedHashMap.get("2");
    linkedHashMap.put("4", "4");
    for (Map.Entry entry : linkedHashMap.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }


  }
}
