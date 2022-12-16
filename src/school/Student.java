package school;

import java.util.ArrayList;

public class Student {
	private int studentId; //학번
	private String studentName; //이름
	private Subject majorSubject; //필수과목
	private ArrayList<Score> scoreList = new ArrayList<Score>(); //학생이 수강한 과목에 점수 리스트
	
	public Student(int studentId, String studentName , Subject majorSubject) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.majorSubject = majorSubject;
	}
	
	//스코어 리스트
	public void addSubjectScore(Score score) {
		scoreList.add(score);
	}
	
	
	//ㄱㅌㅅㅌ
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Subject getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(Subject majorSubject) {
		this.majorSubject = majorSubject;
	}

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
	
	
	
	
}
