package deliveryController.controller;

import deliveryController.dao.DeliveryDao;
import deliveryController.dto.Delivery;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryApplication {
    public static void main(String[] args) {
        DeliveryDao dao = new DeliveryDao();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while(run) {
            System.out.print("1. 배송 요청 목록 | 2. 전체 배송 목록 조회 | 3. 배송 상태 변경 | 4. 배송 요청 삭제 | 5. 종료\n>> ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if(choice == 1) {
                    System.out.print("이름 입력 : ");
                    String name = sc.nextLine();
                    System.out.print("주소 입력 : ");
                    String address = sc.nextLine();
                    System.out.print("연락처 입력 : ");
                    String phone = sc.nextLine();
                    System.out.print("상품 입력 : ");
                    String productName = sc.nextLine();
                    System.out.print("요청일 입력 (xxxx-xx-xx) : ");
                    String requestDate = sc.nextLine();
                    LocalDate date = LocalDate.parse(requestDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    Delivery d = new Delivery(name, address, phone, productName, date);
                    int res = dao.insert(d);
                    if(res == 1) {
                        System.out.println("요청이 성공적으로 완료되었습니다.");
                    } else {
                        System.out.println("잠시 후 다시 시도해주기 바랍니다.");
                    }
                } else if(choice == 2) {
                    ArrayList<Delivery> dlist = dao.selectList();
                    if(dlist.isEmpty()) {
                        System.out.println("배송 목록이 비어있습니다.");
                    } else {
                        for(Delivery d : dlist) {
                            System.out.println(d);
                        }
                    }
                } else if(choice == 3) {
                    System.out.print("상태 변경 할 ID 입력 : ");
                    int id = Integer.parseInt(sc.nextLine());

                    int res = dao.update(id);
                    if(res == 1) {
                        System.out.println("배송 상태가 '배송 중'으로 변경되었습니다.");
                    } else {
                        System.out.println("잠시 후 다시 시도해주시기 바랍니다.");
                    }
                } else if(choice == 4) {
                    System.out.print("요청 삭제 할 ID 입력 : ");
                    int id = Integer.parseInt(sc.nextLine());

                    int res = dao.delete(id);
                    if(res == 1) {
                        System.out.println("배송 요청이 삭제되었습니다.");
                    } else {
                        System.out.println("잠시 후 다시 시도해주시기 바랍니다.");
                    }
                } else if(choice == 5) {
                    System.out.println("종료합니다.");
                    dao.closeResources();
                    sc.close();
                    run = false;
                }
            } catch (NumberFormatException | DateTimeParseException e) {
                System.out.println("입력 형식이 올바르지 않습니다. 숫자나 날짜 형식을 다시 확인해주세요.");
            }
        }
    }
}
