import java.util.*;

public class PolicyEvaluator {

	/*
	 * Evaluates User Input against the policies sequentially.
	 * Also, maintains log of policies executed so far
	 */
	public String evaluatePolicy(Map<String,String> userInput, List<Policy> policies)
	{
		try {
		String resultLog = "";
		String result = "";
		String userName = userInput.get("personName");
		String worksFor = userInput.get("worksFor");
		String needsAccessTo = userInput.get("needsAccessTo");
		long requestedTime = Long.parseLong(userInput.get("requestedTime"));
		
		for(Policy policy: policies)
		{
				
			if(userName.equals(policy.getPersonName()) && 
			   worksFor.equals(policy.getWorksFor()) && 
			   needsAccessTo.equals(policy.getNeedsAccessTo()) &&
			   compareRequestedTime(requestedTime, policy.getRequestedTime()))
			{
						result = policy.getPolicyAction();
						resultLog += policy.getPolicyName() + " is satisfied" + "\n";

						if(policy.getStopProcessing().equalsIgnoreCase("Yes"))
							break;						
			}
			else
				resultLog += policy.getPolicyName() + " is not satisfied" + "\n";
		}
		
		return resultLog + result;
		}
		catch(Exception e)
		{
			System.out.println("[evaluatePolicy]");
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	boolean compareRequestedTime(long requestedTime, Map<String,String> policyMap)
	{
		String policySign = policyMap.get("sign");
		long policyTime = Long.parseLong(policyMap.get("val"));
		
		if(policySign.equals("<"))
			return requestedTime < policyTime;
		
		if(policySign.equals(">"))
			return requestedTime > policyTime;
			
		if(policySign.equals("=="))
			return requestedTime == policyTime;
		
		return false;
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		PolicyEvaluator policyEvaluator = new PolicyEvaluator();
		PolicyParser policyParser = PolicyParser.getInstance();
		ReaderWriterFactory readWriteFactory = new ReaderWriterFactory();
		
		Reader reader = readWriteFactory.getReader(args);
		Writer writer = readWriteFactory.getWriter(args);
		
		String policyPath = args[0];
		
		List<Policy> policy = policyParser.parse(policyPath);
		Map<String,String> inputUser = reader.read();
		
		System.out.println(inputUser);
		String policyOutput = policyEvaluator.evaluatePolicy(inputUser, policy);
		writer.write(policyOutput);
		
		}
		catch(Exception e)
		{
			System.out.println("[Policy Evaluator]");
			System.out.println(e.getMessage());
		}
		
	}

}
