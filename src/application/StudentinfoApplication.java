package application;

import scholl_report.GenerateGradeReport;
import school.*;
import utils.Define;

public class StudentinfoApplication {
	School goodSchool = School.getInstance(); //학교 생성
	Subject korean; //국어 과목
	Subject math;// 수학 과목
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	public static void main(String[] args) {
		StudentinfoApplication test = new StudentinfoApplication();
		
		test.createSubject(); //과목생성 메소드 호출
		test.carateStudent();  //학생 생성 메소드 호출
		
		String report = test.gradeReport.getReport(); //성적 결과 생성
		System.out.println(report);
				
	}
	
	//과목을 생성
	public void createSubject() {
		korean = new Subject("국어", Define.KOREA);
		math = new Subject("수학", Define.MATH);
	
		//학교에 과목을 넣어준다.
		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
	}
	
	//학생 생성
	public void carateStudent() {
		Student sutdent1 = new Student(181213, "박지은", korean);
		Student sutdent2 = new Student(181518, "차슬기", math);
		Student sutdent3 = new Student(171230, "이현욱", korean);
		Student sutdent4 = new Student(171255, "임지연", korean);
		Student sutdent5 = new Student(171590, "김재현", math);
		
		//학교에 등록
		goodSchool.addStudent(sutdent1);
		goodSchool.addStudent(sutdent2);
		goodSchool.addStudent(sutdent3);
		goodSchool.addStudent(sutdent4);
		goodSchool.addStudent(sutdent5);
		
		//수강신청
		korean.register(sutdent1);
		korean.register(sutdent2);
		korean.register(sutdent3);
		korean.register(sutdent4);
		korean.register(sutdent5);

		math.register(sutdent1);
		math.register(sutdent2);
		math.register(sutdent3);
		math.register(sutdent4);
		math.register(sutdent5);
		
		//학생의 과목별 점수 추가
		addScoreForStudent(sutdent1, korean , 95);
		addScoreForStudent(sutdent1, math , 56);
		
		addScoreForStudent(sutdent2, korean , 95);
		addScoreForStudent(sutdent2, math , 95);

		addScoreForStudent(sutdent3, korean , 100);
		addScoreForStudent(sutdent3, math , 88);
		
		addScoreForStudent(sutdent4, korean , 89);
		addScoreForStudent(sutdent4, math , 95);
		
		addScoreForStudent(sutdent5, korean , 85);
		addScoreForStudent(sutdent5, math , 56);
	}
	
	//학생마다 과목별로 점수 추가
	public void addScoreForStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(),subject,point); //점수객체 생성자 넣어주기
		student.addSubjectScore(score); //각 학생에게 점수를 넣어주는 메소드
		
	
	}
	

}
