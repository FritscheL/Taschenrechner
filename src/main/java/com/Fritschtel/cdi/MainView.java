package com.Fritschtel.cdi;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import javax.inject.Inject;

/**
 * The main view contains a simple label element and a template element.
 */
@Route("")
@StyleSheet("styles/styles.css")
@PWA(name = "Project Base for Vaadin Flow with CDI", shortName = "Project Base")
public class MainView extends VerticalLayout {

    @Inject
    private MessageBean messageBean;
    double result = 0;
    String x = "";
    String y = "";
    int operator = 0;
    Label lblResult = new Label("0");

    public MainView() {
        setSizeUndefined();
        addClassName("main-view");

        add(lblResult);
        VerticalLayout buttonline = new VerticalLayout();

        Button btnClear = new Button("C", this::clickBtnClear);
        Button btnDelete = new Button("<--", this::clickBtnDelete);
        Button btn1 = new Button("1", this::clickBtn1);
        Button btn2 = new Button("2", this::clickBtn2);
        Button btn3 = new Button("3", this::clickBtn3);
        Button btn4 = new Button("4", this::clickBtn4);
        Button btn5 = new Button("5", this::clickBtn5);
        Button btn6 = new Button("6", this::clickBtn6);
        Button btn7 = new Button("7", this::clickBtn7);
        Button btn8 = new Button("8", this::clickBtn8);
        Button btn9 = new Button("9", this::clickBtn9);
        Button btn0 = new Button("0", this::clickBtn0);
        Button btnNegative = new Button("+/-", this::clickBtnNegative);
        Button btnComma = new Button(",", this::clickBtnComma);
        Button btnPlus = new Button("+", this::clickBtnPlus);
        Button btnMinus = new Button("-", this::clickBtnMinus);
        Button btnTimes = new Button("x", this::clickBtnTimes);
        Button btnThrough = new Button("/", this::clickBtnThrough);
        Button btnEqual = new Button("=", this::clickBtnEqual);

        HorizontalLayout row1 = new HorizontalLayout();
        HorizontalLayout row2 = new HorizontalLayout();
        HorizontalLayout row3 = new HorizontalLayout();
        HorizontalLayout row4 = new HorizontalLayout();
        HorizontalLayout row5 = new HorizontalLayout();

        row1.setWidth("336px");
        row1.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        add(buttonline);
        buttonline.add(row1, row2, row3, row4, row5);
        row1.add(btnClear, btnDelete, btnThrough);
        row2.add(btn7, btn8, btn9, btnTimes);
        row3.add(btn4, btn5, btn6, btnMinus);
        row4.add(btn1, btn2, btn3, btnPlus);
        row5.add(btnNegative, btn0, btnComma, btnEqual);

        buttonline.setPadding(false);
        buttonline.setMargin(true);
        buttonline.setSpacing(true);
        row1.setPadding(false);
        row1.setMargin(true);
        row1.setSpacing(true);
        row2.setPadding(false);
        row2.setMargin(true);
        row2.setSpacing(true);
        row3.setPadding(false);
        row3.setMargin(true);
        row3.setSpacing(true);
        row4.setPadding(false);
        row4.setMargin(true);
        row4.setSpacing(true);
        row5.setPadding(false);
        row5.setMargin(true);
        row5.setSpacing(true);

    }

    private void clickBtnClear(ClickEvent<Button> event) {
        x = "";
    }
    
    private void clickBtnDelete(ClickEvent<Button> event) {
        Notification.show(x);
        Notification.show(y);
    }
    
    private void clickBtn1(ClickEvent<Button> event) {
        x = x + "1";
    } 
    
    private void clickBtn2(ClickEvent<Button> event) {
        x = x + "2";
    }
    
    private void clickBtn3(ClickEvent<Button> event) {
        x = x + "3";
    }
    
    private void clickBtn4(ClickEvent<Button> event) {
        x = x + "4";
    }
    
    private void clickBtn5(ClickEvent<Button> event) {
        x = x + "5";
    }
    
    private void clickBtn6(ClickEvent<Button> event) {
        x = x + "6";
    }
    
    private void clickBtn7(ClickEvent<Button> event) {
        x = x + "7";
    }
    
    private void clickBtn8(ClickEvent<Button> event) {
        x = x + "8";
    }
    
    private void clickBtn9(ClickEvent<Button> event) {
        x = x + "9";
    }
    
    private void clickBtn0(ClickEvent<Button> event) {
        x = x + "0";
    }
    
    private void clickBtnNegative(ClickEvent<Button> event) {
        x = x + "-";
    }
    
    private void clickBtnComma(ClickEvent<Button> event) {
        x = x + ".";
    }
    
    private void clickBtnPlus(ClickEvent<Button> event) {
        y = x;
        x = "";
        operator = 1;
    }
    
    private void clickBtnMinus(ClickEvent<Button> event) {
        y = x;
        x = "";
        operator = 2;
    }
    
    private void clickBtnTimes(ClickEvent<Button> event) {
        y = x;
        x = "";
        operator = 3;
    }
    
    private void clickBtnThrough(ClickEvent<Button> event) {
        y = x;
        x = "";
        operator = 4;
    }
    
    private void clickBtnEqual(ClickEvent<Button> event) {
        if (operator==1) {
            result = Double.parseDouble(y) + Double.parseDouble(x);
            } else if (operator==2) {
                result = Double.parseDouble(y) - Double.parseDouble(x); 
                } else if (operator==3) {
                    result = Double.parseDouble(y) * Double.parseDouble(x);
                    } else if (operator==4) {
                        result = Double.parseDouble(y) / Double.parseDouble(x);
                        }
        lblResult.setText(""+result);
        }
        
    }

