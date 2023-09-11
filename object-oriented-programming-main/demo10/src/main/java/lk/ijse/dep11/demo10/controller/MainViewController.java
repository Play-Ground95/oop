package lk.ijse.dep11.demo10.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainViewController {
    public Spinner<Integer> txtAmount;
    public Button btnDeposit;
    public Button btnWithdraw;
    public Label lblBalance;
    public Button btnPrintPassbook;

    double accountBalance = 5000;
    ArrayList<Transaction> transactionList = new ArrayList<>();

    public void initialize() {
        lblBalance.setText(String.format("Balance: Rs. %,.2f", accountBalance));
        btnDeposit.setDisable(true);
        btnWithdraw.setDisable(true);
        txtAmount.setEditable(true);
        txtAmount.setValueFactory(new SpinnerValueFactory
                .IntegerSpinnerValueFactory(0, 100000, 0, 100));
        txtAmount.valueProperty().addListener(e -> {
            btnDeposit.setDisable(txtAmount.getValue() <= 0);
            btnWithdraw.setDisable(btnDeposit.isDisable());
        });
    }

    public void btnDepositOnAction(ActionEvent actionEvent) {
        Transaction creditTransaction = new Transaction(true,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                accountBalance,
                txtAmount.getValue(),
                accountBalance + txtAmount.getValue());

        accountBalance += txtAmount.getValue();
        lblBalance.setText(String.format("Balance: Rs. %,.2f", accountBalance));
        System.out.println(txtAmount.getValue() + " deposited successfully!");
        txtAmount.getValueFactory().setValue(0);
        transactionList.add(creditTransaction);
    }

    public void btnWithdrawOnAction(ActionEvent actionEvent) {
        Transaction debitTransaction = new Transaction(false,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                accountBalance,
                txtAmount.getValue(),
                accountBalance - txtAmount.getValue());

        double balanceAfterWithdraw = accountBalance - txtAmount.getValue();
        if (balanceAfterWithdraw < 0) {
            System.out.println("Insufficient account balance");
            return;
        }
        accountBalance = balanceAfterWithdraw;
        lblBalance.setText(String.format("Balance: Rs. %,.2f", accountBalance));
        System.out.println(txtAmount.getValue() + " withdrew successfully!");
        txtAmount.getValueFactory().setValue(0);
        transactionList.add(debitTransaction);
    }

    public void btnPrintPassbookOnAction(ActionEvent actionEvent) {
        final String LINE = "+".concat("-".repeat(20)).concat("+")
                .concat("-".repeat(15).concat("+"))
                .concat("-".repeat(15).concat("+"))
                .concat("-".repeat(15).concat("+\n"));
        System.out.printf(LINE);
        System.out.printf("|%-20s|%-15s|%15s|%15s|\n", "DATE TIME", "TRANSACTION", "AMOUNT", "BALANCE");
        System.out.printf(LINE);
        if (!transactionList.isEmpty()) {
            System.out.printf("|%-20s|%-15s|%,15.2f|%,15.2f|\n",
                    "",
                    "OPENING BALANCE",
                    0.0,
                    transactionList.get(0).openingBalance);
        }
        for (Transaction transaction : transactionList) {
            System.out.printf("|%-20s|%-15s|%,15.2f|%,15.2f|\n",
                    transaction.dateTime,
                    transaction.credit ? "CREDIT": "DEBIT",
                    transaction.amount,
                    transaction.endingBalance
            );
        }
        System.out.printf(LINE);
    }
}

class Transaction {
    boolean credit;
    String dateTime;
    double openingBalance;
    double amount;
    double endingBalance;

    public Transaction(boolean credit, String dateTime, double openingBalance, double amount, double endingBalance) {
        super();
        // invisible line
        this.credit = credit;
        this.dateTime = dateTime;
        this.openingBalance = openingBalance;
        this.amount = amount;
        this.endingBalance = endingBalance;
    }
}