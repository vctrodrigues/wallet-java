import { Form, Input, Button, Dialog } from "../components/index.js";
import { Page } from "./page.js";
import { useState } from "../hooks/useState.js";

export class Box extends Page {
  constructor() {
    super("Box");

    this.createForm = new Form(
      "#create-form",
      ["#name-input", "#value-input"],
      new Button("#create-create-button")
    );

    this.createDialog = new Dialog(
      "#create-dialog",
      new Button("#create-cancel-button"),
      new Button("#create-create-button"),
      new Button("#open-create")
    );
    this.createDialog.onConfirm(this.onCreate);

    this.onLoad();
  }

  onLoad() {
    this.form.setDisabled(true);
  }

  onTransactionTypeSelected(type) {
    this.transactionType.value = type;
  }

  onCreate() {
    this.createForm.component.submit();
  }
}
