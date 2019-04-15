package com.Fritschtel.cdi;

import com.Fritschtel.cdi.component.MyButton;
import com.Fritschtel.cdi.component.MyVerticalLayout;
import com.Fritschtel.cdi.component.MyHorizontalLayout;
import com.Fritschtel.cdi.enums.Operator;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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
    private CalculationService calculationService;

    private Operator operator;

    double result = 0;
    String x = "";
    String y = "";
    Label lblResult = new Label("");

    public MainView() {
        setSizeUndefined();
        addClassName("main-view");
        add(lblResult);

        operator = Operator.NO;

        MyVerticalLayout buttonlines = new MyVerticalLayout();

        Button btnClear = new Button("C", this::clickBtnClear);
        Button btnDelete = new Button("<--", this::clickBtnDelete);
//        MyButton btn = new MyButton("sdfg", this::clickBtn1);
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

        MyHorizontalLayout row1 = new MyHorizontalLayout();
        MyHorizontalLayout row2 = new MyHorizontalLayout();
        MyHorizontalLayout row3 = new MyHorizontalLayout();
        MyHorizontalLayout row4 = new MyHorizontalLayout();
        MyHorizontalLayout row5 = new MyHorizontalLayout();

        row1.setWidth("336px");
        row1.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        add(buttonlines);
        buttonlines.add(row1, row2, row3, row4, row5);
        row1.add(btnClear, btnDelete, btnThrough);
        row2.add(btn7, btn8, btn9, btnTimes);
        row3.add(btn4, btn5, btn6, btnMinus);
        row4.add(btn1, btn2, btn3, btnPlus);
        row5.add(btnNegative, btn0, btnComma, btnEqual);
    }

    private void clickBtnClear(ClickEvent<Button> event) {
        x = "";
        y = "";
        lblResult.setText("");
    }

    private void clickBtnDelete(ClickEvent<Button> event) {
        x = x.substring(0, x.length() - 1);

        if (y == "") {
            lblResult.setText(x);
        } else {
            switch (operator) {

                case ADD:
                    lblResult.setText(y + "+" + x);
                    break;

                case SUB:
                    lblResult.setText(y + "-" + x);
                    break;

                case MULTI:
                    lblResult.setText(y + "x" + x);
                    break;

                case DIV:
                    lblResult.setText(y + "/" + x);
                    break;
            }
        }
        //Notification.show(x);
        //Notification.show(y);
    }

    private void updateResult() {
        lblResult.setText(y + operator + x);
    }

    private void clickBtn1(ClickEvent<Button> event) {
        x = x + "1";
        updateResult();
    }

    private void clickBtn2(ClickEvent<Button> event) {
        x = x + "2";
        updateResult();
    }

    private void clickBtn3(ClickEvent<Button> event) {
        x = x + "3";
        updateResult();
    }

    private void clickBtn4(ClickEvent<Button> event) {
        x = x + "4";
        updateResult();
    }

    private void clickBtn5(ClickEvent<Button> event) {
        x = x + "5";
        updateResult();
    }

    private void clickBtn6(ClickEvent<Button> event) {
        x = x + "6";
        updateResult();
    }

    private void clickBtn7(ClickEvent<Button> event) {
        x = x + "7";
        updateResult();
    }

    private void clickBtn8(ClickEvent<Button> event) {
        x = x + "8";
        updateResult();
    }

    private void clickBtn9(ClickEvent<Button> event) {
        x = x + "9";
        updateResult();
    }

    private void clickBtn0(ClickEvent<Button> event) {
        x = x + "0";
        updateResult();
    }

    private void clickBtnNegative(ClickEvent<Button> event) {
        x = x + "-";
        updateResult();
    }

    private void clickBtnComma(ClickEvent<Button> event) {
        x = x + ",";
        updateResult();
    }

    public void clickBtnPlus(ClickEvent<Button> event) {
        y = x;
        x = "";
        operator = Operator.ADD;
        updateResult();
    }

    public void clickBtnMinus(ClickEvent<Button> event) {
        y = x;
        x = "";
        operator = Operator.SUB;
        updateResult();
    }

    public void clickBtnTimes(ClickEvent<Button> event) {
        y = x;
        x = "";
        operator = Operator.MULTI;
        updateResult();
    }

    public void clickBtnThrough(ClickEvent<Button> event) {
        y = x;
        x = "";
        operator = Operator.DIV;
        updateResult();
    }

    private void clickBtnEqual(ClickEvent<Button> event) {
        x = x.replace(',', '.');
        y = y.replace(',', '.');

        double an = Double.parseDouble(y);
        double bn = Double.parseDouble(x);

        switch (operator) {
            case NO:
                Notification.show("Kein Operator ausgewählt!");
                break;

            case ADD:
                result = calculationService.add(an, bn);
                break;

            case SUB:
                result = calculationService.sub(an, bn);
                break;

            case MULTI:
                result = calculationService.multi(an, bn);
                break;

            case DIV:
                result = calculationService.div(an, bn);
                break;
        }
        String finalResult = (Double.toString(result));
        finalResult = finalResult.replace('.', ',');
        lblResult.setText("" + finalResult);

    }

}
