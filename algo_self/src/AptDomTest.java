

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AptDomTest {

	public static void main(String[] args) {
		File file = new File("./src/xml/AptDealHistory.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			 doc.getDocumentElement().normalize();
			 Element root = doc.getDocumentElement();
			System.out.println(root.getNodeName());
			
			NodeList nodeList = doc.getElementsByTagName("item");
			List<Apt> empList = new ArrayList<Apt>();
			System.out.println("아파트 이름 입력");
			Scanner sc = new Scanner(System.in);
			String tempApt = sc.nextLine();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				Element element = (Element)node; 
				String apt = element.getElementsByTagName("아파트").item(0).getTextContent();
				if(tempApt.equals(apt)) {
					String money = element.getElementsByTagName("거래금액").item(0).getTextContent();
					String aptyear = element.getElementsByTagName("건축년도").item(0).getTextContent();
					String year = element.getElementsByTagName("년").item(0).getTextContent();
					String dong = element.getElementsByTagName("법정동").item(0).getTextContent();
					apt = element.getElementsByTagName("아파트").item(0).getTextContent();
					String month = element.getElementsByTagName("월").item(0).getTextContent();
					String day = element.getElementsByTagName("일").item(0).getTextContent();
					String area = element.getElementsByTagName("전용면적").item(0).getTextContent();
					String address = element.getElementsByTagName("지번").item(0).getTextContent();
					String area_code = element.getElementsByTagName("지역코드").item(0).getTextContent();
					String floor = element.getElementsByTagName("층").item(0).getTextContent();
					Apt emp = new Apt();
					emp.setMoney(money);
					emp.setAptyear(Integer.parseInt(aptyear));
					emp.setYear(Integer.parseInt(year));
					emp.setDong(dong);
					emp.setApt(apt);
					emp.setMonth(month);
					emp.setDay(day);
					emp.setArea(area);
					emp.setAddress(address);
					emp.setArea_code(Integer.parseInt(area_code));
					emp.setFloor(Integer.parseInt(floor));
					empList.add(emp);
				}
				
				
			
			}
			for(Apt emp:empList) {
				System.out.println(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
