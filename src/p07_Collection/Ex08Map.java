package p07_Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex08Map {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap(); // ----(1)
    map.put("admin", "1");
    map.put("user", "1");
    if (map.containsKey("member") == false) map.put("member", "1");
    //위와 아래의 내용이 같다. 위에는 false를 붙였고 밑에는 !를 붙였다.
    if (!map.containsKey("member")) map.put("member", "2");
    //if문 에서는 조건이 맞아야지 if문내에 내용이 실행된다, 그게 아니라면 없는거나 다름없다
    map.put("member", "3"); //키가 중복될때 맨앞에 들어온값에 맨뒤에 들어온값이 덮어 쓰게된다. overwrite
    System.out.println(map);
    map.remove("admin");
    System.out.println(map);

    // 1) key 와 value를 동시에 접근
    Iterator it = map.entrySet().iterator();//map으로부터 iterator 을 만들어낸다
    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry) it.next();
      System.out.printf("k: %s/ v : %s \n",
          entry.getKey(),
          entry.getValue());
    }
    // 2) key 로 접근
    it = map.keySet().iterator();
    while (it.hasNext()) {
      String key = (String) it.next();
      String value = map.get(key); //error 가 났을때 위에서 (1) 에 <String String>을 적어준다.
      System.out.printf("k: %s/ v : %s \n",key,value);

    }
    // 3) value 접근
    it = map.values().iterator();
    while (it.hasNext()) {
      String value = (String) it.next();
      System.out.printf(value);

    }
   }
}

