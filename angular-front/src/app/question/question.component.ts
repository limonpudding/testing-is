import {Component, ViewChild, AfterViewInit} from '@angular/core';
import {Question} from "../_model/question";
import {QuestionService} from "../_service/question.service";
import {Observable} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {map, switchMap} from "rxjs/operators";
import {QuestionParams} from "../_model/question-params";

@Component({
  selector: 'app-test',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.scss']
})
export class QuestionComponent implements AfterViewInit {

  isLoading = true;
  question: Question;
  ordinal: number;
  level: string;

  constructor(private route: ActivatedRoute, private questionService: QuestionService) {
    this.route.paramMap.subscribe(params => {
      this.ordinal = Number(params.get('ordinal'));
      this.level = String(params.get('level'));
    });
    this.questionService.getQuestion(new QuestionParams(this.ordinal, this.level)).subscribe(data => this.question = data);
    this.isLoading = false;
  }

  ngAfterViewInit(): void {
  }

  nextQuestion() {
    this.isLoading = true;
    this.ordinal = this.ordinal + 1;
    this.questionService.getQuestion(new QuestionParams(this.ordinal, this.level)).subscribe(data => this.question = data);
    this.isLoading = false;
  }
}
