package com.richard;
//NOTE: had to change the packages to your name when importing the Packager 2 and 3 JAR files.
//import com.richard.builders.Assembler;
import com.yourname.interfaces.Packager;
import com.yourname.model.Package;
import com.richard.assemblers.MyAssembler;


public class TestAssembler {

	public static void main(String[] args) {
		Packager packager = new MyAssembler();
		Package myPackage = packager.assemblePackage("This is my new content description");
		
		System.out.println(myPackage);

	}

}
