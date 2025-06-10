package scoreController.controller;

import scoreController.dao.ScoreDao;
import scoreController.dto.Score;
import scoreController.dto.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreApplication {


    public static void main(String[] args) {
        ScoreDao dao = new ScoreDao(); // Connection 초기화
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("1. 학생입력 | 2. 전체 학생 정보 조회 | 3. 전체 학생 점수 조회 | 4. 회원 정보 삭제 | 5. 종료");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.print(">> ");

            int selectNo = sc.nextInt();
            sc.nextLine();

            if (selectNo == 1) {
                System.out.print("이름 : ");
                String name = sc.nextLine();
                System.out.print("수학 점수 : ");
                int math = Integer.parseInt(sc.nextLine());
                System.out.print("영어 점수 : ");
                int eng = Integer.parseInt(sc.nextLine());
                System.out.print("국어 점수 : ");
                int kor = Integer.parseInt(sc.nextLine());

                Student s = new Student(name, math, eng, kor);
                int res = dao.insert(s);
                if(res == 1) {
                    System.out.println("등록이 완료되었습니다.");
                } else {
                    System.out.println("등록이 실패하였습니다.");
                }
            } else if (selectNo == 2) {
                ArrayList<Student> slist = dao.selectlist();
                for (Student s : slist) {
                    System.out.println(s);
                }
            } else if (selectNo == 3) {
                ArrayList<Score> list = dao.selectScore();
                for (Score s : list) {
                    System.out.println(s);
                }
            } else if (selectNo == 4) {
                System.out.print("번호 입력 : ");
                int num = Integer.parseInt(sc.nextLine());
                int res = dao.delete(num);
                if(res == 1) {
                    System.out.println("회원 정보 삭제를 완료하였습니다.");
                } else {
                    System.out.println("회원 정보 삭제를 실패하였습니다.");
                }
            } else if (selectNo == 5) {
                dao.closeResources();
                run = false;
            }
        }
    }
}
