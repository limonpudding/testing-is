import {Question} from "./question";

export class TestData {
  private _questions:Question[];

  constructor() {
    this._questions = [];
  }

  get questions(): Question[] {
    return this._questions;
  }
}
