import { Form, Button, Dialog, Link } from "../components/index.js";
import { Page } from "./page.js";

export class Expense extends Page {
  constructor() {
    super("Expense");

    this.createForm = new Form(
      "#create-form",
      ["#name-input", "day-input", "#value-input"],
      new Button("#create-create-button")
    );

    this.createDialog = new Dialog(
      "#create-dialog",
      new Button("#create-cancel-button"),
      new Button("#create-create-button"),
      new Button("#open-create")
    );
    this.createDialog.onConfirm = () => this.onCreate();

    this.deleteForm = new Form(
      "#delete-form",
      [],
      new Button("#delete-confirm-button")
    );

    this.deleteLink = new Link("#open-delete");

    this.deleteDialog = new Dialog(
      "#delete-dialog",
      new Button("#delete-cancel-button"),
      new Button("#delete-confirm-button"),
      this.deleteLink
    );

    this.deleteLink.component.click(() => {
      console.log(`hi`);
      this.deleteDialog.onOpen();
    });

    this.deleteDialog.onConfirm = () => this.onDelete();

    this.onLoad();
  }

  onLoad() {
    this.createDialog.onClose();
    this.deleteDialog.onClose();
  }

  onCreate() {
    this.createForm.component.submit();
  }
}
