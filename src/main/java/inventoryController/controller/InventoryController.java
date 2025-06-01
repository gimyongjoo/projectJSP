package inventoryController.controller;

import inventoryController.dao.ProductDao;
import inventoryController.dto.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryController {
    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while(run) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("1. 상품 등록 | 2. 전체 상품 조회 | 3. 상품 입고 | 4. 상품 출고 | 5. 상품 삭제 | 6. 종료");
            System.out.println("---------------------------------------------------------------------------");
            System.out.print(">> ");
            int choice = Integer.parseInt(sc.nextLine());

            if(choice == 1) {
                System.out.println("[상품 조회]");
                System.out.print("상품명 입력 : ");
                String name = sc.nextLine();
                System.out.print("수량 입력 : ");
                int quantity = Integer.parseInt(sc.nextLine());
                System.out.print("가격 입력 : ");
                int price = Integer.parseInt(sc.nextLine());

                Product p = new Product(name, quantity, price);
                int res = dao.insert(p);
                if(res == 1) {
                    System.out.println("상품이 등록 되었습니다.");
                } else {
                    System.out.println("잠시 후 다시 시도 부탁드립니다.");
                }
            } else if(choice == 2) {
                System.out.println("[전체 상품 조회]");
                ArrayList<Product> plist = dao.selectList();
                if(plist.isEmpty()) {
                    System.out.println("상품이 없습니다.");
                }
                for(Product p : plist) {
                    System.out.println(p);
                }
            } else if(choice == 3) {
                System.out.println("[상품 입고]");
                System.out.print("입고 할 상품 번호 입력 : ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("입고 수량 입력 : ");
                int quantity = Integer.parseInt(sc.nextLine());

                int res = dao.update(id, quantity);
                if(res == 1) {
                    System.out.println("상품이 입고 되었습니다.");
                } else {
                    System.out.println("잠시 후 다시 시도 부탁드립니다.");
                }
            } else if(choice == 4) {
                System.out.println("[상품 출고]");
                System.out.print("출고 할 상품 번호 입력 : ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("출고 수량 입력 : ");
                int quantity = Integer.parseInt(sc.nextLine());

                int res = dao.update(id, -quantity);
                if(res == 1) {
                    System.out.println("상품이 출고 되었습니다.");
                } else {
                    System.out.println("잠시 후 다시 시도 부탁드립니다.");
                }
            } else if(choice == 5) {
                System.out.println("[상품 삭제]");
                System.out.print("아이디 입력 : ");
                int id = Integer.parseInt(sc.nextLine());

                int res = dao.delete(id);
                if(res == 1) {
                    System.out.println("상품이 삭제 되었습니다.");
                } else {
                    System.out.println("잠시 후 다시 시도 부탁드립니다.");
                }
            } else if(choice == 6) {
                System.out.println("종료합니다.");
                dao.closeResources();
                run = false;
            }
        }
    }
}
