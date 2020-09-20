package kr.co.nsjsoft;

import java.io.*;
import java.sql.*;

public class nsjTestClass {
	
	public String name;
	public String color;
	public double weight;
	public int count;
	
	static String staticVal;
	
	static {
		staticVal = "Static Value";
		staticVal = nsjTestClass.staticVal + "";
	}
	
	public nsjTestClass(String name, String color, double weight, int count) {
		this.name = name;
		this.color = color;
		this.weight = weight;
		this.count = count;
	}
	// d(3) = 3
	// d(2) = 2
	// d(11) = 1 + 1 + 11 = 14 
	// d
	// d(20) = 2 + 0 + 20 = 22;
    // d(91) = 9 + 1 + 91 = 101
	// d(100) = 1 + 0 + 100 = 101;
	
	public nsjTestClass getnsjFirstClassInstance() {
		return this;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		//Monster mob = new Monster("나상진");
		
		Monster.Brain.think();
		
		Connection conn = null;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("select * from emp");
				
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String pass = "1234"; 
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		conn = DriverManager.getConnection(url, user, pass);
		
		conn.setAutoCommit(false);
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sb.toString());
		
		while (rs.next()) {
			int iDeptNo = rs.getInt("DEPTNO");
			String sName = rs.getString("ENAME");
			
			System.out.println("부서 =>" + iDeptNo + "\t이름=>" + sName);
		}
		
		sb.delete(0,  sb.length());
		
		sb.setLength(0);
	
		sb.append("update emp ");
		sb.append("set sal = ? ");
		sb.append("where empno = ? ");
			
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		
		pstmt.setInt(1, 1000);
		pstmt.setInt(2, 7369);
		
		pstmt.executeUpdate();
		
		conn.commit();
		
		nsjTestClass banana = new nsjTestClass("banana", "yellow", 5.0, 10);
		nsjTestClass apple = null;
		
		InputStream in = System.in;
			
		InputStreamReader reader = new InputStreamReader(in);
		
		BufferedReader br = new BufferedReader(reader);
		
		int a = 21;
		
		String num = String.valueOf(a);
		
		int no = 0;
		
		System.out.println("num => " +  num);
		
		for( int n = 0; n < num.length(); n++)
		{
			
			no += Integer.parseInt(num.substring(n, n + 1));
			
			System.out.println("num(charat) => " +  num.charAt(n));
			System.out.println("n => " + n);
			System.out.println(num.substring(n, n + 1));
			System.out.println(num.substring(1, 2));
			System.out.println("no => " + no);
			System.out.println("==================");
		}
				
		System.out.println("no => " + no);
		System.out.println(num.length());
		System.out.println(num);
		
		String b = null;
		
		int[] c = {1,2,3};
		
		c[0] = 16;
				
		try {
			a = in.read();
			System.out.println(a);
			b = br.readLine();
		} catch(IOException e) {
			
		} catch(ArithmeticException e) {
			
		} finally {
			
		};
		
		System.out.println(b);
		
		apple = banana.getnsjFirstClassInstance();
	    
		System.out.println("name : " + banana.name);
		System.out.println("count : " + banana.count);
		System.out.println("color : " + banana.color);
		System.out.println("weight : " + banana.weight);
		System.out.println("count : " + banana.count);
		
		System.out.println("name : " + apple.name);
		System.out.println("color : " + apple.color);
		System.out.println("weight : " + apple.weight);
		System.out.println("count : " + apple.count);
		
		System.out.println("NSJ Project First Class!!!");
	}
	
	static {
		staticVal = "Performance is important!!!";
	}
}
