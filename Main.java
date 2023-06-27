import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        JSONObject jsonObj = new JSONObject(json);

        StringBuilder whereClause = new StringBuilder("select * from students WHERE ");

        boolean firstParam = true;
        for (String key : jsonObj.keySet()) {
            String value = jsonObj.getString(key);

            if (!value.equals("null")) {
                if (!firstParam) {
                    whereClause.append(" AND ");
                } else {
                    firstParam = false;
                }

                whereClause.append(key + "=" + value);
            }
        }

        System.out.println(whereClause.toString());
    }
}