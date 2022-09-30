import { useClass } from "../hooks/useClass.js";
import { useState } from "../hooks/useState.js";
import { Component } from "./component.js";

export class Button extends Component {
  constructor(selector) {
    super(selector, "app-button");

    this.disabled = useState(
      false,
      useClass(this.component, `${this.className}--disabled`)
    );
  }

  setDisabled(disabled) {
    this.disabled.value = disabled;
    this.component.prop("disabled", disabled);
  }
}
