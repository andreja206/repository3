package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import factory.data.Data;
import factory.data.calculate.Calculate;
import factory.data.read.implementation.A3Strategy;
import factory.data.read.implementation.A4Strategy;
import property.PropertyParser;
import property.data.PropertyDataStructure;

class CalculateTest
{
	private static HashMap<String,PropertyDataStructure> property = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		property = PropertyParser.parseToHashMap();
		
	}
	
	void djeljenjeTest()
	{
		
		Calculate calc=new Calculate(property.get("dijeljenje"));
		A4Strategy str=new A4Strategy();
		
		List<Data>calculated=calc.calculate(str.readFile(property.get("dijeljenje").path().toString()));
		List<Data>testData=property.get("dijeljenje").testData();
		
		for(int i=0;i<testData.size();i++) 
		{
			assertEquals((double)testData.get(i).getValue(),(double)calculated.get(i).getValue());
		}
		
	}
	
		
	
	
}
