import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import java.util.*;

public class PolicyEvaluatorTest {

	@Test
	public void evaluatePolicyTest()
	{
		//Dummy User Input
		Map<String, String> dummyInput = new HashMap<String, String>();
		dummyInput.put("personName","Dhiraj");
		dummyInput.put("worksFor","USC");
		dummyInput.put("needsAccessTo","Router");
		dummyInput.put("requestedTime","11");
		
		//Test Policy
		PolicyParser policyParser = PolicyParser.getInstance();
		List<Policy> dummyPolicy = policyParser.parse("src/main/resources/policy_test.json");
		PolicyEvaluator policyEvaluator = new PolicyEvaluator();
		assertEquals(policyEvaluator.evaluatePolicy(dummyInput, dummyPolicy).endsWith("RequestApprovalFromOwner"),true);
		
	}
	
	@Test
	public void incorrectInputFieldsTest()
	{
		//Dummy User Input
		Map<String, String> dummyInput = new HashMap<String, String>();
		//incorrect
		dummyInput.put("PersonName","Dhiraj");
		dummyInput.put("worksFor","USC");
		dummyInput.put("needsAccessTo","Router");
		dummyInput.put("requestedTime","11");
		
		//Test Policy
		PolicyParser policyParser = PolicyParser.getInstance();
		List<Policy> dummyPolicy = policyParser.parse("src/main/resources/policy_test.json");
		PolicyEvaluator policyEvaluator = new PolicyEvaluator();
		assertEquals(policyEvaluator.evaluatePolicy(dummyInput, dummyPolicy) == null,true);		
		
	}
	
	

}
