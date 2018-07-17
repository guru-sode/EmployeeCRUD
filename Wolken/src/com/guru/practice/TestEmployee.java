package com.guru.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestEmployee {

	public static void main(String[] args) {
		Scanner scan1=new Scanner(System.in);
		Scanner scan2=new Scanner(System.in);
		int sel=0;
		Connection con=null;
		PreparedStatement ps_ins=null,ps_sel=null,ps_upd=null,ps_delete=null,ps_search=null;
		String name,department;
		int id;
		ResultSet rs=null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
			System.out.println("Connected:"+con);
			
			ps_ins=con.prepareStatement("insert into employees(name,id,department) values(?,?,?)");
			ps_upd=con.prepareStatement("update employees set id=?,department=? where name=?");
			ps_sel=con.prepareStatement("select * from employees");
			ps_delete=con.prepareStatement("delete from employees where name=?");
			ps_search=con.prepareStatement("select * from employees where name like ?");
			
			
			while(sel!=6) {
				System.out.println("Enter 1 to add an employee");
				System.out.println("Enter 2 to update an emplyoee's details");
				System.out.println("Enter 3 to list all employees");
				System.out.println("Enter 4 to delete an employee from database");
				System.out.println("Enter 5 to search details of the employee");
				System.out.println("Enter 6 to exit");
				 sel=scan1.nextInt();
				switch (sel) {
				case 1:
					System.out.println("Enter the name of the employee");
					name=scan2.nextLine();
					System.out.println("Enter the id");
					id=scan1.nextInt();
					System.out.println("Enter the department");
					department=scan2.nextLine();
					
					ps_ins.setString(1, name);
					ps_ins.setInt(2, id);
					ps_ins.setString(3, department);
					ps_ins.execute();
					break;
				case 2:
					System.out.println("Enter the name of the employee whose details has to be changed");
					name=scan2.nextLine();
					System.out.println("Enter the new id");
					id=scan1.nextInt();
					System.out.println("Enter the new department");
					department=scan2.nextLine();
					ps_upd.setInt(1, id);
					ps_upd.setString(2, department);
					ps_upd.setString(3, name);
					ps_upd.execute();
					break;
				case 3:
					System.out.println("Listing all the employees:");
					ps_sel.execute();
					rs=ps_sel.getResultSet();
					while(rs.next())
					{
							name=rs.getString("name");
							id=rs.getInt("id");
							department=rs.getString("department");
							System.out.println("Name:"+name+" ID:"+id+" Department:"+department);
					}
					break;
				case 4:
					System.out.println("Enter name of the employee whose details should be deleted");
					name=scan2.nextLine();
					ps_delete.setString(1, name);
					ps_delete.execute();
					break;
				case 5:
					System.out.println("Enter the name/partial name of the employee whose details has to fetched");
					name=scan2.nextLine();
					ps_search.setString(1, "%"+name+"%");
					ps_search.execute();
					rs=ps_search.getResultSet();
						while(rs.next())
						{
								name=rs.getString("name");
								id=rs.getInt("id");
								department=rs.getString("department");
								System.out.println("Name:"+name+" ID:"+id+" Department:"+department);
						}
					break;
				case 6:
					System.out.println("Thank you");
					break;

				default:
					System.out.println("Invalid selection");
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ps_ins!=null)
				try {
					ps_ins.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
