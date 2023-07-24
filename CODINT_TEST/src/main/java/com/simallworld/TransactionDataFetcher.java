package com.simallworld;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class TransactionDataFetcher {

	/**
	 * Returns the sum of the amounts of all transactions
	 */

	ObjectMapper objectMapper = new ObjectMapper();
	File jsonFile = new File("F:\\springwork\\CODINT_TEST\\transactions.json");
	double totalTransactionAmount;

	public double getTotalTransactionAmount() {
		// throw new UnsupportedOperationException();

		try {

			List<Transaction> transactionObj = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
			});

			// Iterate through each data object in the list
			for (Transaction tranObj : transactionObj) {

				totalTransactionAmount += tranObj.getAmount();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return totalTransactionAmount;

	}

	/**
	 * Returns the sum of the amounts of all transactions sent by the specified
	 * client
	 */
	public double getTotalTransactionAmountSentBy(String senderFullName) {
		// throw new UnsupportedOperationException();
		double totalTransactionAmount1 = 0.0;
		try {

			List<Transaction> transactionObj = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
			});

			// Iterate through each data object in the list
			for (Transaction tranObj : transactionObj) {

				String name = tranObj.getSenderFullName();
				if (name.equals(senderFullName)) {
					totalTransactionAmount1 += tranObj.getAmount();
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return totalTransactionAmount1;

	}

	/**
	 * Returns the highest transaction amount
	 */
	public double getMaxTransactionAmount() {
		// throw new UnsupportedOperationException();
		double highestAmount = Double.MIN_VALUE;

		try {

			List<Transaction> transactionObj = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
			});

			// Iterate through each data object in the list
			for (Transaction tranObj : transactionObj) {

				// totalTransactionAmount += tranObj.getAmount();
				if (tranObj.getAmount() > highestAmount) {
					highestAmount = tranObj.getAmount();
				}
			}

			System.out.println();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return highestAmount;
	}

	/**
	 * Counts the number of unique clients that sent or received a transaction
	 */
	public long countUniqueClients() {
		// throw new UnsupportedOperationException();
		Set clients = null;

		try {

			List<Transaction> transactionObj = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
			});

			clients = new HashSet<Object>();
			// Iterate through each data object in the list
			for (Transaction tranObj : transactionObj) {
				clients.add(tranObj.getSenderFullName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return clients.size();

	}

	/**
	 * Returns whether a client (sender or beneficiary) has at least one transaction
	 * with a compliance issue that has not been solved
	 */
	public boolean hasOpenComplianceIssues(String clientFullName) {
		// throw new UnsupportedOperationException();
		Boolean isIssue = false;
		try {

			List<Transaction> transactionObj = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
			});

			// Iterate through each data object in the list
			for (Transaction tranObj : transactionObj) {

				if (tranObj.getSenderFullName().equals(clientFullName) && !tranObj.isIssueSolved()) {
					// if (!tranObj.isIssueSolved()) {
					return isIssue = true;

					// }
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return isIssue;

	}

	/**
	 * Returns all transactions indexed by beneficiary name
	 */
	public Map<String, List<Transaction>> getTransactionsByBeneficiaryName() {
		// throw new UnsupportedOperationException();

		Map<String, List<Transaction>> transactionsByBeneficiary = new HashMap<>();

		try {

			List<Transaction> transactionObj = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
			});

			// Iterate through each data object in the list
			for (Transaction tranObj : transactionObj) {
				String beneficiaryFullName = tranObj.getBeneficiaryFullName();
				Transaction transaction = new Transaction(tranObj.getMtn(), tranObj.getAmount(),
						tranObj.getSenderFullName(), tranObj.getSenderAge(), tranObj.getBeneficiaryFullName(),
						tranObj.getBeneficiaryAge(), tranObj.getIssueId(), tranObj.isIssueSolved(),
						tranObj.getIssueMessage());

				List<Transaction> tranList = new ArrayList();
				tranList.add(transaction);

				transactionsByBeneficiary.put(beneficiaryFullName, tranList);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return transactionsByBeneficiary;
	}

	/**
	 * Returns the identifiers of all open compliance issues
	 */
	public Set<Integer> getUnsolvedIssueIds() {
		// throw new UnsupportedOperationException();
		Set<Integer> unsolvedIssueIds = new HashSet<>();
		try {

			List<Transaction> transactionObj = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
			});

			// Iterate through each data object in the list
			for (Transaction tranObj : transactionObj) {

				if (tranObj.isIssueSolved() == false) {
					unsolvedIssueIds.add(tranObj.getIssueId());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return unsolvedIssueIds;
	}

	/**
	 * Returns a list of all solved issue messages
	 */
	public List<String> getAllSolvedIssueMessages() {
		// throw new UnsupportedOperationException();

		List<String> solvedIssueMessageList = new ArrayList<>();
		try {

			List<Transaction> transactionObj = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
			});

			// Iterate through each data object in the list
			for (Transaction tranObj : transactionObj) {

				if (tranObj.isIssueSolved() == true) {
					solvedIssueMessageList.add(tranObj.getIssueMessage());
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return solvedIssueMessageList;

	}

	/**
	 * Returns the 3 transactions with the highest amount sorted by amount
	 * descending
	 */
	public List<Transaction> getTop3TransactionsByAmount() {
		// throw new UnsupportedOperationException();
		List<Transaction> transactions = new ArrayList<>();

		try {

			List<Transaction> transactionObj = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
			});

			// Iterate through each data object in the list
			for (Transaction tranObj : transactionObj) {

				double transactionAmount = tranObj.getAmount();
				transactions.add(new Transaction(tranObj.getMtn(), tranObj.getAmount(), tranObj.getSenderFullName(),
						tranObj.getSenderAge(), tranObj.getBeneficiaryFullName(), tranObj.getBeneficiaryAge(),
						tranObj.getIssueId(), tranObj.isIssueSolved(), tranObj.getIssueMessage()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Collections.sort(transactions, new Comparator<Transaction>() {
			@Override
			public int compare(Transaction t1, Transaction t2) {
				return Double.compare(t2.getAmount(), t1.getAmount());
			}
		});

		int numTransactionsToGet = Math.min(3, transactions.size());
		return transactions.subList(0, numTransactionsToGet);

	}

	/**
	 * Returns the senderFullName of the sender with the most total sent amount
	 */
	public Optional<String> getTopSender() {
		// throw new UnsupportedOperationException();

		Map<String, Double> senderTotalAmounts = new HashMap<>();

		try {

			List<Transaction> transactionObj = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
			});

			// Iterate through each data object in the list
			for (Transaction tranObj : transactionObj) {
				String senderFullName = tranObj.getSenderFullName();
				double amount = tranObj.getAmount();

				senderTotalAmounts.put(senderFullName, senderTotalAmounts.getOrDefault(senderFullName, 0.0) + amount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Find the sender with the highest total amount
		String senderWithHighestAmount = null;
		double highestAmount = 0.0;
		for (Map.Entry<String, Double> entry : senderTotalAmounts.entrySet()) {
			if (entry.getValue() > highestAmount) {
				highestAmount = entry.getValue();
				senderWithHighestAmount = entry.getKey();
			}
		}

//        Optional<String> longNameOpt = someList.stream().max(Comparator.comparingInt(String::length));
//        return longNameOpt.orElse("not present");
		return Optional.ofNullable(senderWithHighestAmount);
	}

}
