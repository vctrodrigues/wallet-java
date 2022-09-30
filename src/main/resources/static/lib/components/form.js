import { useClass } from "../hooks/useClass.js";
import { useState } from "../hooks/useState.js";
import { Component } from "./component.js";

export class Form extends Component {
  constructor(selector, inputs, submit) {
    super(selector, "app-form");

    this.inputs = inputs;
    this.submit = submit;

    this.disabled = useState(
      false,
      useClass(this.component, `${this.className}--disabled`)
    );
  }

  setDisabled(disabled) {
    this.disabled.value = disabled;
    this.submit.setDisabled(disabled);

    for (const input of this.inputs) {
      input.setDisabled(disabled);
    }

    this.component.prop("disabled", disabled);
  }
}
