export * from "./components/index.js";
import { Home } from "./pages/home.js";
import { Box } from "./pages/box.js";
import { Expense } from "./pages/expense.js";

export default class App {
  pages = {
    Home,
    Box,
    Expense,
  };

  constructor(name) {
    if (this.pages[name]) {
      this.page = new this.pages[name]();
    }
  }
}
