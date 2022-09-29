export class Component {
  constructor(selector, className) {
    this.className = className;
    this.selector = selector;
    this.component = $(selector);
    this.state = {};

    this.component.addClass(className);

    this.onClick = () => {};
    this.onSubmit = () => {};
  }

  set onClick(onClick) {
    this.component.click(onClick);
    return onClick;
  }

  set onSubmit(onSubmit) {
    this.component.submit(onSubmit);
    return onSubmit;
  }
}
