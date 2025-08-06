package mylab.student.exception;

public class InvalidGradeException extends Exception {
    public InvalidGradeException(String errorMessage) { 
        // 부모 클래스(Exception)의 생성자를 호출합니다. 
        super(errorMessage);
    }
}