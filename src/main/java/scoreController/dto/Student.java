package scoreController.dto;

public class Student {
    private int num;
    private String name;
    private int math;
    private int eng;
    private int kor;
    private int total;
    private double avg;

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public int getEng() {
        return eng;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public int getKor() {
        return kor;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public double getAvg() {
        return avg;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }
    public Student(String name, int math, int eng, int kor) {
        super();
        this.name = name;
        this.math = math;
        this.eng = eng;
        this.kor = kor;
    }
    @Override
    public String toString() {
        return String.format("%d\t%s\t%4d\t%4d\t%4d\t%4d\t%.2f\t", num,name, math, eng, kor, total, avg);
    }

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }
}
