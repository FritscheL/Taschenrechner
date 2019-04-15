/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Fritschtel.cdi.component;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;

/**
 *
 * @author xaron
 */
public class MyButton extends Button {

    public MyButton(String name,ComponentEventListener<ClickEvent<Button>> listener) {
        super(name, listener);
    }

}
