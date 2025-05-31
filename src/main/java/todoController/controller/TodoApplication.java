package todoController.controller;

import todoController.dao.TodoDao;
import todoController.dto.Todo;
import util.JdbcConnection;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoApplication {
    public static void main(String[] args) {
        TodoDao dao = new TodoDao();
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while(run) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("1. 할 일 등록 | 2. 전체 할 일 보기 | 3. 할 일 완료 체크 | 4. 할 일 삭제 | 5. 종료");
            System.out.println("---------------------------------------------------------------------");
            System.out.print(">> ");
            int choice = Integer.parseInt(sc.nextLine());

            if(choice==1) {
                System.out.println("[할 일 등록]");
                System.out.print("내용 입력 > ");
                String content = sc.nextLine();

                Todo t = new Todo(content);
                int res = dao.insert(t);
                if(res==1) {
                    System.out.println("등록이 정상적으로 완료되었습니다.");
                } else {
                    System.out.println("등록에 실패하였습니다.");
                }
            } else if(choice==2) {
                ArrayList<Todo> tlist = dao.selectList();
                for(Todo t : tlist) {
                    System.out.println(t);
                }
            } else if(choice==3) {
                System.out.println("[할 일 완료 처리]");
                System.out.print("완료할 할 일 번호 입력 > ");
                int id = Integer.parseInt(sc.nextLine());
                int res = dao.update(id);
                if(res==1) {
                    System.out.println("할 일이 완료되었습니다.");
                } else {
                    System.out.println("할 일 완료에 실패하였습니다.");
                }
            } else if(choice==4) {
                System.out.println("[할 일 삭제]");
                System.out.print("삭제할 할 일 번호 입력 > ");
                int id = Integer.parseInt(sc.nextLine());
                int res = dao.delete(id);
                if(res==1) {
                    System.out.println("할 일 삭제 완료되었습니다.");
                } else {
                    System.out.println("할 일 삭제에 실패하였습니다.");
                }
            } else if(choice==5) {
                dao.closeResources();
                run = false;
            }
        }
    }
}