package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(OrderLine orderLine) {
        lines.add(orderLine);
    }

    private double getTotal(){
        double total = 0;
        for (OrderLine line : lines)
            total += line.getPrice();
        return total;
    }

    public boolean isEligible() {
        return (getTotal() > 100);
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            printBuffer.append(line.toString() + "\n");

        printBuffer.append("Total: " + getTotal());

        return printBuffer.toString();
    }
}