import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test3 {
    public static void main(String[] args) {
        String info =  "10001,张无忌,男,2023-07-22 11:11:12,东湖-黄鹤楼#10002,赵敏,女,2023-07-22 09:11:21,黄鹤楼-归元禅寺#10003,周芷若,女,2023-07-22 04:11:21,木兰文化区-东湖#1004,小昭,女,2023-07-22 08:11:21,东湖#10005,灭绝,女,2023-07-22 17:11:21,归元禅寺";
        //        情報をList<Student>オブジェクトに変換
        List<Student> students = parseStudents(info);
        System.out.println(students);

        //        上記で取得したデータコレクションを走査し、各観光地の選択回数を統計し、観光地名と選択回数を出力
        Map<String, Integer> map = parseSelectAddresssCount(students);

        //        プログラムで最も行きたい観光地を計算し、この最多人数が行きたい観光地を選ばなかった人を特定
        String  maxSelectAddress = getMaxSelectAddress(map);
        System.out.println("最多选择の観光地名:" + maxSelectAddress);

        printNoSelectAddress(students, maxSelectAddress);//この観光地を選ばなかった人を出力
    }

    private static void printNoSelectAddress(List<Student> students, String maxSelectAddress) {
        students.stream().filter(student -> !student.getSelectAddress().contains(maxSelectAddress))
                .forEach(student -> System.out.println("この観光地を選ばなかった氏名:" + student.getName()));
    }

    private static String getMaxSelectAddress(Map<String, Integer> map){
        return map.entrySet().stream().max((o1, o2) -> o1.getValue() - o2.getValue()).get().getKey();
    }

    public static Map<String, Integer> parseSelectAddresssCount(List<Student> students){
        Map<String, Integer> Map = new HashMap<>();
        for (Student student : students){
            String selectAddress = student.getSelectAddress();
            String[] selectAddressArr = selectAddress.split("-");
            //            各観光地を走査
            for (String address : selectAddressArr){
                //                コレクションにこの観光地があるか判定
                if (Map.containsKey(address)){
                    //                    この観光地あり、回数+1
                    Map.put(address,Map.get(address)+1);
                }else {
                    //                    この観光地なし、回数+1
                    Map.put(address,1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : Map.entrySet()){
            System.out.println("観光地名" + entry.getKey() + "、選択回数:" + entry.getValue());
        }
        return Map;
    }

    private static List<Student> parseStudents(String info) {
        String[] studentsInfos = info.split("#");
        List<Student> students = new ArrayList<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (String studentInfo : studentsInfos){
            String[] studentInfoArr = studentInfo.split(",");
            String time = studentInfoArr[3];
            //            LocalDateTimeに解析
            LocalDateTime localDateTime = LocalDateTime.parse(time, df);
            Student student = new Student(Long.parseLong(studentInfoArr[0]), studentInfoArr[1], studentInfoArr[2],localDateTime, studentInfoArr[4]);
            students.add(student);
        }
        return students;
    }
}

//学生クラスを定義
@Data
@NoArgsConstructor
@AllArgsConstructor
class Student{
    private long id;
    private String name;
    private String sex;
    private LocalDateTime LocalDateTime;
    private String selectAddress;
}
