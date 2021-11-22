import java.util.Arrays;

public class Test_14 {

    static class Student {
        String name;
        double grade;
        public Student(String n, double g) {
            name = n; grade = g;
        }
        public String toString() {
            return "(" + name + ", " + grade + ")";
        }
    }

    public static void main(String[] args) {
        String[][] names = {{"Gloria Tang", "Andy Lau", "McDull"},
                {"Eason Chan", "Denise Ho", "Jennifer Chan", "Joey Yung", "Kay Tse", "Jacky Cheung", "Anita Mui"},
                {"Winnie", "Mickey", "Teddy", "Peppa"}};
        double[][] grades = {{60, 60, 60}, {40, 60, 70, 80, 90, 95, 100}, {0, 90, 95, 100}};
        Student[][] a = new Student[names.length][];
        for (int i = 0; i < names.length; i++) {
            a[i] = new Student[names[i].length];
            for (int j = 0; j < names[i].length; j++)
                a[i][j]= new Student(names[i][j], grades[i][j]);
        }
        System.out.println(names[2][0]);

    }


}
