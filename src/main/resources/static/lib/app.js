export * from "./components/index.js";
import { Home } from "./pages/home.js";

export default class App {
  pages = {
    Home,
  };

  constructor(name) {
    this.page = new this.pages[name]();
  }
}
