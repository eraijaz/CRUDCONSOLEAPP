package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import com.controller.IStudentController;
import com.dto.Student;
import com.factory.StudentControllerFactory;

public class TestApp implements Serializable {

	public static void main(String[] args)
	{
		IStudentController studentController =null;
		String status=null;
		Student studentRecord=null; Integer id=null;
		
	try {
		while (true)
		{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("1. CREATE");
		System.out.println("2. READ");
		System.out.println("3. UPDATE");
		System.out.println("4. DELETE");
		System.out.println("5. EXIT");
		System.out.println("YOUR OPTION::[1,2,3,4,5]");
		
		Integer option=Integer.parseInt(br.readLine());
		
		switch (option) {
		case 1:
			System.out.println("Enter name::");
			String  name=br.readLine();
			System.out.println("Enter city::");
			String city =br.readLine();
			System.out.println("Enter email::");
			String email =br.readLine();
			System.out.println("Enter country::");
			String country =br.readLine();
			studentController=StudentControllerFactory.getStudentController();
			Student student=new Student();
			student.setName(name);
			student.setCity(city);
			student.setEmail(email);
			student.setCountry(country);
			status=studentController.save(student);
			System.out.println(status);
			if (status.equalsIgnoreCase("success"))
			{
				System.out.println("Record inserted successfully");
			}
			else if(status.equalsIgnoreCase("failure"))
			{
				System.out.println("Record insertion failed");
			}
			else
			{
				System.out.println("some problem occured");
			}
			
			break;
		case 2:
			System.out.print("Enter the id:: ");
			id = Integer.parseInt(br.readLine());
			studentController=StudentControllerFactory.getStudentController();
			studentRecord=studentController.findById(id);
			System.out.println("find id");
			if (studentRecord != null)
				System.out.println(studentRecord);
			else
				System.out.println("Record not available for the given id ::" + id);
			break;
			
				
		case 3:
			System.out.print("Enter the id of the record to be updated:: ");
			id = Integer.parseInt(br.readLine());
			studentController=StudentControllerFactory.getStudentController();
			studentRecord = studentController.findById(id);
			if (studentRecord != null) {

				Student newStudent = new Student();
				newStudent.setSid(id);//id is primary no need to update
				
				System.out.print("StudentName ::[Old Name is :: " + studentRecord.getName() + "]:  ");
				String newName = br.readLine();
				if (newName == null || newName.equals("")) {
					newStudent.setName(studentRecord.getName());
				} else {
					newStudent.setName(newName);
				}

				System.out.print("StudentEmail ::[Old Email is :: " + studentRecord.getEmail() + "]: ");
				String newEmail = br.readLine();
				if (newEmail == null || newEmail.equals("")) {
					newStudent.setEmail(studentRecord.getEmail());
				} else {
					newStudent.setEmail(newEmail);
				}

				System.out.print("StudentCity ::[Old City is :: " + studentRecord.getCity() + "]:  ");
				String newCity = br.readLine();
				if (newCity == null || newCity.equals("")) {
					newStudent.setCity(studentRecord.getCity());
				} else {
					newStudent.setCity(newCity);
				}

				System.out.print("StudentCountry ::[Old Country is :: " + studentRecord.getCountry() + "]:  ");
				String newCountry = br.readLine();
				if (newCountry == null || newCountry.equals("")) {
					newStudent.setCountry(studentRecord.getCountry());
				} else {
					newStudent.setCountry(newCountry);
				}

				status = studentController.updateById(newStudent);
				if (status.equalsIgnoreCase("success")) {
					System.out.println("Record updated succesfully...");
				} else if (status.equalsIgnoreCase("failure")) {
					System.out.println("Record updation failed...");
				} else {
					System.out.println("Some problem occured...");
				}

			} else
				System.out.println("Record not available for the given id ::" + id);
			break;
		case 4:
			System.out.print("Enter the id:: ");
			id = Integer.parseInt(br.readLine());
			studentController=StudentControllerFactory.getStudentController();
			status = studentController.deleteById(id);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("Record deleted succesfully...");
			} else if (status.equalsIgnoreCase("failure")) {
				System.out.println("Record deletion failed...");
			} else {
				System.out.println("Record not available for the given id to delete...");
			}
			break;
			
			
		case 5:
			System.err.println("Thank you for using this  application");
			System.exit(0);
			
		default:
			System.err.println("Enter valid option");
			break;
		}
		}
		} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
		
		
		

	}

}
