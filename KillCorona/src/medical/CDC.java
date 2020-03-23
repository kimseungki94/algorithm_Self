package medical;

import java.util.List;
import java.util.Set;

import person.Patient;

public class CDC extends Organization {
	private static List<Hospital> hospitalList;
	private static Set<Patient> patientList;

	public CDC() {

	}

	public CDC(String name, int employeeCount, List<Hospital> hospitalList, Set<Patient> patientList) {
		super(name, employeeCount);
		this.hospitalList = hospitalList;
		this.patientList = patientList;
	}

	public static List<Hospital> getHospitalList() {
		return hospitalList;
	}

	public static void setHospitalList(List<Hospital> hospitalList) {
		CDC.hospitalList = hospitalList;
	}

	public static Set<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(Set<Patient> patientList) {
		this.patientList = patientList;
	}

	public void addPatient(Patient p) {
		this.getPatientList().add(p);
	}

	public void removePatient(Patient p) {
		this.getPatientList().remove(p);
	}

	@Override
	public void about() {
		System.out.println("Organization -" + " " + super.getName());
	}

	public void about(String more) {
		System.out.println("We are Hospital");
	}
}
