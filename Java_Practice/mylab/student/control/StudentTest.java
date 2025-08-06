package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
    public static void main(String[] args) {
        try {
            // 유효한 학년으로 객체 생성
            Student student1 = new Student("S1001", "김민수", "컴퓨터공학", 3);
            System.out.println(student1.getName() + "/" + student1.getMajor() + "/" + student1.getGrade() + "학년");

            // 유효하지 않은 학년으로 변경 시도
            System.out.println("5학년으로 변경");
            student1.setGrade(5); 
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage()); // 예외 메시지 출력
        }
    }
}