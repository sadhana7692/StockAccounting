package Utilities;

import org.openqa.selenium.WebDriver;

import CommonFunLibrary.ERP_Functions;

public class DriverScript {
	WebDriver driver;
	public static void main(String[] args) throws Exception {
		ExcelFileUtil exl=new ExcelFileUtil();
		int rc=exl.rowCount("SUPPLIER");
		
		ERP_Functions erp=new ERP_Functions();
		
		for(int i=1;i<=rc;i++){
			
			String sname=exl.getData("Supplier", i, 0);
			String address=exl.getData("Supplier", i, 1);
			String city=exl.getData("Supplier", i, 2);
			String country=exl.getData("Supplier", i, 3);
			String pnumber=exl.getData("Supplier", i, 4);
			String cperson=exl.getData("Supplier", i, 5);
			String mail=exl.getData("Supplier", i, 6);
			String mnumber=exl.getData("Supplier", i,7 );
			String note=exl.getData("Supplier", i, 8);
			
			erp.lanchAPP("http://webapp.qedge.com");
			erp.login("admin", "master");
			
			String result=erp.supplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
			exl.setData("Supplier",i, 9, result);
		}
		

	}

}
