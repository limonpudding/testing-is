import {Question} from "./question";

export class Test {

  id: number;
  name: string;
  level: string;
  questions:Question[];

  constructor() {
    this.id = 0;
    this.name = '';
    this.level = '';
    this.questions = [];
  }
}
