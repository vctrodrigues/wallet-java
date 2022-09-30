export function useClass(component, className) {
  return (state) => {
    if (state) {
      component.addClass(className);
    } else {
      component.removeClass(className);
    }
  };
}
