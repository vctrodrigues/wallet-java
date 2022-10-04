export * from "./components/index.js";
import { Home } from "./pages/home.js";

export default class App {
  pages = {
    Home,
  };

  constructor(name) {
    if (this.pages[name]) {
      this.page = new this.pages[name]();
    }
  }
}
