package entites;

/**
 * @author san vui
 * @create 11/09/2021 - 13:17
 * @sanvankhanh@gmail.com
 */
public class Student {
    private  String name;
    private int entryTest;

    public Student(String name, int entryTest) {
        this.name = name;
        this.entryTest = entryTest;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEntryTest() {
        return entryTest;
    }

    public void setEntryTest(int entryTest) {
        this.entryTest = entryTest;
    }
}
