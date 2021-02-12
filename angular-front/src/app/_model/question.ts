export class Question {
  level: string;
  questionText: string;
  answer1: string;
  answer2: string;
  answer3: string;
  answer4: string;
  answer1Comment: string;
  answer2Comment: string;
  answer3Comment: string;
  answer4Comment: string;
  correctAnswer: string;

  constructor() {
    this.level = '';
    this.questionText = '';
    this.answer1 = '';
    this.answer2 = '';
    this.answer3 = '';
    this.answer4 = '';
    this.answer1Comment = '';
    this.answer2Comment = '';
    this.answer3Comment = '';
    this.answer4Comment = '';
    this.correctAnswer = '';
  }
}
