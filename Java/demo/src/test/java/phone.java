import com.sky.Call;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class phone {
    @Test
public void test(){
    ArrayList<Call> callList = new ArrayList<>();
    // 张三 ↔ 王五
    callList.add(new Call("张三", "王五", new BigInteger("100")));
    callList.add(new Call("王五", "张三", new BigInteger("200")));

    // 张三 ↔ 李四
    callList.add(new Call("张三", "李四", new BigInteger("300")));
    callList.add(new Call("李四", "张三", new BigInteger("50")));

    // 李四 ↔ 王五
    callList.add(new Call("李四", "王五", new BigInteger("120")));
    callList.add(new Call("王五", "李四", new BigInteger("400")));

    HashMap<String,BigInteger> callMap = new HashMap<>();
    for (Call call : callList) {
        callMap.put(call.getCaller(),
                callMap.getOrDefault(call.getCaller(), BigInteger.ZERO).add(call.getCallTime()));
        callMap.put(call.getReceiver(),
                callMap.getOrDefault(call.getReceiver(), BigInteger.ZERO).add(call.getCallTime()));
    }
    System.out.println(callMap.size());
    System.out.println(callMap);

    if (callMap.isEmpty()) {
        System.out.println("没有通话记录");
    } else {
        Map.Entry<String, BigInteger> maxEntry =
                Collections.max(callMap.entrySet(),
                        (a, b) -> a.getValue().compareTo(b.getValue()));
        System.out.println("通话时长最多的人：" + maxEntry.getKey() + "，时长：" + maxEntry.getValue());
    }
}
}
