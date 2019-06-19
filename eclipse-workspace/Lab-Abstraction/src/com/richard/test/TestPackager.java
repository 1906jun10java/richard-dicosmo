package com.richard.test;

import com.richard.builders.Assembler;
import com.richard.interfaces.Packager;
import com.richard.model.Package;

public class TestPackager {

	public static void main(String[] args) {
		Packager packager = new Assembler();
		Package myPackage = packager.assemblePackage();
		
		System.out.println(myPackage);

	}

}
