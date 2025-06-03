package petcontroller.controller;

import petcontroller.dao.PetDao;
import petcontroller.dto.Pet;

import java.util.ArrayList;
import java.util.Scanner;

public class PetApplication {
    public static void main(String[] args) {
        PetDao dao = new PetDao();
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while(run) {
                System.out.println("---------------------------------------------------------------------");
                System.out.println("1. 반려동물 등록 | 2. 전체 목록 조회 | 3. 예방접종 처리 | 4. 동물 삭제 | 5. 종료");
                System.out.println("---------------------------------------------------------------------");
                System.out.print(">> ");
            try {
                int select = Integer.parseInt(sc.nextLine());

                if(select == 1) {
                    System.out.print("이름 입력 : ");
                    String name = sc.nextLine();
                    System.out.print("종류 입력(dog/cat/hamster 등) : ");
                    String type = sc.nextLine();
                    System.out.print("나이 입력 : ");
                    int age = Integer.parseInt(sc.nextLine());

                    Pet p = new Pet(name, type, age);
                    int res = dao.insert(p);
                    if(res == 1) {
                        System.out.println("정상적으로 등록되었습니다.");
                    } else {
                        System.out.println("잠시 후 다시 시도해주세요.");
                    }
                } else if(select == 2) {
                    ArrayList<Pet> plist = dao.selectList();
                    for(Pet p : plist) {
                        System.out.println(p);
                    }
                } else if(select == 3) {
                    System.out.print("예방 접종 할 동물의 ID 입력 : ");
                    int id = Integer.parseInt(sc.nextLine());

                    int res = dao.update(id);
                    if(res == 1) {
                        System.out.println("예방 접종이 완료되었습니다.");
                    } else {
                        System.out.println("잠시 후 다시 시도해주세요.");
                    }
                } else if(select == 4) {
                    System.out.print("삭제 할 동물의 ID 입력 : ");
                    int id = Integer.parseInt(sc.nextLine());
                    int res = dao.delete(id);
                    if(res == 1) {
                        System.out.println("삭제가 완료되었습니다");
                    } else {
                        System.out.println("잠시 후 다시 시도해주세요.");
                    }
                } else if(select == 5) {
                    dao.closeResources();
                    run = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력해해주세요.");
            }

        }
        System.out.println("프로그램 종료");
    }
}
