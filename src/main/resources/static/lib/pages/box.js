import { Form, Button, Dialog, Link } from "../components/index.js";
import { useState } from "../hooks/useState.js";
import { Page } from "./page.js";

export class Box extends Page {
  constructor() {
    super("Box");

    this.createForm = new Form(
      "#create-form",
      ["#name-input", "#value-input"],
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
      const boxId = component.attr("data-id");
      const accountId = component.attr("data-account-id");

      this.deleteForm.component.attr(
        "action",
        `/boxes/delete/${accountId}/${boxId}`
      );
    };

    this.deleteDialog.onConfirm = () => this.onDelete();
    this.deleteDialog.onCancel = () => {
      this.deleteForm.component.attr("action", ``);
    };

    this.addMoneyForm = new Form(
      "#add-money-form",
      ["#add-value-input"],
      new Button("#add-money-confirm-button")
    );

    this.addMoneyLink = new Link(".open-add-money");

    this.addMoneyDialog = new Dialog(
      "#add-money-dialog",
      new Button("#add-money-cancel-button"),
      new Button("#add-money-confirm-button"),
      this.addMoneyLink
    );

    this.addMoneyLink.onClick = (e) => {
      const component = $(e.target);
      const boxId = component.attr("data-id");
      const accountId = component.attr("data-account-id");

      this.addMoneyForm.component.attr(
        "action",
        `/boxes/add/${accountId}/${boxId}`
      );
    };

    this.addMoneyDialog.onConfirm = () => this.onAdd();
    this.addMoneyDialog.onCancel = () => {
      this.editForm.component.attr("action", ``);
      $("#add-value").val("");
    };

    this.editForm = new Form(
      "#edit-form",
      ["#edit-name-input", "#edit-value-input"],
      new Button("#edit-confirm-button")
    );

    this.editLink = new Link(".open-edit");

    this.editDialog = new Dialog(
      "#edit-dialog",
      new Button("#edit-cancel-button"),
      new Button("#edit-confirm-button"),
      this.editLink
    );

    this.editLink.onClick = (e) => {
      const component = $(e.target);
      const boxId = component.attr("data-id");
      const accountId = component.attr("data-account-id");
      const name = component.attr("data-name");
      const value = component.attr("data-value");

      this.editForm.component.attr(
        "action",
        `/boxes/edit/${accountId}/${boxId}`
      );

      $("#edit-name").val(name);
      $("#edit-value").val(value);
    };

    this.editDialog.onConfirm = () => this.onEdit();
    this.editDialog.onCancel = () => {
      this.editForm.component.attr("action", ``);
      $("#edit-name").val("");
      $("#edit-value").val("");
    };

    this.addPersonForm = new Form(
      "#add-person-form",
      ["#add-person-input"],
      new Button("#add-person-confirm-button")
    );

    this.addPersonLink = new Link(".open-add-person");

    this.addPersonDialog = new Dialog(
      "#add-person-dialog",
      new Button("#add-person-cancel-button"),
      new Button("#add-person-confirm-button"),
      this.addPersonLink
    );

    this.boxId = "";

    $("#add-person").change((e) => {
      const accountId = $(e.target).val();

      this.addPersonForm.component.attr(
        "action",
        `/boxes/include/${this.boxId}/${accountId}`
      );
    });

    this.addPersonLink.onClick = (e) => {
      const component = $(e.target);
      this.boxId = component.attr("data-id");
    };

    this.addPersonDialog.onConfirm = () => this.onAddPerson();
    this.addPersonDialog.onCancel = () => {
      this.addPersonForm.component.attr("action", ``);
      $("#add-person").val("");
    };

    this.onLoad();
  }

  onLoad() {
    this.createDialog.onClose();
    this.deleteDialog.onClose();
    this.addMoneyDialog.onClose();
    this.editDialog.onClose();
    this.addPersonDialog.onClose();
  }

  onCreate() {
    this.createForm.component.submit();
  }

  onDelete() {
    this.deleteForm.component.submit();
  }

  onAdd() {
    this.addMoneyForm.component.submit();
  }

  onAddPerson() {
    this.addPersonForm.component.submit();
  }

  onEdit() {
    this.editForm.component.submit();
  }
}
