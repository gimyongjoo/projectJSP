package bookController.controller;

import bookController.dao.BookDao;
import bookController.dto.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookApplication {
    public static void main(String[] args) {
        BookDao dao = new BookDao();
        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.print("1. 책 등록 | 2. 전체 책 목록 조희 | 3. 종료\n>> ");
            int choice = Integer.parseInt(sc.nextLine());

            if(choice==1) {
                System.out.print("제목 : ");
                String title = sc.nextLine();
                System.out.print("저자 : ");
                String author = sc.nextLine();

                Book b = new Book(title, author);
                int res = dao.insert(b);
                if(res==1) {
                    System.out.println("성공적으로 등록되셨습니다.");
                } else {
                    System.out.println("잠시 후 다시 시도 부탁드립니다.");
                }
            } else if(choice==2) {
                ArrayList<Book> blist = dao.select();
                for(Book bo : blist) {
                    System.out.println(bo);
                }
            } else if(choice==3) {
                dao.closeResources();
                run = false;
            }
        }
        System.out.println("종료되었습니다.");
    }
}
