export class Question {
  private _level: string;
  private _text: string;
  private _answer1: string;
  private _answer2: string;
  private _answer3: string;
  private _answer4: string;
  private _correctAnswer: string;


  constructor() {
    this._level = '';
    this._text = '';
    this._answer1 = '';
    this._answer2 = '';
    this._answer3 = '';
    this._answer4 = '';
    this._correctAnswer = '';
  }


  get level(): string {
    return this._level;
  }

  get text(): string {
    return this._text;
  }

  get answer1(): string {
    return this._answer1;
  }

  get answer2(): string {
    return this._answer2;
  }

  get answer3(): string {
    return this._answer3;
  }

  get answer4(): string {
    return this._answer4;
  }

  get correctAnswer(): string {
    return this._correctAnswer;
  }
}
