import {Component, ViewChild, AfterViewInit} from '@angular/core';
import {TestService} from "../_service/test.service";
import {Test} from "../_model/test";
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {Level} from "../_model/level";

@Component({
  selector: 'app-test',
  templateUrl: './tests.component.html',
  styleUrls: ['./tests.component.scss']
})
export class TestsComponent implements AfterViewInit {

  isLoading = true;
  levels: Level[];

  constructor(private testService: TestService, private router: Router) {}

  ngAfterViewInit(): void {
    this.isLoading = false;
    this.testService.getLevels().subscribe( data => this.levels = data);
  }

  startExamination(level: string) {
    this.router.navigate(['/question', {ordinal: 0, level: level}]);
  }
}
