import {Component, ViewChild, AfterViewInit} from '@angular/core';
import {TestService} from "../_service/test.service";
import {TestData} from "../_model/test-data";
import {Observable} from "rxjs";

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements AfterViewInit {

  isLoading = true;
  testData = new TestData();

  constructor(private testService: TestService) {}

  ngAfterViewInit(): void {
    this.isLoading = false;
    this.testService.getTestData('EASY').subscribe( data => this.testData = data);
  }
}
