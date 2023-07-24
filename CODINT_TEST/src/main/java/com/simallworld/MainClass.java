package com.simallworld;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class MainClass {
	public static void main(String[] args) {
		TransactionDataFetcher TransactionDataFetcher = new TransactionDataFetcher();

		// getTotalTransactionAmount
		double totalTransactionAmount = TransactionDataFetcher.getTotalTransactionAmount();
		// print totalTransaction Amount
		System.out.println(" totalTransaction Amount : " + totalTransactionAmount);
		
		

		// getTotalTransactionAmountSentBy
		double totalTransactionAmountSentBySpecificUser = TransactionDataFetcher
				.getTotalTransactionAmountSentBy("Grace Burgess");
		// print totalTransaction Amount sent by user
		System.out.println(
				" totalTransaction Amount sent by Specific User : " + totalTransactionAmountSentBySpecificUser);
		
		

		// getMaxTransactionAmount
		double getMaxTransactionAmount = TransactionDataFetcher.getMaxTransactionAmount();
		// print Maximum Transaction Amount
		System.out.println(" Maximum Transaction Amount is  : " + getMaxTransactionAmount);
		
		
		

		// countUniqueClients
		long uniqueClients = TransactionDataFetcher.countUniqueClients();
		// print uniqueClients
		System.out.println("uniqueClients are   : " + uniqueClients);
		
		

		// hasOpenComplianceIssues
		boolean isIssue = TransactionDataFetcher.hasOpenComplianceIssues("Billy Kimber");
		// print hasOpenComplianceIssues
		System.out.println(" hasOpenComplianceIssues    : " + isIssue);
		
		

		// getTransactionsByBeneficiaryName
		Map<String, List<Transaction>> map = TransactionDataFetcher.getTransactionsByBeneficiaryName();
		// print hasOpenComplianceIssues
		System.out.println(" TransactionsByBeneficiaryName    : " + map);
		
		
		// unsolvedIssueIds
		Set<Integer> unsolvedIssueIds = TransactionDataFetcher.getUnsolvedIssueIds();
		// print hasOpenComplianceIssues
		System.out.println(" unsolvedIssueIds    : " + unsolvedIssueIds);
		
		

		// getAllSolvedIssueMessages
		List<String> issueMessagelist = TransactionDataFetcher.getAllSolvedIssueMessages();
		// print hasOpenComplianceIssues
		System.out.println(" SolvedIssueMessagelist    : " + issueMessagelist);
		
		
		// getTop3TransactionsByAmount
		List<Transaction> top3TransationByAmount = TransactionDataFetcher.getTop3TransactionsByAmount();
		// print top3TransationByAmount 
		System.out.println(" top3TransationByAmount    : " + top3TransationByAmount);


	

		// getTopSender
		Optional<String> senderWithHighestAmount = TransactionDataFetcher.getTopSender();
		// print senderWithHighestAmount
		System.out.println(" senderWithHighestAmount    : " + senderWithHighestAmount);
		

	
		
	}
}
