import {Answer} from "./answer";

export class Question {

  id: number;
  testId: number;
  questionNumber: number;
  questionText: string;
  answers: Answer[];

  constructor() {
    this.id = 0;
    this.testId = 0;
    this.questionNumber = 0;
    this.questionText = '';
    this.answers = [];
  }
}
