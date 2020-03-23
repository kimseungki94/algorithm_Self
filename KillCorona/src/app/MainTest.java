package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import medical.CDC;
import medical.Hospital;
import medical.NotCoronaException;
import medical.Organization;
import person.Patient;

public class MainTest {

	public static void main(String[] args) throws NotCoronaException {
		// buffered는 담아서 쓰는거 I/O에서 매우 빠름!
		// 병원생성
		Hospital univHospital = new Hospital("대학병원", 15, "001", 50, 10);
		Hospital localHospital = new Hospital("동네병원", 3, "901", 10, 2);
		// 환자생성
		Patient p1 = new Patient("환자1", 42, "010-1111-1111", "호흡곤란", "001", true); // true false를 통해서 코로나 환자인지 아닌지 체크
		Patient p2 = new Patient("환자2", 30, "010-2222-2222", "과음", "901", false);
		// 병원 collection
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		hospitalList.add(univHospital);
		hospitalList.add(localHospital);
		// 환자 collection
		Set<Patient> patientList = new HashSet<Patient>();
		patientList.add(p1);
		patientList.add(p2);
		patientList.add(p2);
		// overriding test
//      Organization org = new CDC("질병관리본부",200,hospitalList,patientList);
//      org.about();
		CDC cdc = new CDC("질병관리본부", 200, hospitalList, patientList);
		Patient p3 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", false); // false시 예외처리됨
		//checkexception임
		try {
			univHospital.addPatient(cdc, p3);

		} catch (NotCoronaException e) {
			System.out.println("corona 환자가 아닙니다.");
		}
		

		Patient p4 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", true);
		univHospital.addPatient(cdc, p4);
		System.out.println(cdc.getPatientList());
		univHospital.removePatient(cdc, p3);
		System.out.println(cdc.getPatientList());

		// 이러면 삭제가 안될거임!
		try {
			univHospital.addPatient(cdc, p3);

		} catch (NotCoronaException e) {
			System.out.println("corona 환자가 아닙니다.");
		}
		System.out.println(cdc.getPatientList());
		univHospital.removePatient(cdc, p4);
		System.out.println(cdc.getPatientList());
		try {
			univHospital.addPatient(cdc, p3);

		} catch (NotCoronaException e) {
			System.out.println("corona 환자가 아닙니다.");
		} // 지웠으니 다시추가가능
		System.out.println(cdc.getPatientList());
		try {
			univHospital.addPatient(cdc, p4);

		} catch (NotCoronaException e) {
			System.out.println("corona 환자가 아닙니다.");
		} // 중복값이라 출력이안됨
		System.out.println(cdc.getPatientList());

		// 결과
//      [person.Patient@33909752, person.Patient@55f96302, person.Patient@3d4eac69] p3
//    		  [person.Patient@33909752, person.Patient@55f96302] p3
//    		  [person.Patient@33909752, person.Patient@55f96302, person.Patient@3d4eac69] p3
//    		  [person.Patient@33909752, person.Patient@55f96302, person.Patient@3d4eac69] p4
//		패이션트 객체에 equals()통해 비교!
//		이걸 재대로 하려면 equals() 메소드를 오버라이딩할 필요가 있음 Object(최상위 객체)에 equals 메소드 부분을 상속받았으니 equal부분을 바꾸어야함

		// 결과
//    [person.Patient@33909752, person.Patient@55f96302, person.Patient@3d4eac69] p3
//  		  [person.Patient@33909752, person.Patient@55f96302] p3
//  		  [person.Patient@33909752, person.Patient@55f96302, person.Patient@3d4eac69] p3
//  		  [person.Patient@33909752, person.Patient@55f96302, person.Patient@3d4eac69] p4
//		이번엔 삭제가 안됨....
// 		hashcode를 오버라이딩해야됨! 이유는 두객체의 해쉬값이 다르기 때문이다!

		String filePath = "c:" + File.separator + "SSAFY";
		String fileName = "CoronaPatientList.csv";
		BufferedWriter writer=null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath + File.separator + fileName), "MS949"));
			
			for(Patient p : patientList) {
				writer.write(p.getName() + "^" + p.getAge() + "^" + p.getPhone());
				writer.newLine();
			}
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace(); 
		}finally {
			if(writer !=null) {
				try {
					writer.flush();
				}catch(IOException e) {
					e.printStackTrace();
				}
				try {
					writer.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}