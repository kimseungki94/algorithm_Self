package medical;
//checked exception : 컴파일을 해주지 않는 인지하는 메소드
// unchecked 익셉션 : 컴파일러가 뭐라고 잘 못하는 메소드 ex) runtime exception
public class NotCoronaException extends Exception {
	private static final long serialVersionUID = 1L; //원본이냐 아니냐를 확인하기 위해 
	public NotCoronaException(String msg) {
		super(msg); //exception클래스에 생성자를 호출하면서 들어감!
	}
}
