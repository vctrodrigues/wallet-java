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

    this.deleteLink = new Link(".open-delete");

    this.deleteDialog = new Dialog(
      "#delete-dialog",
      new Button("#delete-cancel-button"),
      new Button("#delete-confirm-button"),
      this.deleteLink
    );

    this.deleteLink.onClick = (e) => {
      const component = $(e.target);
      const expenseId = component.attr("data-id");
      const accountId = component.attr("data-account-id");

      this.deleteForm.component.attr(
        "action",
        `/expense/delete/${accountId}/${expenseId}`
      );
    };

    this.deleteDialog.onConfirm = () => this.onDelete();
    this.deleteDialog.onCancel = () => {
      this.deleteForm.component.attr("action", ``);
    };

    this.editForm = new Form(
      "#edit-form",
      ["#edit-description-input", "#edit-value-input", "#edit-day-input"],
      new Button("#edit-edit-button")
    );

    this.editLink = new Link(".open-edit");

    this.editDialog = new Dialog(
      "#edit-dialog",
      new Button("#edit-cancel-button"),
      new Button("#edit-edit-button"),
      this.editLink
    );

    this.editLink.onClick = (e) => {
      const component = $(e.target);
      const expenseId = component.attr("data-id");
      const accountId = component.attr("data-account-id");
      const description = component.attr("data-description");
      const value = component.attr("data-value");
      const day = component.attr("data-day");

      this.editForm.component.attr(
        "action",
        `/expense/edit/${accountId}/${expenseId}`
      );

      $("#edit-description").val(description);
      $("#edit-value").val(value);
      $("#edit-day").val(day);
    };

    this.editDialog.onConfirm = () => this.onEdit();
    this.editDialog.onCancel = () => {
      this.editForm.component.attr("action", ``);
      $("#edit-description").val("");
      $("#edit-value").val("");
      $("#edit-day").val("");
    };

    this.onLoad();
  }

  onLoad() {
    this.createDialog.onClose();
    this.deleteDialog.onClose();
    this.editDialog.onClose();
  }

  onCreate() {
    this.createForm.component.submit();
  }

  onDelete() {
    this.deleteForm.component.submit();
  }

  onEdit() {
    this.editForm.component.submit();
  }
}
