package scholl_report;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicArrowButton;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class GenerateGradeReport {
	// 필드

	School school = School.getInstance(); // School 싱글톤 객체 생성

	public static final String TITLE = "수강생 학점 \t\t\n";
	public static final String HEADER = "이름 | 학번 | 필수과목 | 점수   \n";
	public static final String LINE = "====================================\n";
	private StringBuffer buffer = new StringBuffer(); // 스트링버퍼

	// 성적 산출결과의 헤더, 몸통, 푸터를 합쳐준다.
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList();
		for (Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}

		return buffer.toString(); // buffer의 데이터를 String 타입으로 바꾼다.
	}

	// 헤더를 만들어준다.
	public void makeHeader(Subject subject) {
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE);
	}

	// 바디를 만들어준다.
	public void makeBody(Subject subject) {
		// 학생 리스트를 가져온다.
		ArrayList<Student> studentList = subject.getStudentList();

		// 새로운거, size
		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			buffer.append(student.getStudentName()); // 이름
			buffer.append(" | ");
			buffer.append(student.getStudentId()); // 학번
			buffer.append(" | ");
			buffer.append(student.getMajorSubject().getSubjectName() + "\t");// 학생 필수 과목
			buffer.append(" | ");

			// 학생별 수강과목의 학점 계산
			getScoreGrade(student, subject.getSubjcetId());
			buffer.append("\n");
			buffer.append(LINE);

		}

	}

	// 학생의 수강과목 점수와 학점을 얻는 메소드
	public void getScoreGrade(Student student, int subjectId) {
		// 해당 학생이 수강한 과목의 점수 리스트(국어, 수학)
		ArrayList<Score> scoreList = student.getScoreList();
		//

		// 해당 학생의 필수과목의 과목코드
		int majorId = student.getMajorSubject().getSubjcetId();

		// 항상 하던 자동형변환이 아니라
		GradeEvaluation[] gradeEvaluation = { new BasicEvaluation(), new MajorEvaluation() };

		for (int i = 0; i < scoreList.size(); i++) {
			Score score = scoreList.get(i);

			// 과목 코드가 같은지 확인
			if (score.getSubjcet().getSubjcetId() == subjectId) {
				String grade; // 학점

				// 필수과목은 학점 산출하는 방법이 다름.
				if (score.getSubjcet().getSubjcetId() == majorId) { // 필수과목일때 학점 산출하는법
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
				} else {// 일반 과목일때 학점 산출
					grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
				}

				buffer.append(score.getPoint());
				buffer.append(":");
				buffer.append(grade);
				buffer.append(" | ");

			}

		}

	}

	// 풋터를 만들어준다.
	public void makeFooter() {
		buffer.append("\n"); // (buffer += "\n\") 줄바꿈 해주는 애
	}

}
