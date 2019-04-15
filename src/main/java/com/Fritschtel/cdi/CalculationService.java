package com.Fritschtel.cdi;

import com.vaadin.cdi.annotation.VaadinSessionScoped;
import javax.enterprise.context.ApplicationScoped;

/**
 * Data provider bean scoped for each user session.
 */
@ApplicationScoped
public class CalculationService {

    public double add(double v1, double v2) {
        return v1 + v2;
    }
    public double sub(double v1, double v2) {
        return v1 - v2;
    }
    public double multi(double v1, double v2) {
        return v1 * v2;
    }
    public double div(double v1, double v2) {
        return v1 / v2;
    }
}
