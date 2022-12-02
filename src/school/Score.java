package school;

//어느 학생의 어느 과목 점수가 몇점이다.
public class Score {
	private int studentId; //학번
	private Subject subjcet; //과목
	private int point; //점수
	
	public Score(int studentId, Subject subjcet, int point) {
		this.studentId = studentId;
		this.subjcet = subjcet;
		this.point = point;
	}

	//Score 객체가 가지고있는 학번, 과목, 점수만 리턴해주는 기능을 가지게 바꿔줄꺼임
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "학번:" + this.studentId + "," + subjcet.getSubjectName() + ":" + point;
	}

	//ㄱㅌㅅㅌ
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Subject getSubjcet() {
		return subjcet;
	}

	public void setSubjcet(Subject subjcet) {
		this.subjcet = subjcet;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	
	
	
}
