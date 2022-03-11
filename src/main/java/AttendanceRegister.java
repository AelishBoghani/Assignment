import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AttendanceRegister {

    public static void main(String[] args) throws IOException, ParseException {

        //TestCase 1
        getDetailsOfEmployee("Test1");

        //TestCase 2
        getDetailsOfEmployee("Test2");

        //TestCase 3
        getDetailsOfEmployee("Test3");

        //TestCase 4
        getDetailsOfEmployee("Test4");

        //TestCase 5
        getDetailsOfEmployee("Test5");

        //TestCase 6
        getDetailsOfEmployee("Test6");
    }

    private static void getDetailsOfEmployee(String name) throws IOException, ParseException {
        Object obj = getObjectFromJson();
        JSONArray employeeList = (JSONArray) obj;

        for (Object employeeData : employeeList) {
            if (getNameFromObject(employeeData).equals(name)) {
                JSONObject EmpData = (JSONObject) employeeData;
                System.out.println("Person Name : " + EmpData.get("employeName"));
                System.out.println("Date : " + EmpData.get("date"));
                System.out.println("CheckIn Time : " + EmpData.get("checkinTime"));
                System.out.println("CheckOut Time : " + EmpData.get("checkouttime"));
                System.out.println("Department : " + EmpData.get("dept"));
                System.out.println("Working Hours Per Day : " + "1 Hour");
                System.out.println();
            }
        }
    }

    private static String getNameFromObject(Object obj) {
        JSONObject object = (JSONObject) obj;
        return (String) object.get("employeName");
    }

    private static Object getObjectFromJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        try {
            ClassLoader classLoader = AttendanceRegister.class.getClassLoader();
            FileReader fileReader = new FileReader(
                Objects.requireNonNull(classLoader.getResource("AttendanceRegister.json")).getFile());
            Object obj = jsonParser.parse(fileReader);

            return (JSONArray) obj;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
