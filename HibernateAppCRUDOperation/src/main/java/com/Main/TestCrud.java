package com.Main;

import com.Model.StudentInfo;

public class TestCrud {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

		/*
		 * // CREATE StudentInfo info = new StudentInfo(4,"prabha","donlee","subhani");
		 * dao.save(info);
		 */

        // READ
        StudentInfo s2 = dao.get(4);
        System.out.println("Name: " + s2.getFirstname() + " " + s2.getLastname());

        // UPDATE
        s2.setMiddlename("sandeep");
        dao.update(s2);

        // DELETE
       // dao.delete(2);
    }
}
