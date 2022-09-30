import { useClass } from "../hooks/useClass.js";
import { useState } from "../hooks/useState.js";
import { Component } from "./component.js";

export class TransactionButton extends Component {
  constructor(selector) {
    super(selector, "app-transaction-button");

    this.onClick = () => {};
    this.component.click(this.onClick);

    this.active = useState(
      false,
      useClass(this.component, `${this.className}--active`)
    );
  }

  set onClick(onClick) {
    this.component.click(onClick);
    return onClick;
  }

  setActive(active) {
    this.active.value = active;
  }
}
