package com.richard.assemblers;

import com.yourname.interfaces.Packager;
import com.yourname.model.Color;
import com.yourname.model.Content;
import com.yourname.model.Dimension;
import com.yourname.model.Package;

public class MyAssembler implements Packager{
	private static int packageCount = 0;
	
	public MyAssembler() {
		packageCount++;
	}
	
	@Override
	public Package assemblePackage() {
		Content content = new Content(packageCount, "New Grey Package: " + packageCount);
		Color color = new Color(125, 125, 125);
		Dimension dimension = new Dimension(5,5,5);
		
		return new Package(content, color, dimension);
	}
}
