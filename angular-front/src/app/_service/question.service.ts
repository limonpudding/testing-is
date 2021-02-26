import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Question} from "../_model/question";
import {QuestionParams} from "../_model/question-params";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private _httpClient: HttpClient) {
  }

  generateExamination(level: string): void {
    const href = '/api/test/generate';
    this._httpClient.post<Question>(href, {'level': level});
  }

  getQuestion(questionParams: QuestionParams): Observable<Question> {
    const href = '/api/question/question';
    return this._httpClient.post<Question>(href, questionParams);
  }
}
