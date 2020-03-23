package medical;

public class Organization {
	private String name; //조직의 이름
	private int employeeCount; // 직원수
	
	
	// 기본생성자하나 멤버변수를 매개변수로 받는 생성자 추가!
	public Organization() {
		super();
	}
	// private >> default(같은 페키지 내에서만 접근 허용) >> protected(상속관계에서 접근허용) >> public(모두허용)
	public Organization(String name, int employeeCount) {
		super();
		this.name = name;
		this.employeeCount = employeeCount;
	}
	// 이건 getter setter에서 구조를 우리가 만들수 있기 때문에 직접적 접근과 차이가 있다
	// 이것을 바로 인캡슐레이션이라고 한다 (캡슐화)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	public void about() {
		System.out.println("Organization : " + name);
	}
	
	
}
