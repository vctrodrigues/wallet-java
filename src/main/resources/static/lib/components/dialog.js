import { useClass } from "../hooks/useClass.js";
import { useState } from "../hooks/useState.js";
import { Component } from "./component.js";

export class Dialog extends Component {
  constructor(selector, cancel, confirm, trigger) {
    super(selector, "app-dialog");

    this.cancel = cancel;
    this.confirm = confirm;

    this.trigger = trigger;
    this.trigger.component.click(() => {
      this.onOpen();
    });

    this.cancel.component.click(() => this.onClose());
  }

  set onConfirm(onConfirm) {
    this.confirm.onClick = onConfirm;
  }

  set onCancel(onCancel) {
    this.cancel.onClick = onCancel;
  }

  onOpen() {
    this.component.fadeIn();
  }

  onClose() {
    this.component.fadeOut();
  }
}
