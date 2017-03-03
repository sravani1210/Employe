package pojo;

public class Employe {
	private String empId;
	private String empName;
	private String empOrg;
	private String empSal;
	private String empDom;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpOrg() {
		return empOrg;
	}
	public void setEmpOrg(String empOrg) {
		this.empOrg = empOrg;
	}
	public String getEmpSal() {
		return empSal;
	}
	public void setEmpSal(String empSal) {
		this.empSal = empSal;
	}
	public String getEmpDom() {
		return empDom;
	}
	public void setEmpDom(String empDom) {
		this.empDom = empDom;
	}
	public Employe(String empId, String empName, String empOrg, String empSal, String empDom) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empOrg = empOrg;
		this.empSal = empSal;
		this.empDom = empDom;
	}
	public Employe() {
		// TODO Auto-generated constructor stub
	}
	
}
