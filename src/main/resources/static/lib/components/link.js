import { useClass } from "../hooks/useClass.js";
import { useState } from "../hooks/useState.js";
import { Component } from "./component.js";

export class Link extends Component {
  constructor(selector) {
    super(selector, "app-link");
  }
}
