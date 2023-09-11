package lk.ijse.dep11.demo11.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep11.demo11.tm.CartItem;

import java.util.ArrayList;

public class OrderSceneController {
    public TextField txtCode;
    public TextField txtDescription;
    public TextField txtStock;
    public TextField txtBuyingPrice;
    public TextField txtSellingPrice;
    public Spinner<Integer> txtQty;
    public Button btnAdd;
    public TableView<CartItem> tblCart;
    public Button btnNewOrder;
    public Label lblTotal;
    public Label lblProfit;

    ArrayList<Item> itemList = new ArrayList<>();

    public void initialize(){
        Item item1 = new Item("4792210125234",
                "Atlas Whiteboard Marker Blue Pen",
                5, 150, 170);

        Item item2 = new Item("4792210112753",
                "Atlas Whiteboard Marker Black Pen",
                20, 160, 180);

        itemList.add(item1);
        itemList.add(item2);

        txtQty.setDisable(true);
        btnAdd.setDisable(true);
        btnAdd.setDefaultButton(true);
        txtQty.setEditable(true);
        txtQty.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1, 1));
        txtQty.valueProperty().addListener(e -> {
            btnAdd.setDisable(txtQty.getValue() > Integer.parseInt(txtStock.getText()));
        });

        tblCart.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tblCart.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblCart.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblCart.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
        tblCart.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    public void txtCodeOnAction(ActionEvent actionEvent) {
        String inputCode = txtCode.getText().strip();
        for (Item item : itemList) {
            if (item.barCode.equals(inputCode)){
                txtDescription.setText(item.description);
                txtStock.setText(item.stock + "");
                txtBuyingPrice.setText(item.buyingPrice + "");
                txtSellingPrice.setText(item.sellingPrice + "");
                if (item.stock > 0){
                    btnAdd.setDisable(false);
                    txtQty.setDisable(false);
                    txtQty.requestFocus();
                }else{
                    btnAdd.setDisable(true);
                    txtQty.setDisable(true);
                    txtCode.selectAll();
                }
                return;
            }
        }
        new Alert(Alert.AlertType.ERROR, "Item does not exist").show();
        txtCode.selectAll();
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        ObservableList<CartItem> cartItemList = tblCart.getItems();

        Item selectedItem = null;
        for (Item item : itemList) {
            if (item.barCode.equals(txtCode.getText())){
                selectedItem = item;
                break;
            }
        }

        CartItem cartItem = null;
        for (CartItem cItem : cartItemList) {
            if (cItem.getCode().equals(selectedItem.barCode)){
                cartItem = cItem;
                break;
            }
        }

        if (cartItem == null) {
            cartItem = new CartItem(txtCode.getText(),
                    txtDescription.getText(),
                    txtQty.getValue(),
                    Double.parseDouble(txtSellingPrice.getText()),
                    txtQty.getValue() * Double.parseDouble(txtSellingPrice.getText()));
            cartItemList.add(cartItem);
        }else{
            cartItem.setQty(cartItem.getQty() + txtQty.getValue());
            cartItem.setTotal(cartItem.getQty() * cartItem.getPrice());
            tblCart.refresh();
        }

        selectedItem.stock -= txtQty.getValue();
        calculateTotalAndProfit();

        txtCode.clear();
        txtDescription.clear();
        txtQty.getValueFactory().setValue(1);
        txtStock.clear();
        txtBuyingPrice.clear();
        txtSellingPrice.clear();
        txtQty.setDisable(true);
        btnAdd.setDisable(true);
        txtCode.requestFocus();
    }

    void calculateTotalAndProfit(){
        ObservableList<CartItem> cartItemList = tblCart.getItems();

        double total = 0;
        double profit = 0;
        for (CartItem cartItem : cartItemList) {
            for (Item item : itemList) {
                if (item.barCode.equals(cartItem.getCode())){
                   profit += item.getProfit() * cartItem.getQty();
                   break;
                }
            }
            total += cartItem.getTotal();
        }

        lblTotal.setText(String.format("Total: Rs. %,.2f", total));
        lblProfit.setText(String.format("Profit: Rs. %,.2f", profit));
    }

    public void btnNewOrderOnAction(ActionEvent actionEvent) {
        txtCode.clear();
        txtDescription.clear();
        txtQty.getValueFactory().setValue(1);
        txtStock.clear();
        txtBuyingPrice.clear();
        txtSellingPrice.clear();
        txtQty.setDisable(true);
        btnAdd.setDisable(true);
        txtCode.requestFocus();
        tblCart.getItems().clear();
        lblTotal.setText("Total: Rs. 0.00");
        lblProfit.setText("Profit: Rs. 0.00");
    }
}

class Item {
    String barCode;
    String description;
    int stock;
    double buyingPrice;
    double sellingPrice;

    public Item(String barCode, String description, int stock, double buyingPrice, double sellingPrice) {
        this.barCode = barCode;
        this.description = description;
        this.stock = stock;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }

    double getProfit(){
        return (sellingPrice - buyingPrice);
    }
}
