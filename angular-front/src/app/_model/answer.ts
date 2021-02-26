export class Answer {

  id: number;
  questionId: number;
  answer: string;
  answerComment: string;
  isCorrect: boolean;
  points: number;

  constructor() {
    this.id = 0;
    this.questionId = 0;
    this.answer = '';
    this.answerComment = '';
    this.isCorrect = false;
    this.points = 0;
  }
}
