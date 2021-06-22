import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestJsonFormat {


    public static void main(String[] args){
        TestJsonFormat testJsonFormat = new TestJsonFormat();
        testJsonFormat.stream();

    }


    private  String formatErrorMessage(Integer code, String msg) {
        Map<String, Object> errorMessage = new HashMap<>(1);
        errorMessage.put("code", code);
        errorMessage.put("msg", msg);
        return JSON.toJSONString(errorMessage);
    }

    @Getter
    @Setter
    class User{

        String name;
        int id;

        public User(String name,int id){
            this.name = name;
            this.id = id;
        }
    }

    public void stream() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("david", 1));
        userList.add(new User("jack", 2));
        userList.add(new User("amy", 3));
        userList.add(new User("frank", 4));
        List<User> fiterList = userList.stream().filter(user -> (2 < user.getId())).collect(Collectors.toList());
        fiterList.forEach(user -> {
            System.out.println(user.getName());
        });
    }
}
