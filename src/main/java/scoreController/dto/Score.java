package scoreController.dto;

public class Score {
    private int cnt;
    private int totalMath;
    private double avgMath;
    private int totalEng;
    private double avgEng;
    private int totalKor;
    private double avgKor;

    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    public int getTotalMath() {
        return totalMath;
    }
    public void setTotalMath(int totalMath) {
        this.totalMath = totalMath;
    }
    public double getAvgMath() {
        return avgMath;
    }
    public void setAvgMath(double avgMath) {
        this.avgMath = avgMath;
    }
    public int getTotalEng() {
        return totalEng;
    }
    public void setTotalEng(int totalEng) {
        this.totalEng = totalEng;
    }
    public double getAvgEng() {
        return avgEng;
    }
    public void setAvgEng(double avgEng) {
        this.avgEng = avgEng;
    }
    public int getTotalKor() {
        return totalKor;
    }
    public void setTotalKor(int totalKor) {
        this.totalKor = totalKor;
    }
    public double getAvgKor() {
        return avgKor;
    }
    public void setAvgKor(double avgKor) {
        this.avgKor = avgKor;
    }
    public Score() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return String.format("%d\t%4d\t%.2f\t%4d\t%.2f\t%4d\t%.2f",cnt, totalMath, avgMath, totalEng, avgEng, totalKor, avgKor);
    }


}