export function useState(defaultValue, watcher) {
  return {
    _value: defaultValue,

    set value(value) {
      if (watcher) {
        watcher(value, this._value);
      }

      this._value = value;
    },

    get value() {
      return this._value;
    },
  };
}
