package memberController.controller;

import memberController.dao.MemberDao;
import memberController.dto.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberApplication {
    static MemberDao dao = new MemberDao(); // Connection 초기화
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("1. 회원가입 | 2. 회원조희 | 3. 회원수정 | 4. 회원삭제 | 5. 로그인 | 6. 종료");
            System.out.println("------------------------------------------------------------------");
            System.out.print(">> ");

            int selectNo = sc.nextInt();
            sc.nextLine();

            if(selectNo == 1) {
                System.out.print("아이디 : ");
                String id = sc.nextLine();
                if(dao.select(id)!=null) {
                    System.out.println("아이디가 중복되셨습니다.");
                    continue;
                }
                System.out.print("비밀번호 : ");
                String pwd = sc.nextLine();
                System.out.print("이름 : ");
                String name = sc.nextLine();
                System.out.print("이메일 : ");
                String email = sc.nextLine();
                Member m = new Member(email, name, pwd, id);
                int res = dao.insert(m);
                if(res == 1) {
                    System.out.println("회원가입을 축하합니다.");
                } else {
                    System.out.println("잠시 후 다시 시도 부탁드립니다.");
                }
            } else if(selectNo == 2) {
                ArrayList<Member> mlist = dao.selectList();
                for(Member m : mlist) {
                    System.out.println(m);
                }
            } else if(selectNo == 3) {
                System.out.print("아이디 : ");
                String id = sc.nextLine();
                System.out.print("비밀번호 : ");
                String pwd = sc.nextLine();
                boolean res = login(id, pwd);
                if(res) {
                    System.out.print("변경 할 비밀번호 : ");
                    pwd = sc.nextLine();
                    System.out.print("변경 할 이름 : ");
                    String name = sc.nextLine();
                    System.out.print("변경 할 이메일 : ");
                    String email = sc.nextLine();
                    Member m = new Member(email, name, pwd, id);
                    int r = dao.update(m);
                    if(r==1) {
                        System.out.println("수정이 완료되었습니다.");
                    } else {
                        System.out.println("잠시 후 시도 부탁드립니다.");
                    }
                } else {
                    System.out.println("로그인에 실패했습니다.");
                }
            } else if(selectNo == 4) {
                System.out.print("아이디 : ");
                String id = sc.nextLine();
                System.out.print("비밀번호 : ");
                String pwd = sc.nextLine();
                boolean res = login(id, pwd);
                if(res) {
                    int r = dao.delete(id);
                    if(r==1) {
                        System.out.println("회원 탈퇴하셨습니다.");
                    } else {
                        System.out.println("잠시 후 다시 시도 부탁드립니다.");
                    }
                } else {
                    System.out.println("로그인에 실패했습니다.");
                }
            } else if(selectNo == 5) {
                System.out.print("아이디 : ");
                String id = sc.nextLine();
                System.out.print("비밀번호 : ");
                String pwd = sc.nextLine();
                boolean res = login(id, pwd);
                if(res) {
                    System.out.println("로그인 성공");
                } else {
                    System.out.println("로그인 실패");
                }
            } else if(selectNo == 6) {
                run = false;
            }
        }
    }
    static boolean login(String id, String pwd) {
        if(dao.select(id) != null) {
            return id.equals(dao.select(id).getId()) && pwd.equals(dao.select(id).getPwd());
        }
        return false;
    }
}
