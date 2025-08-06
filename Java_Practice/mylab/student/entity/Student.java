package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	 // 1. private 필드 작성
    private String studentId;
    private String name;
    private String major;
    private int grade;

    // 생성자
    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.major = major;
        
        try {
        	setGrade(grade);
        } catch (InvalidGradeException e) {
            System.err.println(e.getMessage());
            this.grade = 1; 
        }
    }

    // 모든 필드에 대한 getter 메서드
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGrade() {
        return grade;
    }

    // setGrade 메서드는 이전과 동일하게 예외를 던집니다.
    public void setGrade(int grade) throws InvalidGradeException {
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            throw new InvalidGradeException("학년은 1~4 사이여야 합니다.");
        }
    }
}
