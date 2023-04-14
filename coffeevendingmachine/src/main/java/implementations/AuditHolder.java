package implementations;

import enums.CoffeeType;

import java.util.HashMap;
import java.util.Map;

public class AuditHolder {
    public static Map<CoffeeType, AuditInfo> coffeeTypeAuditInfoMap = new HashMap<>();

    static void auditInfo(CoffeeType type, float water, float milk, float beans, float price) {
        if(coffeeTypeAuditInfoMap.containsKey(type)) {
            AuditInfo auditInfo = coffeeTypeAuditInfoMap.get(type);
            auditInfo.totalPrice+=price;
            auditInfo.waterConsumed+=water;
            auditInfo.beansConsumed+=beans;
            auditInfo.milkConsumed+=milk;
        } else {
            coffeeTypeAuditInfoMap.put(type, new AuditInfo(price, milk, water, beans));
        }
    }
}
