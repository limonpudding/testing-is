import {Component, ViewChild, AfterViewInit} from '@angular/core';
import {TestService} from "../_service/test.service";
import {Test} from "../_model/test";
import {Observable} from "rxjs";

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements AfterViewInit {

  isLoading = true;
  testData = new Test();

  constructor(private testService: TestService) {}

  ngAfterViewInit(): void {
    this.isLoading = false;
    this.testService.getTestData('EASY').subscribe( data => this.testData = data);
  }
}
