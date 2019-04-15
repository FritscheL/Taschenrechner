/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Fritschtel.cdi.enums;

/**
 *
 * @author xaron
 */
public enum Operator {
    ADD("+"), SUB("-"), MULTI("x"), DIV("/"), NO("");
    public String typeOfCalculation;

    private Operator(String compute) {
        this.typeOfCalculation = compute;
    }

    @Override
    public String toString() {
        return typeOfCalculation;
    }
}
