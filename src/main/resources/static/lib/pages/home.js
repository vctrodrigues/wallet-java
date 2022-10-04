import { Form, Input, Button, TransactionButton } from "../components/index.js";
import { Page } from "./page.js";
import { useState } from "../hooks/useState.js";

export class Home extends Page {
  constructor() {
    super("Home");

    this.addPayment = new TransactionButton("#add-payment");
    this.addRevenue = new TransactionButton("#add-revenue");
    this.addTransferency = new TransactionButton("#add-transferency");

    this.typeInput = new Input("#type-input");

    this.addPayment.onClick = () => {
      this.onTransactionTypeSelected("PAYMENT");
    };

    this.addRevenue.onClick = () => {
      this.onTransactionTypeSelected("REVENUE");
    };

    this.addTransferency.onClick = () => {
      this.onTransactionTypeSelected("TRANSFERENCY");
    };

    this.form = new Form(
      "#transaction-form",
      [
        new Input("#title-input"),
        new Input("#value-input"),
        new Input("#type-input"),
      ],
      new Button("#add-button")
    );

    this.transactionType = useState("", (type) => {
      this.form.setDisabled(false);
      switch (type) {
        case "PAYMENT":
          this.addPayment.setActive(true);
          this.addRevenue.setActive(false);
          this.addTransferency.setActive(false);
          this.typeInput.component.val("PAYMENT");
          break;
        case "REVENUE":
          this.addPayment.setActive(false);
          this.addRevenue.setActive(true);
          this.addTransferency.setActive(false);
          this.typeInput.component.val("REVENUE");
          break;
        case "TRANSFERENCY":
          this.addPayment.setActive(false);
          this.addRevenue.setActive(false);
          this.addTransferency.setActive(true);
          this.typeInput.component.val("TRANSFERENCY");
          break;
      }
    });

    this.onLoad();
  }

  onLoad() {
    this.form.setDisabled(true);
  }

  onTransactionTypeSelected(type) {
    this.transactionType.value = type;
  }
}
